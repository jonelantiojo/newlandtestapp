package com.jantiojo.xpaysdk.module.crypto

data class XPayAsymmetricKey(
    val keyType: XPayAsymKeyType,
    val keyUsage: XPayAsymKeyUsage
)
