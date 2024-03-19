package com.jantiojo.xpaysdk.module.printer

interface XPayPrintingResultListener {
    fun onEventRaised(status: Int)
}