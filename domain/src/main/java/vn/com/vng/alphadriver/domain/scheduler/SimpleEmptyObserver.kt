package vn.com.vng.alphadriver.domain.scheduler

import io.reactivex.observers.DisposableObserver

class SimpleEmptyObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {}

    override fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }

    override fun onComplete() {}
}