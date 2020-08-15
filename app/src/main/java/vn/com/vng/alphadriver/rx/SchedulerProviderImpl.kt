package vn.com.vng.alphadriver.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.com.vng.alphadriver.domain.scheduler.SchedulerProvider
import javax.inject.Inject

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    private val downloadThread: Scheduler? = null

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun deleteThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun downloadThread(): Scheduler {
        return Schedulers.single()
    }
}