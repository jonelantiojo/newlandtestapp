package com.jantiojo.xpaysdk.module.recovery

import com.jantiojo.xpaysdk.module.XPayModule
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.recovery.Recovery

class XPayRecovery : XPayModule() {

    private val recovery by lazy { xPayModuleManager.getModule(ModuleType.RECOVERY) as Recovery }

    fun keepApps(strings: List<String>) {
        try {
            recovery.keepApps(strings.toTypedArray())
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Add Listener and print logs
        }
    }
}