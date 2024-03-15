package com.jantiojo.xpaysdk.module.barcode

data class XPayBarcodeScanParameter(
    val timeout: Int = 3000,
    val focusMode: Int = 1,
    val isSoundSwitcher: Boolean = false
)