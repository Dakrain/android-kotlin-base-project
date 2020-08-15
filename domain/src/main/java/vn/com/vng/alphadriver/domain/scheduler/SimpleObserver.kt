package vn.com.vng.alphadriver.domain.scheduler

import io.reactivex.observers.DisposableObserver

abstract class SimpleObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {
        try {
            onResponse(t)
        } catch (e: Exception) {
            onError(e)
        }
    }

    override fun onError(throwable: Throwable) {
        try {
            onResponseError(throwable)
            throwable.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(Exception::class)
    abstract fun onResponse(t: T)

    @Throws(Exception::class)
    abstract fun onResponseError(throwable: Throwable)
    override fun onComplete() {}
}