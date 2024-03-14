package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.card.XPayCardSlot
import com.jantiojo.xpaysdk.module.card.XPayCardType
import com.jantiojo.xpaysdk.module.led.XpayLEDColor
import com.jantiojo.xpaysdk.module.led.XpayLEDState
import com.newland.nsdk.core.api.common.card.contact.ContactCardSlot
import com.newland.nsdk.core.api.common.cardreader.CardType
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

internal fun XPayCardSlot.toNewLandCardSlot() = when (this) {
    XPayCardSlot.IC1 -> ContactCardSlot.IC1
    XPayCardSlot.IC2 -> ContactCardSlot.IC2
    XPayCardSlot.SAM1 -> ContactCardSlot.SAM1
    XPayCardSlot.SAM2 -> ContactCardSlot.SAM2
    XPayCardSlot.SAM3 -> ContactCardSlot.SAM3
    XPayCardSlot.SAM4 -> ContactCardSlot.SAM4
}

internal fun List<XPayCardType>.toNewLandCardType(): Array<CardType> {
    return this.map {
        val cardType = when (it) {
            XPayCardType.MAG_CARD -> CardType.MAG_CARD
            XPayCardType.CONTACT_CARD -> CardType.CONTACT_CARD
            XPayCardType.CONTACTLESS_CARD -> CardType.CONTACTLESS_CARD
        }
        cardType
    }.toTypedArray()
}
