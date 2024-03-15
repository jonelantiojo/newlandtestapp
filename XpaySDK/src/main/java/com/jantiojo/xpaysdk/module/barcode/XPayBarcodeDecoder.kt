package com.jantiojo.xpaysdk.module.barcode

import com.jantiojo.xpaysdk.module.XPayModule
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.barcodedecoder.BarcodeDecoder

class XPayBarcodeDecoder : XPayModule() {

    private val barcodeDecoder by lazy { xPayModuleManager.getModule(ModuleType.BARCODE_DECODER) as BarcodeDecoder }


    fun startDecoding(imageData: ByteArray, width: Int, height: Int) {
        try {
            barcodeDecoder.startDecode(imageData, width, height)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }

    fun stopDecoding() {
        try {
            barcodeDecoder.stopDecode()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }
}