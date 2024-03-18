package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.barcode.XPayScannerConfig
import com.jantiojo.xpaysdk.module.card.XPayCardSlot
import com.jantiojo.xpaysdk.module.device.XPayDeviceInfo
import com.jantiojo.xpaysdk.module.device.XPayRadarGain
import com.jantiojo.xpaysdk.module.device.XPayTamperReason
import com.jantiojo.xpaysdk.module.device.XPayTamperStatus
import com.newland.nsdk.core.api.internal.devicemanager.DeviceInfo
import com.newland.nsdk.core.api.internal.devicemanager.RadarGain
import com.newland.nsdk.core.api.internal.devicemanager.TamperReason
import com.newland.nsdk.core.api.internal.devicemanager.TamperStatus

internal fun DeviceInfo.toXPayDeviceInfo(): XPayDeviceInfo {
    return XPayDeviceInfo(
        sn = this.sn,
        pn = this.pn,
        firmVer = this.firmwareVer,
        contactlessVer = this.contactlessVer,
        isSupportUSB = this.isSupportUSB,
        isSupportOffline = this.isSupportOffline,
        isSupportMagCard = this.isSupportMagCard,
        isSupportICCard = this.isSupportICCard,
        isSupportQuickPass = this.isSupportQuickPass,
        isSupportPrint = this.isSupportPrint,
        isSupportGPS = this.isSupportGPS,
        isSupportEthernet = this.isSupportEthernet,
        isSupportCashBox = this.isSupportCashBox,
        isSupportSam = this.isSupportSam,
        isSupportPinpadPort = this.isSupportPinpadPort,
        isSupport232Port = this.isSupport232Port,
        isSupportCamera = this.isSupportCamera,
        xPayScannerConfig = this.scannerConfig.toXPayScannerConfig(),
        customerID = this.customerID,
        isSupportGuestDisplay = this.isSupportGuestDisplay,
        isSupportBeep = this.isSupportBeep,
        isSupportSubScreen = this.isSupportUSB,
        contactCardSlots = this.contactCardSlots.map { it.toXPayCardSlot() },
        deviceModel = this.deviceModel,
        androidVersion = this.androidVersion,
        ledConfig = this.ledConfig,
        isPhysicalKeyboard = this.isPhysicalKeyboard
    )
}

internal fun TamperStatus.toXPayTamperStatus(): XPayTamperStatus {
    return when (this) {
        TamperStatus.NONE -> XPayTamperStatus.NONE
        TamperStatus.HARDWARE -> XPayTamperStatus.HARDWARE
        TamperStatus.SEC_CONFIG -> XPayTamperStatus.SEC_CONFIG
        TamperStatus.CHECK_FILE -> XPayTamperStatus.CHECK_FILE
        TamperStatus.DEVICE_DISABLED -> XPayTamperStatus.DEVICE_DISABLED
    }
}

internal fun XPayRadarGain.toNewLandTamperStatus(): RadarGain {
    return when (this) {
        XPayRadarGain.RADAR_GAIN_0x0B -> RadarGain.RADAR_GAIN_0x0B
        XPayRadarGain.RADAR_GAIN_0x1B -> RadarGain.RADAR_GAIN_0x1B
        XPayRadarGain.RADAR_GAIN_0x2B -> RadarGain.RADAR_GAIN_0x2B
        XPayRadarGain.RADAR_GAIN_0x3B -> RadarGain.RADAR_GAIN_0x3B
        XPayRadarGain.RADAR_GAIN_0x4B -> RadarGain.RADAR_GAIN_0x4B
        XPayRadarGain.RADAR_GAIN_0x5B -> RadarGain.RADAR_GAIN_0x5B
        XPayRadarGain.RADAR_GAIN_0x6B -> RadarGain.RADAR_GAIN_0x6B
        XPayRadarGain.RADAR_GAIN_0x7B -> RadarGain.RADAR_GAIN_0x7B
        XPayRadarGain.RADAR_GAIN_0x8B -> RadarGain.RADAR_GAIN_0x8B
        XPayRadarGain.RADAR_GAIN_0x9B -> RadarGain.RADAR_GAIN_0x9B
        XPayRadarGain.RADAR_GAIN_0xAB -> RadarGain.RADAR_GAIN_0xAB
        XPayRadarGain.RADAR_GAIN_0xBB -> RadarGain.RADAR_GAIN_0xBB
        XPayRadarGain.RADAR_GAIN_0xCB -> RadarGain.RADAR_GAIN_0xCB
    }
}

internal fun TamperReason.toXPayTamperStatus(): XPayTamperReason {
    return when (this) {
        TamperReason.NONE -> XPayTamperReason.NONE
        TamperReason.K21_BUTTON_BATTERY_DEAD -> XPayTamperReason.K21_BUTTON_BATTERY_DEAD
        TamperReason.K21_TAMPER_5_TRIGGERED -> XPayTamperReason.K21_TAMPER_5_TRIGGERED
        TamperReason.K21_TAMPER_2_TRIGGERED -> XPayTamperReason.K21_TAMPER_2_TRIGGERED
        TamperReason.K21_TAMPER_0_TRIGGERED -> XPayTamperReason.K21_TAMPER_0_TRIGGERED
        TamperReason.K21_TAMPER_1_TRIGGERED -> XPayTamperReason.K21_TAMPER_1_TRIGGERED
        TamperReason.CHIP_1902_TAMPER_2_TRIGGERED -> XPayTamperReason.CHIP_1902_TAMPER_2_TRIGGERED
        TamperReason.CHIP_1902_TAMPER_0_TRIGGERED -> XPayTamperReason.CHIP_1902_TAMPER_0_TRIGGERED
        TamperReason.CHIP_1902_TAMPER_1_TRIGGERED -> XPayTamperReason.CHIP_1902_TAMPER_1_TRIGGERED
        TamperReason.CHIP_1902_TAMPER_3_TRIGGERED -> XPayTamperReason.CHIP_1902_TAMPER_3_TRIGGERED
        TamperReason.CHIP_3682_TAMPER_4_TRIGGERED -> XPayTamperReason.CHIP_3682_TAMPER_4_TRIGGERED
        TamperReason.CHIP_3682_TAMPER_5_TRIGGERED -> XPayTamperReason.CHIP_3682_TAMPER_5_TRIGGERED
        TamperReason.CHIP_3652_BUTTON_BATTERY_DEAD -> XPayTamperReason.CHIP_3652_BUTTON_BATTERY_DEAD
        TamperReason.ANTI_CUTTING_MACHINE_AUTH_FAILED -> XPayTamperReason.ANTI_CUTTING_MACHINE_AUTH_FAILED
        TamperReason.NO_ANTI_CUTTING_MACHINE_AUTH -> XPayTamperReason.NO_ANTI_CUTTING_MACHINE_AUTH
        TamperReason.P2D_AUTH_FAILED -> XPayTamperReason.P2D_AUTH_FAILED
        TamperReason.D2P_AUTH_FAILED -> XPayTamperReason.D2P_AUTH_FAILED
    }
}