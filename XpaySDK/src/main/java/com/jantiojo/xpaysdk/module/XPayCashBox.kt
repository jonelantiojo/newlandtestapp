package com.jantiojo.xpaysdk.module

import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.cashbox.CashBox

class XPayCashBox : XPayModule() {

    private val cashBox by lazy { xPayModuleManager.getModule(ModuleType.CASH_BOX) as CashBox }


    /**
     * Open cash box with default voltage(12v) and allow to open again after 500ms.
     */
    fun open() {
        try {
            cashBox.open()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }

    /**
     * Open cash box with 24v and allow to open again after 10s.
     */
    fun open(milliSecond: Long) {
        try {
            cashBox.open(1, milliSecond)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }


}