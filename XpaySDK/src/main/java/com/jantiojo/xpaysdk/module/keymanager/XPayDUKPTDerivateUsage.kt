package com.jantiojo.xpaysdk.module.keymanager

enum class XPayDUKPTDerivateUsage {
    NONE,
    KEK,
    PIN,
    MAC_GEN,
    MAC_VERIFY,
    MAC_BOTH,
    DATA_ENC,
    DATA_DEC,
    DATA_BOTH,
    DERIVATEKEY,
    DERIVATEKEY_INITIAL;
}