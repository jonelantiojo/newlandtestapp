package com.jantiojo.xpaysdk.module.card

import com.jantiojo.xpaysdk.utils.toXPayActivationResult
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.card.contactless.CPUContactlessCard
import com.newland.nsdk.core.internal.card.contactless.CPUContactlessCardImpl
import com.newland.nsdk.plugin.card.api.internal.contactless.FelicaCard
import com.newland.nsdk.plugin.card.api.internal.contactless.M0Card
import com.newland.nsdk.plugin.card.api.internal.contactless.M1Card
import com.newland.nsdk.plugin.card.internal.contactless.FelicaCardImpl
import com.newland.nsdk.plugin.card.internal.contactless.M0CardImpl
import com.newland.nsdk.plugin.card.internal.contactless.M1CardImpl

class XPayCPUContactlessCard {

    val mCPUContactlessCard: CPUContactlessCard by lazy { CPUContactlessCardImpl() }

    fun m0Card(): M0Card {
        return M0CardImpl()
    }

    fun m1Card(): M1Card {
        return M1CardImpl()
    }

    fun feliCard(): FelicaCard {
        return FelicaCardImpl()
    }

    /**
     *  call to activate Contactless Card
     *
     *  @return XPayActivationResult
     */
    fun activate(): XPayActivationResult? {
        return try {
            mCPUContactlessCard.activate().toXPayActivationResult()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
            return null
        }
    }
    /**
     *  call to deactivate
     */

    fun deactivate() {
        try {
            mCPUContactlessCard.deactivate()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }

}