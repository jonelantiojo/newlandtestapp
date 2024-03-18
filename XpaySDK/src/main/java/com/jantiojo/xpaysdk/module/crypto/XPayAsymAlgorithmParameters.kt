package com.jantiojo.xpaysdk.module.crypto

data class XPayAsymAlgorithmParameters(
    val encodingMode: XPayAsymEncodingMode,
    val cryptoMode: XPayAsymCryptoMode,
    val messageDigestType: XPayMessageDigestType
)
