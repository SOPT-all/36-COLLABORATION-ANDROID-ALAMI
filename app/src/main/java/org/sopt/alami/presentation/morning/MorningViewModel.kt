package org.sopt.alami.presentation.morning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.alami.data.repository.MorningRepository
import org.sopt.alami.presentation.morning.model.WeatherType
import timber.log.Timber

data class MorningWeatherUiState(
    val temperature: Int = 0,
    val currentDate: String = "",
    val weatherType: WeatherType = WeatherType.SUNNY
)

data class MorningSentenceUiState(
    val imageUrl: Int = -1
)

@HiltViewModel
class MorningViewModel @Inject constructor(
    private val morningRepository: MorningRepository
) : ViewModel() {
    private val _weatherState = MutableStateFlow(MorningWeatherUiState())
    val weatherState: StateFlow<MorningWeatherUiState> = _weatherState.asStateFlow()

    private val _sentenceState = MutableStateFlow(MorningSentenceUiState())
    val sentenceState: StateFlow<MorningSentenceUiState> = _sentenceState.asStateFlow()

    init {
        fetchWeatherData()
        fetchSentenceData()
    }

    fun fetchWeatherData() {
        viewModelScope.launch {
            morningRepository.getTodayWeather()
                .onSuccess { weather ->
                    _weatherState.value = MorningWeatherUiState(
                        temperature = weather.temperature,
                        currentDate = weather.date,
                        weatherType = mapWeatherCodeToType(weather.weatherCode)
                    )
                }
                .onFailure { e ->
                    Timber.e(e)
                }
        }
    }

    fun fetchSentenceData() {
        viewModelScope.launch {
            morningRepository.getTodaySentence()
                .onSuccess { sentence ->
                    _sentenceState.value = MorningSentenceUiState(
                        imageUrl = sentence.imageNum
                    )
                }
        }
    }

    private fun mapWeatherCodeToType(weatherCode: Int): WeatherType {
        return when (weatherCode) {
            1 -> WeatherType.SUNNY
            2 -> WeatherType.RAINY
            3 -> WeatherType.CLOUDY
            else -> WeatherType.SUNNY
        }
    }
}
