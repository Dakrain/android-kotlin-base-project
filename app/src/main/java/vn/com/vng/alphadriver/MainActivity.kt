package vn.com.vng.alphadriver

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import vn.com.vng.alphadriver.base.BaseActivity
import vn.com.vng.alphadriver.di.component.ActivityComponent
import vn.com.vng.alphadriver.domain.interactors.GetPokemonUseCase
import javax.inject.Inject

class MainActivity : BaseActivity() {

    companion object {
        fun showMe(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var pokemonUseCase: GetPokemonUseCase

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupActivityComponent(mActivityComponent: ActivityComponent?) {
        mActivityComponent?.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
    }
}