package com.jantiojo.xpaysdk.module.crypto

enum class XPayCipherType {
    DES_ECB,
    DES_CBC,
    DES_CFB,
    DES_OFB,
    DES_CTR,
    AES_ECB,
    AES_CBC,
    AES_CFB,
    AES_OFB,
    AES_CTR,
    DUKPT_ECB_RESP,
    DUKPT_ECB_BOTH,
    DUKPT_CBC_RESP,
    DUKPT_CBC_BOTH,
    DUKPT_CFB_RESP,
    DUKPT_CFB_BOTH,
    DUKPT_OFB_RESP,
    DUKPT_OFB_BOTH,
    AES_DUKPT_ECB,
    AES_DUKPT_CBC,
    SM4_ECB,
    SM4_CBC;
}