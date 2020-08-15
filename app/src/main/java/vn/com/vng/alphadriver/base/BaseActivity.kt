package vn.com.vng.alphadriver.base

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager.BadTokenException
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import vn.com.vng.alphadriver.BuildConfig
import vn.com.vng.alphadriver.MyApplication
import vn.com.vng.alphadriver.R
import vn.com.vng.alphadriver.di.component.ActivityComponent

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    private lateinit var activityComponent: ActivityComponent
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent =
            (application as MyApplication)
                .applicationComponent
                .activityComponent()
                .create()

        // Setup Activity Component
        setupActivityComponent(activityComponent)

        // Set Content View
        setContentView(getLayoutId())

        onActivityCreated(savedInstanceState)
    }

    override fun showLoading() {
        if (progressDialog != null && progressDialog!!.isShowing)
            return
        progressDialog = showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (progressDialog?.isShowing == true) {
            progressDialog?.cancel()
        }
    }

    override fun showMessage(msg: String) {

    }

    override fun showError() {

    }


    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun setupActivityComponent(mActivityComponent: ActivityComponent?)

    protected abstract fun onActivityCreated(savedInstanceState: Bundle?)

    private fun showLoadingDialog(context: Context?): ProgressDialog? {
        return if (context == null) {
            null
        } else try {
            val progressDialog =
                ProgressDialog.show(context, null, null, true, false)
            if (progressDialog.window != null) {
                progressDialog.window!!
                    .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog
        } catch (e: BadTokenException) {
            ProgressDialog(context)
        }
    }

}