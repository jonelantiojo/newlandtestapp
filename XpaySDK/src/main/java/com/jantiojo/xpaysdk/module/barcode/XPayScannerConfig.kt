package com.jantiojo.xpaysdk.module.barcode

data class XPayScannerConfig(
    val frontCamera: Boolean = false,
    val backCamera: Boolean = false,
    val paymentCamera: Boolean = false,
    val frontScanner: Boolean = false,
    val softDecoding: Boolean = false,
    val hardScanning: Boolean = false
)

