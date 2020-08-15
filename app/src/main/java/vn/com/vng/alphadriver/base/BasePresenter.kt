package vn.com.vng.alphadriver.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class BasePresenter<T : BaseContract.View> constructor(var compositeDisposable: CompositeDisposable) :
    BaseContract.BasePresenter<T> {

    init {
        compositeDisposable = CompositeDisposable()
    }

    override lateinit var mvpView: T

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    protected fun addToDisposable(observer: DisposableObserver<*>?) {
        compositeDisposable!!.add(observer!!)
    }


}