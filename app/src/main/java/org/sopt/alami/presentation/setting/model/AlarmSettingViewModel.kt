package org.sopt.alami.presentation.setting.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.alami.data.dto.request.AddAlarmRequest
import org.sopt.alami.data.dto.response.SuccessAdd
import org.sopt.alami.data.repository.AlarmRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AlarmSettingViewModel @Inject constructor(
    private val alarmRepository: AlarmRepository,
) : ViewModel() {

    val selectedHour = MutableStateFlow(1)
    val selectedMinute = MutableStateFlow(0)
    val isAm = MutableStateFlow(true)

    private val _alarmResult = MutableStateFlow<ResultState>(ResultState.Idle)
    val alarmResult: StateFlow<ResultState> = _alarmResult

    private val _selectedTime = MutableStateFlow(Calendar.getInstance())
    val selectedTime: StateFlow<Calendar> = _selectedTime

    fun onPickerTimeChanged(hour: Int, minute: Int, isAm: Boolean) {
        selectedHour.value = hour
        selectedMinute.value = minute
        this.isAm.value = isAm
        updateCalendar()
    }

    private fun updateCalendar() {
        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR, selectedHour.value)
            set(Calendar.MINUTE, selectedMinute.value)
            set(Calendar.SECOND, 0)
            set(Calendar.AM_PM, if (isAm.value) Calendar.AM else Calendar.PM)
        }
        _selectedTime.value = cal
    }

    fun addAlarm(userId: Long) {
        _alarmResult.value = ResultState.Loading
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        val timestamp = formatter.format(_selectedTime.value.time)
        val request = AddAlarmRequest(timestamp)

        viewModelScope.launch {
            val result = alarmRepository.addAlarm(userId, request)
            _alarmResult.value = result.fold(
                onSuccess = { ResultState.Success(it) },
                onFailure = { ResultState.Error(it.message ?: "오류 발생") }
            )
        }
    }

    sealed class ResultState {
        object Idle : ResultState()
        object Loading : ResultState()
        data class Success(val response: List<SuccessAdd>) : ResultState()
        data class Error(val message: String) : ResultState()
    }
}

