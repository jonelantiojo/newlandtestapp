package com.jantiojo.xpaysdk

import android.content.Context
import com.jantiojo.xpaysdk.module.XPayBeeper
import com.jantiojo.xpaysdk.module.XPayCashBox
import com.jantiojo.xpaysdk.module.led.XPayLED
import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.module.XPaySettingManager
import com.jantiojo.xpaysdk.module.barcode.XPayBarcodeDecoder
import com.jantiojo.xpaysdk.module.barcode.XPayBarcodeScanner
import com.jantiojo.xpaysdk.module.bootprovider.XPayBootProvider
import com.jantiojo.xpaysdk.module.card.XPayCardReader
import com.jantiojo.xpaysdk.module.crypto.XPayCrypto
import com.jantiojo.xpaysdk.module.device.XPayDeviceManager
import com.jantiojo.xpaysdk.module.devicestatisticsmanager.XPayDeviceStatisticsManager
import com.jantiojo.xpaysdk.module.ethernetmanager.XPayEthernetManager
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyManager
import com.jantiojo.xpaysdk.module.pinentry.XPayPINEntry
import com.jantiojo.xpaysdk.module.printer.XPayPrinter
import com.jantiojo.xpaysdk.module.recovery.XPayRecovery
import com.jantiojo.xpaysdk.module.routemanager.XPayRouteManager
import com.jantiojo.xpaysdk.module.serialportmanager.XPaySerialPortManager
import com.newland.nsdk.core.api.common.ErrorCode
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.common.utils.LogLevel
import com.newland.nsdk.core.api.common.utils.NativeDebugLevel
import com.newland.nsdk.core.api.internal.NSDKModuleManager
import com.newland.nsdk.core.internal.NSDKModuleManagerImpl

/**
 * implementation class to share with other clients or entity
 */
class XPayModuleManager : XPayModuleProvider {

    private val moduleManager: NSDKModuleManager by lazy {
        NSDKModuleManagerImpl.getInstance()
    }

    override fun setup(context: Context) {
        moduleManager.setDebugMode(LogLevel.VERBOSE)

        try {
            moduleManager.setNativeDebugMode(NativeDebugLevel.ALL_ON)
            moduleManager.init(context)
        } catch (e: NSDKException) {
            e.printStackTrace()
            if (e.code == ErrorCode.NEED_UPDATE) {
                //Add Error Listener Here
                //for firmware update message
            } else {
                //Add Error Listener Here
                //that Failed initializing module
            }
        }
    }

    override fun close() {
        moduleManager.destroy()
    }

    override fun getXPayModule(xPayModuleType: XPayModuleType): XPayModule {
        return when (xPayModuleType) {
            XPayModuleType.LED -> XPayLED()
            XPayModuleType.BEEPER -> XPayBeeper()
            XPayModuleType.CARD_READER -> XPayCardReader()
            XPayModuleType.CRYPTO -> XPayCrypto()
            XPayModuleType.KEY_MANAGER -> XPayKeyManager()
            XPayModuleType.PIN_ENTRY -> XPayPINEntry()
            XPayModuleType.DEVICE_MANAGER -> XPayDeviceManager()
            XPayModuleType.PRINTER -> XPayPrinter()
            XPayModuleType.BARCODE_DECODER -> XPayBarcodeDecoder()
            XPayModuleType.ROUTE_MANAGER -> XPayRouteManager()
            XPayModuleType.SETTINGS -> XPaySettingManager()
            XPayModuleType.CASH_BOX -> XPayCashBox()
            XPayModuleType.ETHERNET_MANAGER -> XPayEthernetManager()
            XPayModuleType.SERIAL_PORT_MANAGER -> XPaySerialPortManager()
            XPayModuleType.BARCODE_SCANNER -> XPayBarcodeScanner()
            XPayModuleType.DEVICE_STATISTICS_MANAGER -> XPayDeviceStatisticsManager()
            XPayModuleType.RECOVERY -> XPayRecovery()
            XPayModuleType.BOOT_PROVIDER -> XPayBootProvider()
        }
    }

}