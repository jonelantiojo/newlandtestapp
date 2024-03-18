package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.crypto.XPayAsymAlgorithmParameters
import com.jantiojo.xpaysdk.module.crypto.XPayAsymCryptoMode
import com.jantiojo.xpaysdk.module.crypto.XPayAsymEncodingMode
import com.jantiojo.xpaysdk.module.crypto.XPayAsymKeyType
import com.jantiojo.xpaysdk.module.crypto.XPayAsymKeyUsage
import com.jantiojo.xpaysdk.module.crypto.XPayAsymmetricKey
import com.jantiojo.xpaysdk.module.crypto.XPayCipherType
import com.jantiojo.xpaysdk.module.crypto.XPayKCVMode
import com.jantiojo.xpaysdk.module.crypto.XPayMACOutput
import com.jantiojo.xpaysdk.module.crypto.XPayMACType
import com.jantiojo.xpaysdk.module.crypto.XPayMessageDigestType
import com.jantiojo.xpaysdk.module.crypto.XPayPaddingMode
import com.newland.nsdk.core.api.common.crypto.AsymAlgorithmParameters
import com.newland.nsdk.core.api.common.crypto.AsymCryptoMode
import com.newland.nsdk.core.api.common.crypto.AsymEncodingMode
import com.newland.nsdk.core.api.common.crypto.CipherType
import com.newland.nsdk.core.api.common.crypto.KCVMode
import com.newland.nsdk.core.api.common.crypto.MACOutput
import com.newland.nsdk.core.api.common.crypto.MACType
import com.newland.nsdk.core.api.common.crypto.MessageDigestType
import com.newland.nsdk.core.api.common.crypto.PaddingMode
import com.newland.nsdk.core.api.common.keymanager.AsymKeyType
import com.newland.nsdk.core.api.common.keymanager.AsymKeyUsage
import com.newland.nsdk.core.api.common.keymanager.AsymmetricKey

internal fun MACOutput.toXPayMACOutput(): XPayMACOutput {
    return XPayMACOutput(data, ksn)
}

internal fun XPayMACType.toNewLandMACType(): MACType {
    return when (this) {
        XPayMACType.TDES_LAST -> MACType.TDES_LAST
        XPayMACType.TDES_X99 -> MACType.TDES_X99
        XPayMACType.TDES_X919 -> MACType.TDES_X919
        XPayMACType.TDES_UNIONPAY_ECB -> MACType.TDES_UNIONPAY_ECB
        XPayMACType.DUKPT_LAST -> MACType.DUKPT_LAST
        XPayMACType.DUKPT_X99 -> MACType.DUKPT_X99
        XPayMACType.DUKPT_X919 -> MACType.DUKPT_X919
        XPayMACType.DUKPT_UNIONPAY_ECB -> MACType.DUKPT_UNIONPAY_ECB
        XPayMACType.DUKPT_RESP_LAST -> MACType.DUKPT_RESP_LAST
        XPayMACType.DUKPT_RESP_X99 -> MACType.DUKPT_RESP_X99
        XPayMACType.DUKPT_RESP_X919 -> MACType.DUKPT_RESP_X919
        XPayMACType.DUKPT_RESP_UNIONPAY_ECB -> MACType.DUKPT_RESP_UNIONPAY_ECB
        XPayMACType.AES_LAST -> MACType.AES_LAST
        XPayMACType.AES_X99 -> MACType.AES_X99
        XPayMACType.AES_DUKPT_LAST -> MACType.AES_DUKPT_LAST
        XPayMACType.AES_DUKPT_X99 -> MACType.AES_DUKPT_X99
        XPayMACType.AES_DUKPT_X919 -> MACType.AES_DUKPT_X919
        XPayMACType.AES_DUKPT_UNIONPAY_ECB -> MACType.AES_DUKPT_UNIONPAY_ECB
        XPayMACType.SM4_LAST -> MACType.SM4_LAST
        XPayMACType.SM4_X99 -> MACType.SM4_X99
        XPayMACType.SM4_UNIONPAY_ECB -> MACType.SM4_UNIONPAY_ECB
    }
}

internal fun XPayCipherType.toNewLandMACType(): CipherType {
    return when (this) {
        XPayCipherType.DES_ECB -> CipherType.DES_ECB
        XPayCipherType.DES_CBC -> CipherType.DES_CBC
        XPayCipherType.DES_CFB -> CipherType.DES_CFB
        XPayCipherType.DES_OFB -> CipherType.DES_OFB
        XPayCipherType.DES_CTR -> CipherType.DES_CTR
        XPayCipherType.AES_ECB -> CipherType.AES_ECB
        XPayCipherType.AES_CBC -> CipherType.AES_CBC
        XPayCipherType.AES_CFB -> CipherType.AES_CFB
        XPayCipherType.AES_OFB -> CipherType.AES_OFB
        XPayCipherType.AES_CTR -> CipherType.AES_CTR
        XPayCipherType.DUKPT_ECB_RESP -> CipherType.DUKPT_ECB_RESP
        XPayCipherType.DUKPT_ECB_BOTH -> CipherType.DUKPT_ECB_BOTH
        XPayCipherType.DUKPT_CBC_RESP -> CipherType.DUKPT_CBC_RESP
        XPayCipherType.DUKPT_CBC_BOTH -> CipherType.DUKPT_CBC_BOTH
        XPayCipherType.DUKPT_CFB_RESP -> CipherType.DUKPT_CFB_RESP
        XPayCipherType.DUKPT_CFB_BOTH -> CipherType.DUKPT_CFB_BOTH
        XPayCipherType.DUKPT_OFB_RESP -> CipherType.DUKPT_OFB_RESP
        XPayCipherType.DUKPT_OFB_BOTH -> CipherType.DUKPT_OFB_BOTH
        XPayCipherType.AES_DUKPT_ECB -> CipherType.AES_DUKPT_ECB
        XPayCipherType.AES_DUKPT_CBC -> CipherType.AES_DUKPT_CBC
        XPayCipherType.SM4_ECB -> CipherType.SM4_ECB
        XPayCipherType.SM4_CBC -> CipherType.SM4_CBC
    }
}

