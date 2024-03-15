package com.jantiojo.xpaysdk.module.card

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandCardReaderParam
import com.jantiojo.xpaysdk.utils.toNewLandCardSlot
import com.jantiojo.xpaysdk.utils.toNewLandCardType
import com.jantiojo.xpaysdk.utils.toNewLandContactlessCardInfo
import com.jantiojo.xpaysdk.utils.toXPayContactLessCardType
import com.jantiojo.xpaysdk.utils.toXPayMagCardInfo
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardInfo
import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardType
import com.newland.nsdk.core.api.common.card.magcard.MagCardInfo
import com.newland.nsdk.core.api.common.cardreader.CardReaderListener
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.cardreader.CardReader

class XPayCardReader : XPayModule() {

    private val cardReader by lazy { xPayModuleManager.getModule(ModuleType.CARD_READER) as CardReader }

    /**
     *  call to open Card Reader from underlying/3rd party payment Provider
     *
     * @param xPayCardTypes - Expected card types
     * @param timeout - [Required] Timeout for waiting cards, shall be >0. Unit: seconds.
     * @param cardReaderParameters - [Optional] Card reader parameters.
     *                        When contactless card is expected, target contactless card types are required.
     *                        If no contactless card types set, it will search for type A and type B cards by default.
     *                        When mag card is expected:It will verify track data by default.
     *                        Default length of first clear part of masked PAN: 6.
     *                        Default length of last clear part of masked PAN: 4.
     * @param cardReaderListener - [Required] Listener which will be called to give the result.
     *
     * @see XPayCardType
     * @see XPayCardReaderParameters
     * @see XPayCardReaderListener
     */
    fun openCardReader(
        xPayCardTypes: List<XPayCardType>,
        timeout: Int,
        cardReaderParameters: XPayCardReaderParameters? = null,
        cardReaderListener: XPayCardReaderListener? = null
    ) {
        try {

            val cardTypes = xPayCardTypes.toNewLandCardType()
            cardReader.openCardReader(
                cardTypes,
                timeout,
                cardReaderParameters?.toNewLandCardReaderParam(),
                object : CardReaderListener {
                    override fun onTimeout() {
                        cardReaderListener?.onTimeout()
                    }

                    override fun onCancel() {
                        cardReaderListener?.onCancel()
                    }

                    override fun onError(p0: Int, p1: String?) {
                        cardReaderListener?.onError(p0, p1)
                    }

                    override fun onFindMagCard(p0: MagCardInfo?) {
                        cardReaderListener?.onFindMagCard(p0?.toXPayMagCardInfo())
                    }

                    override fun onFindContactCard() {
                        cardReaderListener?.onFindContactCard()
                    }

                    override fun onFindContactlessCard(
                        p0: ContactlessCardType?,
                        p1: ContactlessCardInfo?
                    ) {
                        cardReaderListener?.onFindContactlessCard(
                            p0?.toXPayContactLessCardType(),
                            p1?.toNewLandContactlessCardInfo()
                        )
                    }
                }
            )
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