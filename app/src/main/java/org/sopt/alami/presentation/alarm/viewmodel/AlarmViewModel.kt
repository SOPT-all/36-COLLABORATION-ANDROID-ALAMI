package org.sopt.alami.presentation.alarm.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class AlarmViewModel @Inject constructor() : ViewModel() {

    private val _isAlarmEnabled = MutableStateFlow(false)
    val isAlarmEnabled: StateFlow<Boolean> = _isAlarmEnabled.asStateFlow()

    fun setAlarmEnabled(isEnabled: Boolean) {
         _isAlarmEnabled.value = isEnabled
    }



}