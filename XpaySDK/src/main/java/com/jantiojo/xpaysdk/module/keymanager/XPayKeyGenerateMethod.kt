package com.jantiojo.xpaysdk.module.keymanager

/**
 * KeyGenerateMethod.CLEAR is used for DEV device, for PRO device, please use master POS or RKL to load master key.
 *
 */
enum class XPayKeyGenerateMethod {
    CLEAR,
    CIPHER,
    TR31,
    RANDOM,
    RANDOM_OUT,
    DUKPT_DERIVE,
    DIVERSIFY_X,
    GISKE,
    RANDOM_OUT_TR31,
    CIPHER_VTB,
    AES_DUKPT_UPDATE_IK,
    HKDF,
    ANSI_X9143;
}