package com.jantiojo.xpaysdk.module.device

import android.content.Context
import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandTamperStatus
import com.jantiojo.xpaysdk.utils.toXPayDeviceInfo
import com.jantiojo.xpaysdk.utils.toXPayTamperStatus
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.devicemanager.DeviceManager
import java.util.Date

class XPayDeviceManager : XPayModule() {

    private val deviceManager by lazy { xPayModuleManager.getModule(ModuleType.DEVICE_MANAGER) as DeviceManager }

    fun setPOSDate(posDate: Date) {
        try {
            deviceManager.posDate = posDate
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    fun getPOSDate(): Date = deviceManager.posDate

    fun getDeviceInfo(): XPayDeviceInfo {
        return deviceManager.deviceInfo.toXPayDeviceInfo()
    }

    fun isExistSecurityModule() = deviceManager.isExistSecurityModule

    fun getSDKVersion() = deviceManager.sdkVersion

    fun getTamperStatus(): XPayTamperStatus {
        return deviceManager.tamperStatus.toXPayTamperStatus()
    }

    fun getNonDeletableAppList(context: Context): List<String> {
        return deviceManager.getNonDeletableAppList(context)
    }

    fun setKeyVolume(value: Boolean) {
        deviceManager.setKeyVolume(value)
    }

    fun setRadarDetectionDistance(radarGain: XPayRadarGain, i: Int) {
        deviceManager.setRadarDetectionDistance(radarGain.toNewLandTamperStatus(), i)
    }

    fun getTamperReasons(): List<XPayTamperReason> {
        return deviceManager.tamperReason.map { it.toXPayTamperStatus() }
    }
}