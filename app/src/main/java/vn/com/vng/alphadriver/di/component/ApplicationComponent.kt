package vn.com.vng.alphadriver.di.component

import dagger.Component
import dagger.android.AndroidInjector
import vn.com.vng.alphadriver.MyApplication
import vn.com.vng.alphadriver.di.module.*
import javax.inject.Singleton

/**
 * App component that add all the module to dependency graph use to inject.
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AppSchedulerModule::class,
        RemoteModule::class,
        RepositoryModule::class,
        SubComponentModule::class,
        AppConfigModule::class
    ]
)
interface ApplicationComponent {
    fun activityComponent(): ActivityComponent.Factory

    fun fragmentComponent(): FragmentComponent.Factory
}