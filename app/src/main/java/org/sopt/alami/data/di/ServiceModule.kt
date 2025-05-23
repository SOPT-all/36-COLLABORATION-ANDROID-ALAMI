package org.sopt.alami.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.alami.data.repository.AlarmRepository
import org.sopt.alami.data.service.AddAlarmService
import org.sopt.alami.data.service.AlarmListService
import org.sopt.alami.data.service.MorningService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideAlarmListService(retrofit: Retrofit): AlarmListService =
        retrofit.create(AlarmListService::class.java)

    @Provides
    @Singleton
    fun provideMorningService(retrofit: Retrofit): MorningService =
        retrofit.create(MorningService::class.java)

    @Provides
    fun provideAlarmRepository(
        addAlarmService: AddAlarmService
    ): AlarmRepository = AlarmRepository(addAlarmService)
}
