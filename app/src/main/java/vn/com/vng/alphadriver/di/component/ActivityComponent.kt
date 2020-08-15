package vn.com.vng.alphadriver.di.component

import dagger.Subcomponent
import vn.com.vng.alphadriver.DebugActivity
import vn.com.vng.alphadriver.MainActivity
import vn.com.vng.alphadriver.di.scope.ActivityScope

/**
 * Component that inject all the app activity
 */
@ActivityScope
@Subcomponent
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    //Inject Activity here
    fun inject(activity: MainActivity)

    fun inject(activity: DebugActivity)
}