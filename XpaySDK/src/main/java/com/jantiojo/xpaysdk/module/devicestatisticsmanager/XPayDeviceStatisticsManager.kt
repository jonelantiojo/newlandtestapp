package com.jantiojo.xpaysdk.module.devicestatisticsmanager

import com.jantiojo.xpaysdk.module.XPayModule
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.devicestatisticsmanager.DeviceStatisticsManager

class XPayDeviceStatisticsManager : XPayModule() {

    private val statisticsManager by lazy { xPayModuleManager.getModule(ModuleType.DEVICE_STATISTICS_MANAGER) as DeviceStatisticsManager }

    val deviceStatisticsInfo: String = statisticsManager.deviceStatisticsInfo

    fun getDeviceStatisticsInfoByTag(tag: String): String {
        return try {
            statisticsManager.getDeviceStatisticsInfoByTag(tag)
        } catch (e: NSDKException) {
            ""
        }
    }
}