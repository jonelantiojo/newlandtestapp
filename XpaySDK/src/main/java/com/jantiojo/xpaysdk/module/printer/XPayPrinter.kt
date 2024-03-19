package com.jantiojo.xpaysdk.module.printer

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandPrintingParameters
import com.jantiojo.xpaysdk.utils.toXPayPrinterStatus
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.printer.Printer


class XPayPrinter : XPayModule() {

    private val printer by lazy { xPayModuleManager.getModule(ModuleType.PRINTER) as Printer }

    /**
     * Gets printer status.
     */

    val printerStatus: XPayPrinterStatus = printer.status.toXPayPrinterStatus()

    /**
     *  Prints an image with its actual width and height.
     *
     * Note: Please make sure card reader is closed before printing. Otherwise it will fail to print.
     *
     *  @param image - Compressed data of bitmap.
     *  @param startX - Starting Offset from where to print, shall be >=0.
     *  @param imageWidth - Width of the image, shall be >0.
     *  @param imageHeight - Height of the image, shall be >0.
     *  @param xPayPrintingResultListener - Listens to the status of printer.
     *
     *  For more details, please check
     *  @see XPayPrintingResultListener
     */
    fun printImage(
        image: ByteArray,
        startX: Int,
        imageWidth: Int,
        imageHeight: Int,
        xPayPrintingResultListener: XPayPrintingResultListener
    ) {

        try {
            // Start printing.
            printer.printImage(
                image,
                startX,
                imageWidth,
                imageHeight
            ) { status ->
                xPayPrintingResultListener.onEventRaised(status)
            }
        } catch (e: NSDKException) {
            // Handle the exception.
        }
    }


    /**
     *  Prints an image with expected width and height.
     *
     * Note: Please make sure card reader is closed before printing. Otherwise it will fail to print.
     *
     * @param image - RGBA data.
     * @param xPayPrintingParameters - Printing parameters. Includes image height, image width, starting offset, expected image height and expected image height.
     * For more details,
     * @see XPayPrintingParameters
     *
     * @param xPayPrintingResultListener - Listens to the status of printer.
     *
     *  For more details, please check
     *  @see XPayPrintingResultListener
     */
    fun printRGBAImage(
        image: ByteArray,
        xPayPrintingParameters: XPayPrintingParameters,
        xPayPrintingResultListener: XPayPrintingResultListener
    ) {

        try {
            // Start printing.
            printer.printRGBAImage(
                image,
                xPayPrintingParameters.toNewLandPrintingParameters()
            ) { status ->
                xPayPrintingResultListener.onEventRaised(status)
            }
        } catch (e: NSDKException) {
            // Handle the exception.
        }
    }

    /**
     * Cuts paper.
     *
     * Note: Please notice this feature only support on CPOS X5 device.
     */

    fun cutPaper() {
        printer.cutPaper()
    }

    /**
     *
     * You can use this method to change the print font gray.
     *
     *  @param gray - Printing gray. Value range: [1,10].
     */

    fun setGray(gray: Int) {
        printer.setGray(gray)
    }

}