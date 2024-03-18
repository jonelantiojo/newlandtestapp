package com.jantiojo.xpaysdk.module.device

import com.jantiojo.xpaysdk.module.barcode.XPayScannerConfig
import com.jantiojo.xpaysdk.module.card.XPayCardSlot

data class XPayDeviceInfo(
    val sn: String,
    val pn: String,
    val firmVer: String,
    val contactlessVer: String,
    val isSupportUSB: Boolean,
    val isSupportOffline: Boolean,
    val isSupportMagCard: Boolean,
    val isSupportICCard: Boolean,
    val isSupportQuickPass: Boolean,
    val isSupportPrint: Boolean,
    val isSupportGPS: Boolean,
    val isSupportEthernet: Boolean,
    val isSupportCashBox: Boolean,
    val isSupportSam: Boolean,
    val isSupportPinpadPort: Boolean,
    val isSupport232Port: Boolean,
    val isSupportCamera: Boolean,
    val xPayScannerConfig: XPayScannerConfig,
    val customerID: String,
    val isSupportGuestDisplay: Boolean,
    val isSupportBeep: Boolean,
    val isSupportSubScreen: Boolean,
    val contactCardSlots: List<XPayCardSlot>,
    val deviceModel: String,
    val androidVersion: Int,
    val ledConfig: Int,
    val isPhysicalKeyboard: Boolean
)