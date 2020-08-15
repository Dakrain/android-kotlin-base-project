package vn.com.vng.alphadriver.config

import vn.com.vng.alphadriver.domain.appconfig.AppConfig
import javax.inject.Inject

/**
 * App config
 */
const val SIMULATE_BAD_NET_WORK_TIME: Long = 2000

class AppConfigImpl @Inject constructor() : AppConfig {

    override fun isProduction(): Boolean = false

    override fun isSimulateSlowNetWork(): Boolean = false

    override fun getSimulateNetWorkTime(): Long = SIMULATE_BAD_NET_WORK_TIME

    override fun isShowLogAPI(): Boolean = true

    override fun isShowTestScreen(): Boolean = true
}