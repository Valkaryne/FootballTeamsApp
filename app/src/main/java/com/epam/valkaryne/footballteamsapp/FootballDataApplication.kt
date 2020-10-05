package com.epam.valkaryne.footballteamsapp

import android.app.Application
import com.epam.valkaryne.footballteamsapp.data.di.footballDataApiModule
import com.epam.valkaryne.footballteamsapp.data.di.retrofitModule
import com.epam.valkaryne.footballteamsapp.di.teamDetailsModule
import com.epam.valkaryne.footballteamsapp.di.teamsStatsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FootballDataApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@FootballDataApplication)
            modules(
                listOf(
                    retrofitModule,
                    footballDataApiModule,
                    teamsStatsModule,
                    teamDetailsModule
                )
            )
        }
    }
}