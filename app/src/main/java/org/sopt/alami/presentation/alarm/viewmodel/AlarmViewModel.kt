package org.sopt.alami.presentation.alarm.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.alami.data.dto.AlarmListDto
import org.sopt.alami.data.repository.AlarmListRepository
import org.sopt.alami.presentation.alarm.model.AlarmCardState
import org.sopt.alami.presentation.alarm.model.toAlarmCardState
import timber.log.Timber

@HiltViewModel
class AlarmViewModel @Inject constructor(
    private val repository: AlarmListRepository
) : ViewModel() {

    var alarmList by mutableStateOf<List<AlarmCardState>>(emptyList())



    private val _isAlarmEnabled = MutableStateFlow(false)
    val isAlarmEnabled: StateFlow<Boolean>
        get() = _isAlarmEnabled.asStateFlow()

    init {
        fetchAlarm(userId = 1)
    }

    fun fetchAlarm(userId: Long) {
        viewModelScope.launch {
            repository.getAlarmList(userId)
                .onSuccess {
                    alarmList = it.map { dto -> dto.toAlarmCardState() }

                }
                .onFailure {
                    Timber.e("알람 목록 불러오기 실패 : ${it.message}")
                }
        }
    }

    fun setAlarmEnabled(index: Int, isEnabled: Boolean) {
        alarmList = alarmList.toMutableList().also {
            it[index] = it[index].copy(isAlarmEnabled = isEnabled)
        }
    }

    fun checkAlarmTime(userId: Long) {
        viewModelScope.launch {
            repository.getAlarmTimeCheck(userId)
                .onSuccess { result->

                    val shouldTrigger = result?.alarmInfo?.any {it.shouldTrigger} == true

                    if (shouldTrigger) {

                    }

                }
                .onFailure {
                    Timber.e("알람 체크 실패 : ${it.message}")
                }
        }
    }
}
