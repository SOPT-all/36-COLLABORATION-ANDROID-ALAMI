package org.sopt.alami.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.sopt.alami.data.service.MorningService
import org.sopt.alami.data.service.AlarmListService
import retrofit2.Retrofit

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
}
