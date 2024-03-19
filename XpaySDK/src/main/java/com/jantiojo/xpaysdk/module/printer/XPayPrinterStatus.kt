package com.jantiojo.xpaysdk.module.printer

enum class XPayPrinterStatus {
    OK,//Good.
    BUSY,//Printing.
    NO_PAPER,//Out of paper.
    OVERHEAT,//Overheat.
    VOL_ERR,//Abnormal voltage.
    BAD;//No printer or printer damaged.
}