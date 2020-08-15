package vn.com.vng.alphadriver.domain.appconfig

interface AppConfig {

    // môi trường
    fun isProduction(): Boolean

    // Giả lập mạng chậm
    fun isSimulateSlowNetWork(): Boolean

    fun getSimulateNetWorkTime(): Long

    // Show log mạng chậm
    fun isShowLogAPI(): Boolean

    // Show screen test
    fun isShowTestScreen(): Boolean
}