package com.jantiojo.xpaysdk.module.barcode

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandScanParameter
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.barcodedecoder.DecodingByteCallback
import com.newland.nsdk.core.api.internal.barcodescanner.BarcodeScanner

class XPayBarcodeScanner : XPayModule() {

    private val barcodeScanner by lazy { xPayModuleManager.getModule(ModuleType.BARCODE_SCANNER) as BarcodeScanner }

    fun initHardScanner(
        scanParameter: XPayBarcodeScanParameter = XPayBarcodeScanParameter(),
        decodingByteCallback: XPayScannerDecodingByteCallback
    ) {
        try {
            barcodeScanner.initScan(scanParameter.toNewLandScanParameter())
            barcodeScanner.setDecodingCallback(object : DecodingByteCallback {
                override fun onDecodingByteCallback(code: Int, resultOfByte: ByteArray?) {
                    decodingByteCallback.onDecodingByteCallback(code, resultOfByte)
                }
            })
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }


    fun startHardScan() {
        try {
            barcodeScanner.startScan()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }

    fun stopHardScan() {
        try {
            barcodeScanner.stopScan()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }

    fun releaseHardScan() {
        try {
            barcodeScanner.releaseScan()
        } catch (e: NSDKException) {
            e.printStackTrace()
            //add exception message
        }
    }


}