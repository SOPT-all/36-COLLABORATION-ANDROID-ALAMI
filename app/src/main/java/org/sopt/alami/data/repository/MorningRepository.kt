package org.sopt.alami.data.repository

import javax.inject.Inject
import org.sopt.alami.data.mapper.toPresentation
import org.sopt.alami.data.service.MorningService
import org.sopt.alami.presentation.morning.model.MorningSentence
import org.sopt.alami.presentation.morning.model.MorningWeather

class MorningRepository @Inject constructor(
    private val morningService: MorningService
) {
    suspend fun getTodaySentence(): Result<MorningSentence> =
        runCatching {
            morningService.getTodaySentence().data!!.toPresentation()
        }

    suspend fun getTodayWeather(): Result<MorningWeather> =
        runCatching {
            morningService.getTodayWeather().data!!.toPresentation()
        }
}
