package vn.com.vng.alphadriver.di.module

import dagger.Module
import vn.com.vng.alphadriver.di.component.ActivityComponent
import vn.com.vng.alphadriver.di.component.FragmentComponent

/**
 * Component that inject android view
 */
@Module(
    subcomponents = [
        ActivityComponent::class,
        FragmentComponent::class
    ]
)
class SubComponentModule {
}