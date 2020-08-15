package vn.com.vng.alphadriver.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import vn.com.vng.alphadriver.R
import javax.inject.Singleton

/**
 * Module provide resources to app-wide
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideApplicationContext(): Application = application

    //Gson


    //Sharedpreference
    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences? = application.getSharedPreferences(
        application.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )
}