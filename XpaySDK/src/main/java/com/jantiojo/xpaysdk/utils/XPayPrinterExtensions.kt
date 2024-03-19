package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.printer.XPayPrinterStatus
import com.jantiojo.xpaysdk.module.printer.XPayPrintingParameters
import com.newland.nsdk.core.api.internal.printer.PrinterStatus
import com.newland.nsdk.core.api.internal.printer.PrintingParameters


internal fun XPayPrintingParameters.toNewLandPrintingParameters(): PrintingParameters {
    val printingParameters = PrintingParameters()
    printingParameters.startX = startX
    printingParameters.expectedImageHeight = expectedImageHeight
    printingParameters.expectedImageWidth = expectedImageWidth
    printingParameters.imageWidth = imageWidth
    printingParameters.imageHeight = imageHeight
    return printingParameters
}

internal fun PrinterStatus.toXPayPrinterStatus(): XPayPrinterStatus {
    return when (this) {
        PrinterStatus.OK -> XPayPrinterStatus.OK
        PrinterStatus.BUSY -> XPayPrinterStatus.BUSY
        PrinterStatus.NO_PAPER -> XPayPrinterStatus.NO_PAPER
        PrinterStatus.OVERHEAT -> XPayPrinterStatus.OVERHEAT
        PrinterStatus.VOL_ERR -> XPayPrinterStatus.VOL_ERR
        PrinterStatus.BAD -> XPayPrinterStatus.BAD
    }
}