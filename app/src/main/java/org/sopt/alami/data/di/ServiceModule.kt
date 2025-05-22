package org.sopt.alami.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.alami.data.service.AlarmListService
import org.sopt.alami.presentation.alarm.navigation.Alarm
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule{

    @Provides
    @Singleton
    fun provideAlarmListService(retrofit: Retrofit): AlarmListService =
        retrofit.create(AlarmListService::class.java)

}
