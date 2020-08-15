package vn.com.vng.alphadriver.base

interface BaseContract {
    interface BasePresenter<ViewType : BaseContract.View?> {
        fun attachView(mvpView: ViewType)

        fun detachView()

        val mvpView: ViewType
    }

    interface View {
        fun showLoading()

        fun hideLoading()

        fun showMessage(msg: String)

        fun showError()
    }
}