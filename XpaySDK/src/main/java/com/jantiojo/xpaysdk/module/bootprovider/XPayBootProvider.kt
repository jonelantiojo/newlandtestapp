package com.jantiojo.xpaysdk.module.bootprovider

import com.jantiojo.xpaysdk.module.XPayModule
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.bootprovider.BootProvider

class XPayBootProvider : XPayModule() {

    private val bootProvider by lazy { xPayModuleManager.getModule(ModuleType.BOOT_PROVIDER) as BootProvider }

    fun setCustomBootAnimation(animationFilePath: String) {
        try {
            bootProvider.setCustomBootAnimation(animationFilePath)
        } catch (e: NSDKException) {
            //handle exception and logs here
        }
    }

    fun removeCustomBootAnimation() {
        try {
            bootProvider.removeCustomBootAnimation()
        } catch (e: NSDKException) {
            //handle exception and logs here
        }
    }

    fun setCustomBootLogo(logoFilePath: String) {
        try {
            bootProvider.setCustomBootLogo(logoFilePath)
        } catch (e: NSDKException) {
            //handle exception and logs here
        }
    }

    fun removeCustomBootLogo() {
        try {
            bootProvider.removeCustomBootLogo()
        } catch (e: NSDKException) {
            //handle exception and logs here
        }
    }
}