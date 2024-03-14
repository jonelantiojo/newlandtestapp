package com.jantiojo.xpaysdk

import android.content.Context
import com.jantiojo.xpaysdk.module.XPayModule

class XPaySDKAppContainer(private val xPayModuleProvider: XPayModuleProvider) {

    fun setupXPayProvider(context: Context){
        xPayModuleProvider.setup(context)
    }

    fun closeXPayProvider(){
        xPayModuleProvider.close()
    }

    fun getXPayModule(xPayModuleType: XPayModuleType) : XPayModule {
        return xPayModuleProvider.getXPayModule(xPayModuleType)
    }
}