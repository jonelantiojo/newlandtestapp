package com.jantiojo.xpaysdk.module.crypto

import com.jantiojo.xpaysdk.module.XPayModule
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.internal.crypto.Crypto

class XPayCrypto : XPayModule() {

    private val crypto by lazy { xPayModuleManager.getModule(ModuleType.CRYPTO) as Crypto }

}