package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.barcode.XPayBarcodeScanParameter
import com.jantiojo.xpaysdk.module.barcode.XPayCameraType
import com.jantiojo.xpaysdk.module.barcode.XPayScannerConfig
import com.newland.nsdk.core.api.internal.barcodescanner.ScanParameters
import com.newland.nsdk.core.api.internal.devicemanager.CameraType
import com.newland.nsdk.core.api.internal.devicemanager.ScannerConfig

internal fun XPayBarcodeScanParameter.toNewLandScanParameter(): ScanParameters {
    val scanParameters = ScanParameters()
    scanParameters.timeout = this.timeout
    scanParameters.focusMode = this.focusMode
    scanParameters.isSoundSwitcher = this.isSoundSwitcher
    return scanParameters
}

internal fun XPayCameraType.toNewLandCameraType(): CameraType {
    return when (this) {
        XPayCameraType.BACK -> CameraType.BACK
        XPayCameraType.FRONT -> CameraType.FRONT
        XPayCameraType.PAYMENT -> CameraType.PAYMENT
    }
}

internal fun ScannerConfig.toXPayScannerConfig(): XPayScannerConfig {
    return XPayScannerConfig(
        frontCamera = hasFrontCamera(),
        backCamera = hasBackCamera(),
        paymentCamera = hasPaymentCamera(),
        frontScanner = hasFrontScanner(),
        softDecoding = supportSoftDecoding(),
        hardScanning = supportHardScanning()
    )
}
