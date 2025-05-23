package org.sopt.alami.data.mapper

import org.sopt.alami.data.dto.response.TodaySentenceResponseDto
import org.sopt.alami.data.dto.response.TodayWeatherResponseDto
import org.sopt.alami.presentation.morning.model.MorningSentence
import org.sopt.alami.presentation.morning.model.MorningWeather

fun TodaySentenceResponseDto.toPresentation() = MorningSentence(
    imageNum = this.imageNum
)

fun TodayWeatherResponseDto.toPresentation() = MorningWeather(
    date = this.date,
    temperature = this.temperature,
    weatherCode = this.weatherCode
)
