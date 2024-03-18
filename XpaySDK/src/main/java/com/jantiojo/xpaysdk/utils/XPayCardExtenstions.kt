package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.card.XPayActivationResult
import com.jantiojo.xpaysdk.module.card.XPayCardReaderParameters
import com.jantiojo.xpaysdk.module.card.XPayCardSlot
import com.jantiojo.xpaysdk.module.card.XPayCardType
import com.jantiojo.xpaysdk.module.card.XPayContactLessCardType
import com.jantiojo.xpaysdk.module.card.XPayContactlessCardInfo
import com.jantiojo.xpaysdk.module.card.XPayMagCardInfo
import com.jantiojo.xpaysdk.module.card.XPayTrackStatus
import com.newland.nsdk.core.api.common.card.contact.ContactCardSlot
import com.newland.nsdk.core.api.common.card.contactless.ActivationResult
import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardInfo
import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardType
import com.newland.nsdk.core.api.common.card.magcard.MagCardInfo
import com.newland.nsdk.core.api.common.card.magcard.TrackStatus
import com.newland.nsdk.core.api.common.cardreader.CardReaderParameters
import com.newland.nsdk.core.api.common.cardreader.CardType


internal fun XPayCardSlot.toNewLandCardSlot() = when (this) {
    XPayCardSlot.IC1 -> ContactCardSlot.IC1
    XPayCardSlot.IC2 -> ContactCardSlot.IC2
    XPayCardSlot.SAM1 -> ContactCardSlot.SAM1
    XPayCardSlot.SAM2 -> ContactCardSlot.SAM2
    XPayCardSlot.SAM3 -> ContactCardSlot.SAM3
    XPayCardSlot.SAM4 -> ContactCardSlot.SAM4
}

internal fun ContactCardSlot.toXPayCardSlot() = when (this) {
    ContactCardSlot.IC1 -> XPayCardSlot.IC1
    ContactCardSlot.IC2 -> XPayCardSlot.IC2
    ContactCardSlot.SAM1 -> XPayCardSlot.SAM1
    ContactCardSlot.SAM2 -> XPayCardSlot.SAM2
    ContactCardSlot.SAM3 -> XPayCardSlot.SAM3
    ContactCardSlot.SAM4 -> XPayCardSlot.SAM4
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

internal fun XPayCardReaderParameters.toNewLandCardReaderParam(): CardReaderParameters {
    val cardReaderParameters = CardReaderParameters()
    cardReaderParameters.contactlessCardTypes =
        contactLessCardTypes.toNewLandContactLessCardTypeArray()
    cardReaderParameters.isVerifyTrack = isVerifyTrack
    cardReaderParameters.typeFParameters = typeFParameters
    cardReaderParameters.typeVParameters = typeVParameters
    return cardReaderParameters
}

internal fun XPayContactLessCardType.toNewLandContactLessCardType() = when (this) {
    XPayContactLessCardType.TYPE_A -> ContactlessCardType.TYPE_A
    XPayContactLessCardType.TYPE_B -> ContactlessCardType.TYPE_B
    XPayContactLessCardType.TYPE_F -> ContactlessCardType.TYPE_F
    XPayContactLessCardType.TYPE_V -> ContactlessCardType.TYPE_V
}

internal fun ContactlessCardType.toXPayContactLessCardType() = when (this) {
    ContactlessCardType.TYPE_A -> XPayContactLessCardType.TYPE_A
    ContactlessCardType.TYPE_B -> XPayContactLessCardType.TYPE_B
    ContactlessCardType.TYPE_F -> XPayContactLessCardType.TYPE_F
    ContactlessCardType.TYPE_V -> XPayContactLessCardType.TYPE_V
}

internal fun List<XPayContactLessCardType>.toNewLandContactLessCardTypeArray(): Array<ContactlessCardType> {
    return this.map { it.toNewLandContactLessCardType() }.toTypedArray()
}

internal fun ContactlessCardInfo.toNewLandContactlessCardInfo(): XPayContactlessCardInfo {
    return XPayContactlessCardInfo(iDmPMm = this.iDmPMm)
}

internal fun XPayTrackStatus.toNewLandCardTrackStatus() = when (this) {
    XPayTrackStatus.GOOD -> TrackStatus.GOOD
    XPayTrackStatus.BAD -> TrackStatus.BAD
    XPayTrackStatus.EMPTY -> TrackStatus.EMPTY
}

internal fun List<XPayTrackStatus>.toNewLandCardTrackStatusArray(): Array<TrackStatus> {
    return this.map { it.toNewLandCardTrackStatus() }.toTypedArray()
}

internal fun TrackStatus.toXPayCardTrackStatus() = when (this) {
    TrackStatus.GOOD -> XPayTrackStatus.GOOD
    TrackStatus.BAD -> XPayTrackStatus.BAD
    TrackStatus.EMPTY -> XPayTrackStatus.EMPTY
}

internal fun MagCardInfo.toXPayMagCardInfo(): XPayMagCardInfo {
    return XPayMagCardInfo(
        trackStatus = this.trackStatus.asList().map { it.toXPayCardTrackStatus() },
        track1Data,
        track2Data,
        track3Data,
        panData,
        firstClearPAN,
        lastClearPAN,
        plainPANLen,
        plainTrack1DataLen,
        plainTrack2DataLen,
        plainTrack3DataLen,
        validDate,
        serviceCode
    )
}

internal fun ActivationResult.toXPayActivationResult(): XPayActivationResult {
    return XPayActivationResult(
        uid,
        atqa,
        ats,
        atqb,
        sak
    )
}