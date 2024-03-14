package com.jantiojo.xpaysdk

import android.content.Context
import com.jantiojo.utils.toArrayLEDColor
import com.newland.nsdk.core.api.common.ErrorCode
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.common.utils.LogLevel
import com.newland.nsdk.core.api.common.utils.NativeDebugLevel
import com.newland.nsdk.core.api.internal.NSDKModuleManager
import com.newland.nsdk.core.api.internal.beeper.Beeper
import com.newland.nsdk.core.api.internal.led.LED
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

    override fun playSound(frequency: Int, duration: Int) {
        val beeper = moduleManager.getModule(ModuleType.BEEPER) as Beeper
        try {
            beeper.beep(frequency, duration)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    override fun blinkLED(ledColor: List<XpayLEDColor>, blinkCount: Int, timeInterval: Int) {
        val led = moduleManager.getModule(ModuleType.LED) as LED
        try {
            led.blink(
                ledColor.toArrayLEDColor(),
                blinkCount,
                timeInterval
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    override fun controlLEDState(ledColor: XpayLEDColor, ledState: XpayLEDState) {
        val led = moduleManager.getModule(ModuleType.LED) as LED
    }
}