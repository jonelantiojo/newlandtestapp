package com.jantiojo.xpaysdk.module.card

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandCardSlot
import com.jantiojo.xpaysdk.utils.toNewLandCardType
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.cardreader.CardReaderListener
import com.newland.nsdk.core.api.common.cardreader.CardReaderParameters
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.cardreader.CardReader

class XPayCardReader : XPayModule() {

    private val cardReader by lazy { xPayModuleManager.getModule(ModuleType.CARD_READER) as CardReader }

    /**
     *  call to open Card Reader from underlying/3rd party payment Provider
     *
     * @param xPayCardTypes - Expected card types
     * @param cardReaderParameters -
     * @param cardReaderListener-
     *
     * @see XPayCardType
     */
    fun openCardReader(
        xPayCardTypes: List<XPayCardType>,
        timeout: Int,
        cardReaderParameters: CardReaderParameters, // TODO covert to XpayClass
        cardReaderListener: CardReaderListener? = null // TODO covert to XpayClass
    ) {
        try {

            val cardTypes = xPayCardTypes.toNewLandCardType()
            cardReader.openCardReader(cardTypes, timeout, cardReaderParameters, cardReaderListener)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }


    /**
     * call to trigger in closing Card Reader
     */
    fun closeCardReader() {
        try {
            cardReader.cancelCardReader()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }

    /**
     * call to check if Card Reader is Present
     */
    fun isCardPreset() = cardReader.isCardPresent

    /**
     * call to trigger if Card Reader is Inserted
     */
    fun isCardInserted() = cardReader.isCardInserted

    /**
     * call to check Card Slot Status
     *
     * @param xPayCardSlot - Card Slot Type
     *
     * @see XPayCardSlot
     */
    fun checkCardSlotStatus(xPayCardSlot: XPayCardSlot) {
        cardReader.checkCardSlotStatus(xPayCardSlot.toNewLandCardSlot())
    }
}