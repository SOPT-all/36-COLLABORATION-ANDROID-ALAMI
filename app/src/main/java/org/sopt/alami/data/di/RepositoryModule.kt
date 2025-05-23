package org.sopt.alami.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.alami.data.repository.AlarmRepository
import org.sopt.alami.data.service.AddAlarmService

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAlarmRepository(
        addAlarmService: AddAlarmService
    ): AlarmRepository = AlarmRepository(addAlarmService)
}
