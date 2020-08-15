package vn.com.vng.alphadriver.di.module

import dagger.Binds
import dagger.Module
import vn.com.vng.alphadriver.config.AppConfigImpl
import vn.com.vng.alphadriver.domain.appconfig.AppConfig

/**
 * Module for config
 */
@Module
abstract class AppConfigModule {
    @Binds
    abstract fun provideAppConfig(appConfig: AppConfigImpl): AppConfig
}