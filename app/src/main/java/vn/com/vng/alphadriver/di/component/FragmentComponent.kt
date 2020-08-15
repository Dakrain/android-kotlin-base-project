package vn.com.vng.alphadriver.di.component

import dagger.Subcomponent
import vn.com.vng.alphadriver.di.scope.FragmentScope

/**
 * Component that inject all the app fragment
 */
@FragmentScope
@Subcomponent
interface FragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : FragmentComponent
    }

    //Inject fragment here
}