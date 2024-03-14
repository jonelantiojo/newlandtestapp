package com.jantiojo.xpaysdk.module.led

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandArrayLEDColor
import com.jantiojo.xpaysdk.utils.toNewLandLEDState
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.led.LED

class XPayLED : XPayModule() {

    private val led by lazy { xPayModuleManager.getModule(ModuleType.LED) as LED }

    /**
     *  call to male LED lights blink
     *
     *  @param ledColor - LED lights to control
     *  @param blinkCount - How many times to blink the lights, shall be >0
     *  @param timeInterval - time interval when to blink the LED lights, must be >0
     *
     *  @see XpayLEDColor
     */
    fun blinkLED(ledColor: List<XpayLEDColor>, blinkCount: Int, timeInterval: Int) {
        try {
            led.blink(
                ledColor.toNewLandArrayLEDColor(),
                blinkCount,
                timeInterval
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    /**
     *  call to set the state of specified LED lights
     *
     *  @param ledColor - LED lights to control.
     *  @param ledState - The state of LED lights.
     *
     * @see XpayLEDColor
     * @see XpayLEDState
     */
    fun controlLEDState(ledColor: List<XpayLEDColor>, ledState: XpayLEDState) {
        try {
            led.setState(
                ledColor.toNewLandArrayLEDColor(),
                ledState.toNewLandLEDState()
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }
}