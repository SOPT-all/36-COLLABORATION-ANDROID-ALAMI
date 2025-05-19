package org.sopt.alami.presentation.alarm.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AlarmViewModel @Inject constructor() : ViewModel() {

    private val _isAlarmEnabled = MutableStateFlow(false)
    val isAlarmEnabled: StateFlow<Boolean> = _isAlarmEnabled.asStateFlow()

    fun setAlarmEnabled(isEnabled: Boolean) {
        _isAlarmEnabled.value = isEnabled
    }
}
