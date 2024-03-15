package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.led.XpayLEDColor
import com.jantiojo.xpaysdk.module.led.XpayLEDState
import com.newland.nsdk.core.api.common.led.LEDColor
import com.newland.nsdk.core.api.common.led.LEDState

internal fun List<XpayLEDColor>.toNewLandArrayLEDColor(): Array<LEDColor> {
    return this.map {
        val ledColor = when (it) {
            XpayLEDColor.BLUE -> LEDColor.BLUE
            XpayLEDColor.GREEN -> LEDColor.GREEN
            XpayLEDColor.YELLOW -> LEDColor.YELLOW
            XpayLEDColor.RED -> LEDColor.RED
        }
        ledColor
    }.toTypedArray()
}

internal fun XpayLEDState.toNewLandLEDState() = when (this) {
    XpayLEDState.ON -> LEDState.ON
    XpayLEDState.OFF -> LEDState.OFF
    XpayLEDState.BLINK -> LEDState.BLINK
}
