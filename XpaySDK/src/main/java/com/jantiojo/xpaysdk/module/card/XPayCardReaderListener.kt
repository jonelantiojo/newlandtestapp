package com.jantiojo.xpaysdk.module.card

import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardInfo
import com.newland.nsdk.core.api.common.card.contactless.ContactlessCardType
import com.newland.nsdk.core.api.common.card.magcard.MagCardInfo

interface XPayCardReaderListener {
    fun onTimeout()

    fun onCancel()

    fun onError(var1: Int, var2: String?)

    fun onFindMagCard(magCardInfo: XPayMagCardInfo?)

    fun onFindContactCard()

    fun onFindContactlessCard(contactLessCardType: XPayContactLessCardType?, contactlessCardInfo: XPayContactlessCardInfo?)
}