package com.ewnbd.lifvesafer.di

import android.app.Application
import com.ewnbd.lifvesafer.commons.repository.implementation.PreferencesImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePreferences(context: Application): PreferencesImpl {
        return PreferencesImpl(context)
    }

}
