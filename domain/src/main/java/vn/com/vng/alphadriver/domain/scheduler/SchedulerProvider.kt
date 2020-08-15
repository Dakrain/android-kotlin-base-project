package vn.com.vng.alphadriver.domain.scheduler

import io.reactivex.Scheduler

/**
 * Created by hrskrs on 5/8/2017.
 */
interface SchedulerProvider {
    fun ui(): Scheduler?
    fun computation(): Scheduler?
    fun io(): Scheduler?
    fun deleteThread(): Scheduler?
    fun downloadThread(): Scheduler?
}