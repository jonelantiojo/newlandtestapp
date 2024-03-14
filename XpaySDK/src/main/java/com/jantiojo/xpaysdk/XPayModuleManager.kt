package com.jantiojo.xpaysdk

import android.content.Context
import com.jantiojo.xpaysdk.module.XPayBeeper
import com.jantiojo.xpaysdk.module.led.XPayLED
import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.module.card.XPayCardReader
import com.newland.nsdk.core.api.common.ErrorCode
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.common.utils.LogLevel
import com.newland.nsdk.core.api.common.utils.NativeDebugLevel
import com.newland.nsdk.core.api.internal.NSDKModuleManager
import com.newland.nsdk.core.internal.NSDKModuleManagerImpl

/**
 * implementation class to share with other clients or entity
 */
class XPayModuleManager(private val context: Context) : XPayModuleProvider {

    private val moduleManager: NSDKModuleManager by lazy {
        NSDKModuleManagerImpl.getInstance()
    }

    override fun setup() {
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
            XPayModuleType.CRYPTO -> TODO()
            XPayModuleType.KEY_MANAGER -> TODO()
            XPayModuleType.PIN_ENTRY -> TODO()
            XPayModuleType.DEVICE_MANAGER -> TODO()
            XPayModuleType.PRINTER -> TODO()
            XPayModuleType.BARCODE_DECODER -> TODO()
            XPayModuleType.ROUTE_MANAGER -> TODO()
            XPayModuleType.SETTINGS -> TODO()
            XPayModuleType.EMV_L2_SERVICE -> TODO()
            XPayModuleType.CASH_BOX -> TODO()
            XPayModuleType.FUTUREX -> TODO()
            XPayModuleType.ETHERNET_MANAGER -> TODO()
            XPayModuleType.SERIAL_PORT_MANAGER -> TODO()
        }
    }

}