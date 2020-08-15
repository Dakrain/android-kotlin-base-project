package vn.com.vng.alphadriver.di.module

import dagger.Binds
import dagger.Module
import vn.com.vng.alphadriver.domain.scheduler.SchedulerProvider
import vn.com.vng.alphadriver.rx.SchedulerProviderImpl

@Module
abstract class AppSchedulerModule {
    @Binds
    abstract fun bindAppScheduler(schedulerProviderImpl: SchedulerProviderImpl): SchedulerProvider
}