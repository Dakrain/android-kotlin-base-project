package vn.com.vng.alphadriver

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_debug.*
import kotlinx.android.synthetic.main.activity_main.*
import vn.com.vng.alphadriver.base.BaseActivity
import vn.com.vng.alphadriver.di.component.ActivityComponent
import vn.com.vng.alphadriver.domain.entity.Pokemon
import vn.com.vng.alphadriver.domain.interactors.GetPokemonUseCase
import vn.com.vng.alphadriver.rx.SimpleObserver
import javax.inject.Inject

class DebugActivity : BaseActivity() {

    @Inject
    lateinit var useCase: GetPokemonUseCase

    override fun getLayoutId(): Int = R.layout.activity_debug

    override fun setupActivityComponent(mActivityComponent: ActivityComponent?) {
        mActivityComponent?.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        btnFunc1.setOnClickListener {
            testFunction1()
        }

        btnFunc2.setOnClickListener {
            testFunction2()
        }

        btnFunc3.setOnClickListener {
            testFunction3()
        }

        btnGoToApp.setOnClickListener {
            //Go to main
            MainActivity.showMe(this)
        }
    }

    private fun testFunction1() {
    }

    private fun testFunction2() {
    }

    private fun testFunction3() {
        showLoading()
        useCase.getPokemonByName(edtPokemon.text.toString()).subscribeWith(object :
            SimpleObserver<Pokemon>() {
            override fun onResponse(t: Pokemon) {
                hideLoading()
                Log.d("KhoaLHD", t.toString())
            }

            override fun onResponseError(throwable: Throwable) {
                hideLoading()
                Log.d("KhoaLHD", "error ${Log.getStackTraceString(throwable)}")
            }
        })
    }
}