internal fun XPayPaddingMode.toNewLandMACType(): PaddingMode {
    return when (this) {
        XPayPaddingMode.NONE -> PaddingMode.NONE
        XPayPaddingMode.PKCS7 -> PaddingMode.PKCS7
        XPayPaddingMode.ONE_AND_ZEROS -> PaddingMode.ONE_AND_ZEROS
        XPayPaddingMode.ZEROS_AND_LEN -> PaddingMode.ZEROS_AND_LEN
        XPayPaddingMode.ZEROS -> PaddingMode.ZEROS
    }
}

internal fun XPayKCVMode.toNewLandMACType(): KCVMode {
    return when (this) {
        XPayKCVMode.NONE -> KCVMode.NONE
        XPayKCVMode.ZERO -> KCVMode.ZERO
        XPayKCVMode.VAL -> KCVMode.VAL
        XPayKCVMode.DATA -> KCVMode.DATA
        XPayKCVMode.CMAC -> KCVMode.CMAC
    }
}

internal fun XPayAsymKeyType.toNewLandAsymKeyType(): AsymKeyType {
    return when (this) {
        XPayAsymKeyType.RSA -> AsymKeyType.RSA
        XPayAsymKeyType.ECC -> AsymKeyType.ECC
    }
}

internal fun XPayAsymKeyUsage.toNewLandAsymKeyUsage(): AsymKeyUsage {
    return when (this) {
        XPayAsymKeyUsage.AUTH -> AsymKeyUsage.AUTH
        XPayAsymKeyUsage.DATA -> AsymKeyUsage.DATA
        XPayAsymKeyUsage.AUTH_DATA -> AsymKeyUsage.AUTH_DATA
        XPayAsymKeyUsage.KEY_DISTRIBUTION -> AsymKeyUsage.KEY_DISTRIBUTION
    }
}

internal fun XPayAsymmetricKey.toNewLandAsymmetricKey(): AsymmetricKey {
    val asymmetricKey = AsymmetricKey()
    asymmetricKey.keyType = this.keyType.toNewLandAsymKeyType()
    asymmetricKey.keyUsage = this.keyUsage.toNewLandAsymKeyUsage()
    return asymmetricKey
}

internal fun XPayAsymEncodingMode.toNewLandAsymEncodingMode(): AsymEncodingMode {
    return when (this) {
        XPayAsymEncodingMode.NONE -> AsymEncodingMode.NONE
        XPayAsymEncodingMode.PKCS_V15 -> AsymEncodingMode.PKCS_V15
        XPayAsymEncodingMode.PKCS_V21 -> AsymEncodingMode.PKCS_V21
    }
}

internal fun XPayAsymCryptoMode.toNewLandAsymCryptoMode(): AsymCryptoMode {
    return when (this) {
        XPayAsymCryptoMode.DEFAULT -> AsymCryptoMode.DEFAULT
        XPayAsymCryptoMode.PUBLIC -> AsymCryptoMode.PUBLIC
        XPayAsymCryptoMode.PRIVATE -> AsymCryptoMode.PRIVATE
    }
}

internal fun XPayMessageDigestType.toNewLandMessageDigestType(): MessageDigestType {
    return when (this) {
        XPayMessageDigestType.NONE -> MessageDigestType.NONE
        XPayMessageDigestType.SHA1 -> MessageDigestType.SHA1
        XPayMessageDigestType.SHA224 -> MessageDigestType.SHA224
        XPayMessageDigestType.SHA256 -> MessageDigestType.SHA256
        XPayMessageDigestType.SHA384 -> MessageDigestType.SHA384
        XPayMessageDigestType.SHA512 -> MessageDigestType.SHA512
        XPayMessageDigestType.SM3 -> MessageDigestType.SM3
    }
}

internal fun XPayAsymAlgorithmParameters.toNewLandAsymmetricKey(): AsymAlgorithmParameters {
    val asymmetricKey = AsymAlgorithmParameters()
    asymmetricKey.encodingMode = this.encodingMode.toNewLandAsymEncodingMode()
    asymmetricKey.cryptoMode = this.cryptoMode.toNewLandAsymCryptoMode()
    asymmetricKey.messageDigestType = this.messageDigestType.toNewLandMessageDigestType()
    return asymmetricKey
}
