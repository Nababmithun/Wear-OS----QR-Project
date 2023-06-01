package com.ewnbd.lifvesafer.di

import android.app.Application

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  /*  @Singleton
    @Provides
    fun provideSignUpRepository(context: Application): SignUpRepository {
        return SignUpRepositoryImpl(context)
    }

    @Singleton
    @Provides
    fun provideOtpRepository(): OtpRepository {
        return OtpRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideSignInRepository(context: Application): SignInRepository {
        return SignInRepositoryImpl(context)
    }

    @Singleton
    @Provides
    fun provideForgetRepository(context: Application): ForgetRepository {
        return ForgetRepositoryImpl(context)
    }

    @Singleton
    @Provides
    fun provideNewPasswordRepository(context: Application, preferences: Preferences): NewPasswordRepository {
        return NewPasswordRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideTrackingRepository(context: Application, preferences: Preferences): TrackingRepository {
        return TrackingRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(context: Application, preferences: Preferences): HomeRepository {
        return HomeRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideAlertRepository(context: Application, preferences: Preferences): AlertRepository {
        return AlertRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideProfileRepository(context: Application, preferences: Preferences): ProfileRepository {
        return ProfileRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideReportRepository(context: Application, preferences: Preferences): ReportRepository {
        return ReportRepositoryImpl(context, preferences)
    }

    @Singleton
    @Provides
    fun provideNotificationRepository(context: Application, preferences: Preferences): NotificationRepository {
        return NotificationRepositoryImpl(context, preferences)
    }*/

}
