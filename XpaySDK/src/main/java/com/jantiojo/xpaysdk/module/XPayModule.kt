package com.jantiojo.xpaysdk.module

import com.newland.nsdk.core.internal.NSDKModuleManagerImpl

abstract class XPayModule {

    val xPayModuleManager: NSDKModuleManagerImpl by lazy { NSDKModuleManagerImpl.getInstance() }
}