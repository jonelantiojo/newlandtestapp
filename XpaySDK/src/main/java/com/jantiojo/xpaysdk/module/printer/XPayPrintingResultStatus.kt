package com.jantiojo.xpaysdk.module.printer

enum class XPayPrintingResultStatus(val value: Int) {

    OK(value = 0),
    ERR(value = -1),
    ERR_PARAM(value = -6),
    ERR_BUSY(value = 8),
    ERR_NOPAPER(value = 2),
    ERR_OVERHEAT(value = 4),
    ERR_VOLERR(value = 112),
    ERR_CUTERR(value = 512),
    ERR_DESTROYED(value = 1024),
    ERR_PPSERR(value = 2048)
}