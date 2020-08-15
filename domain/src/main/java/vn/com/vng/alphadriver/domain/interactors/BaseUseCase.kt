package vn.com.vng.alphadriver.domain.interactors

import io.reactivex.Observable
import vn.com.vng.alphadriver.domain.authen.AuthenProvider
import vn.com.vng.alphadriver.domain.scheduler.SchedulerProvider

open class BaseUseCase constructor(
    val schedulerProvider: SchedulerProvider
) {


    protected fun <T> doOnBackground(observable: Observable<T>): Observable<T>? {
        return observable
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }

//    protected fun getAuthen(): String? {
//        return authenProvider.authen
//    }
}