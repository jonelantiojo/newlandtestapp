package com.jantiojo.xpaysdk

import android.content.Context
import com.jantiojo.xpaysdk.module.XPayModule

interface XPayModuleProvider {

    /**
     * call to initialize the underlying/3rd party payment Provider
     */
    fun setup(context: Context)

    /**
     * call to close the connection from underlying/3rd party payment Provider
     */
    fun close()

    fun getXPayModule(xPayModuleType: XPayModuleType) : XPayModule

}