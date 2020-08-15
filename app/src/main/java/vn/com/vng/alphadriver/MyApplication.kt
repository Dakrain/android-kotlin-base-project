package vn.com.vng.alphadriver

import android.app.Application
import android.content.Context
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso
import vn.com.vng.alphadriver.di.component.ApplicationComponent
import vn.com.vng.alphadriver.di.component.DaggerApplicationComponent
import vn.com.vng.alphadriver.di.module.RemoteModule


class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        setupPicasso()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .build()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    private fun setupPicasso() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttpDownloader(this, MAX_DISK_CACHE_SIZE.toLong()))
        val built = builder.build()

        if (BuildConfig.DEBUG) {
            built.setIndicatorsEnabled(true)
            built.isLoggingEnabled = true
        }
        Picasso.setSingletonInstance(built)
    }

    companion object {
        private const val MAX_DISK_CACHE_SIZE = 32 * 1024 * 1024 // 32MB
    }
}