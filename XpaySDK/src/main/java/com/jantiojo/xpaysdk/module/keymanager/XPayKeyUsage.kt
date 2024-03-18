package com.jantiojo.xpaysdk.module.keymanager

enum class XPayKeyUsage {
    KEK,
    PIN_KEK,
    MAC_KEK,
    DATA_KEK,
    DATA_ENC_KEK,
    TR31_KEK,
    PIN,
    MAC,
    DATA,
    DATA_ENC_ONLY,
    DUKPT;
}