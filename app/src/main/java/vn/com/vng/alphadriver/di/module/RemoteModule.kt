package vn.com.vng.alphadriver.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.com.vng.alphadriver.BuildConfig
import vn.com.vng.alphadriver.domain.appconfig.AppConfig
import vn.com.vng.alphadriver.data.service.ApiService
import javax.inject.Singleton

/**
 * Provide remote module
 */
@Module
object RemoteModule {
    @Provides
    @Singleton
    fun provideApiService(appConfig: AppConfig): ApiService {
        val endPoint = BuildConfig.BASE_URL
        val okHttpClient =
            createOkHttp(appConfig)
        val retrofit =
            createRetrofit(
                okHttpClient,
                endPoint
            )
        return retrofit.build().create(ApiService::class.java)
    }


    private fun createOkHttp(appConfig: AppConfig): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder()
        if (appConfig.isShowLogAPI()) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return clientBuilder.build()
    }

    private fun createRetrofit(okHttpClient: OkHttpClient, endPoint: String): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(endPoint)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

}