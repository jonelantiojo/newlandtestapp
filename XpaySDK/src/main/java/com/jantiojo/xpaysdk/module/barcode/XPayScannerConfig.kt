package com.jantiojo.xpaysdk.module.barcode

import com.jantiojo.xpaysdk.utils.toNewLandCameraType
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.devicemanager.CameraType
import com.newland.nsdk.core.api.internal.devicemanager.DeviceManager
import com.newland.nsdk.core.api.internal.devicemanager.ScannerConfig
import com.newland.nsdk.core.internal.NSDKModuleManagerImpl

class XPayScannerConfig {

    private val deviceManager: DeviceManager by lazy {
        NSDKModuleManagerImpl.getInstance().getModule(ModuleType.DEVICE_MANAGER) as DeviceManager
    }
    private lateinit var scannerConfig: ScannerConfig

    init {
        try {
            scannerConfig = deviceManager.deviceInfo.scannerConfig
        } catch (e: NSDKException) {
            //Handle the exception
        }
    }


    fun hasFrontCamera(): Boolean {
        return try {
            scannerConfig.hasFrontCamera()
        } catch (e: NSDKException) {
            //Handle the exception
            false
        }
    }

    fun hasBackCamera(): Boolean {
        return try {
            scannerConfig.hasBackCamera()
        } catch (e: NSDKException) {
            //Handle the exception
            false
        }
    }

    fun hasPaymentCamera(): Boolean {
        return try {
            scannerConfig.hasPaymentCamera()
        } catch (e: NSDKException) {
            //Handle the exception
            false
        }
    }

    fun hasFrontScanner(): Boolean {
        return try {
            scannerConfig.hasFrontScanner()
        } catch (e: NSDKException) {
            //Handle the exception
            false
        }
    }


    fun getCameraID(cameraType: XPayCameraType) : Int {
        return scannerConfig.getCameraID(cameraType.toNewLandCameraType())
    }
}