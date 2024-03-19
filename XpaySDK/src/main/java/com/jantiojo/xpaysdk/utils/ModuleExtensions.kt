package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.ethernetmanager.XPayEthernetStatus
import com.jantiojo.xpaysdk.module.led.XpayLEDColor
import com.jantiojo.xpaysdk.module.led.XpayLEDState
import com.jantiojo.xpaysdk.module.serialportmanager.XPaySerialPortType
import com.newland.nsdk.core.api.common.led.LEDColor
import com.newland.nsdk.core.api.common.led.LEDState
import com.newland.nsdk.core.api.internal.ethernetmanager.EthernetStatus
import com.newland.nsdk.core.api.internal.serialportmanager.SerialPortType

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


internal fun EthernetStatus.toXPayEthernetStatus(): XPayEthernetStatus {
    return when (this) {
        EthernetStatus.UNKNOWN -> XPayEthernetStatus.UNKNOWN
        EthernetStatus.ENABLED -> XPayEthernetStatus.ENABLED
        EthernetStatus.DISABLED -> XPayEthernetStatus.DISABLED
    }
}
