package com.jantiojo.xpaysdk.module.card

import com.jantiojo.xpaysdk.utils.toNewLandCardSlot
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.card.contact.CPUContactCard
import com.newland.nsdk.core.internal.card.contact.CPUContactCardImpl


class XPayCPUContactCard(private val xPayCardSlot: XPayCardSlot) {

    private val cpuContactCard: CPUContactCard by lazy { CPUContactCardImpl(xPayCardSlot.toNewLandCardSlot()) }

    /**
     * call to Powers up the card.
     *
     *  @return ATR data.
     */
    fun powerUp(): ByteArray {
        return try {
            cpuContactCard.powerUp()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
            byteArrayOf()
        }
    }

    /**
     * call to Powers down the card.
     */
    fun powerDown() {
        try {
            cpuContactCard.powerDown()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    /**
     * call perform APDU
     *
     * @param byteArray - [Required] APDU command data. ISOUtils.hex2byte("0084000004");
     *
     * @return APDU response data.
     */
    fun performAPDU(byteArray: ByteArray): ByteArray {
        return try {
            cpuContactCard.performAPDU(byteArray)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
            byteArrayOf()
        }
    }
}