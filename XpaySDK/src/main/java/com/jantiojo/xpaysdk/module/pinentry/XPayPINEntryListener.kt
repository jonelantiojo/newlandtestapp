package com.jantiojo.xpaysdk.module.pinentry

interface  XPayPINEntryListener {

    fun onFinish(pinLen: Int, pinBlock: ByteArray?, ksn: ByteArray?)

    fun onTimeout()

    fun onKeyPress()

    fun onCancel()

    fun onClear()

    fun onBackspace()

    fun onError(errorCode: Int, message: String?)

}