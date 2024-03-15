package com.jantiojo.xpaysdk.module.barcode

interface XPayScannerDecodingByteCallback {
    fun onDecodingByteCallback(code: Int, resultOfByte: ByteArray?)
}