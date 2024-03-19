package com.jantiojo.xpaysdk.module.printer

data class XPayPrintingParameters(
    /**
     * starting offset.
     */
    val startX: Int,
    /**
     *  expected image Width.
     */
    val expectedImageWidth: Int,
    /**
     * expected image Height.
     */
    val expectedImageHeight: Int,
    /**
     *  actual width of the image.
     */
    val imageWidth: Int,
    /**
     * actual height of the image
     */
    val imageHeight: Int,
)
