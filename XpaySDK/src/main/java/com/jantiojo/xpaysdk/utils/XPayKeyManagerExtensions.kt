package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.crypto.XPayAsymmetricKey
import com.jantiojo.xpaysdk.module.keymanager.XPayAlgorithmParameters
import com.jantiojo.xpaysdk.module.keymanager.XPayCipherMode
import com.jantiojo.xpaysdk.module.keymanager.XPayDUKPTDerivateKey
import com.jantiojo.xpaysdk.module.keymanager.XPayDUKPTDerivateUsage
import com.jantiojo.xpaysdk.module.keymanager.XPayKey
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyGenerateMethod
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyInfoID
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyType
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyUsage
import com.jantiojo.xpaysdk.module.keymanager.XPaySymmetricKey
import com.newland.nsdk.core.api.common.crypto.AlgorithmParameters
import com.newland.nsdk.core.api.common.keymanager.AsymmetricKey
import com.newland.nsdk.core.api.common.keymanager.CipherMode
import com.newland.nsdk.core.api.common.keymanager.DUKPTDerivateKey
import com.newland.nsdk.core.api.common.keymanager.DUKPTDerivateUsage
import com.newland.nsdk.core.api.common.keymanager.Key
import com.newland.nsdk.core.api.common.keymanager.KeyGenerateMethod
import com.newland.nsdk.core.api.common.keymanager.KeyInfoID
import com.newland.nsdk.core.api.common.keymanager.KeyType
import com.newland.nsdk.core.api.common.keymanager.KeyUsage
import com.newland.nsdk.core.api.common.keymanager.SymmetricKey

internal fun XPayKeyType.toNewLandKeyType(): KeyType {
    return when (this) {
        XPayKeyType.DES -> KeyType.DES
        XPayKeyType.AES -> KeyType.AES
        XPayKeyType.SM4 -> KeyType.SM4
    }
}

internal fun XPayKeyUsage.toNewLandKeyUsage(): KeyUsage {
    return when (this) {
        XPayKeyUsage.KEK -> KeyUsage.KEK
        XPayKeyUsage.PIN_KEK -> KeyUsage.PIN_KEK
        XPayKeyUsage.MAC_KEK -> KeyUsage.MAC_KEK
        XPayKeyUsage.DATA_KEK -> KeyUsage.DATA_KEK
        XPayKeyUsage.DATA_ENC_KEK -> KeyUsage.DATA_ENC_KEK
        XPayKeyUsage.TR31_KEK -> KeyUsage.TR31_KEK
        XPayKeyUsage.PIN -> KeyUsage.PIN
        XPayKeyUsage.MAC -> KeyUsage.MAC
        XPayKeyUsage.DATA -> KeyUsage.DATA
        XPayKeyUsage.DATA_ENC_ONLY -> KeyUsage.DATA_ENC_ONLY
        XPayKeyUsage.DUKPT -> KeyUsage.DUKPT
    }
}

internal fun XPayDUKPTDerivateUsage.toNewLandDUKPTDerivateUsage(): DUKPTDerivateUsage {
    return when (this) {
        XPayDUKPTDerivateUsage.NONE -> DUKPTDerivateUsage.NONE
        XPayDUKPTDerivateUsage.KEK -> DUKPTDerivateUsage.KEK
        XPayDUKPTDerivateUsage.PIN -> DUKPTDerivateUsage.PIN
        XPayDUKPTDerivateUsage.MAC_GEN -> DUKPTDerivateUsage.MAC_GEN
        XPayDUKPTDerivateUsage.MAC_VERIFY -> DUKPTDerivateUsage.MAC_VERIFY
        XPayDUKPTDerivateUsage.MAC_BOTH -> DUKPTDerivateUsage.MAC_BOTH
        XPayDUKPTDerivateUsage.DATA_ENC -> DUKPTDerivateUsage.DATA_ENC
        XPayDUKPTDerivateUsage.DATA_DEC -> DUKPTDerivateUsage.DATA_DEC
        XPayDUKPTDerivateUsage.DATA_BOTH -> DUKPTDerivateUsage.DATA_BOTH
        XPayDUKPTDerivateUsage.DERIVATEKEY -> DUKPTDerivateUsage.DERIVATEKEY
        XPayDUKPTDerivateUsage.DERIVATEKEY_INITIAL -> DUKPTDerivateUsage.DERIVATEKEY_INITIAL
    }
}

internal fun XPayDUKPTDerivateKey.toNewLandDUKPTDerivateKey(): DUKPTDerivateKey {
    val dukptDerivateKey = DUKPTDerivateKey()
    dukptDerivateKey.derivateKeyType = this.keyType.toNewLandKeyType()
    dukptDerivateKey.derivateUsage = this.derivateUsage.toNewLandDUKPTDerivateUsage()
    dukptDerivateKey.derivateKeyLen = this.derivateKeyLen
    return dukptDerivateKey
}

internal fun XPaySymmetricKey.toNewLandXPaySymmetricKey(): SymmetricKey {
    val symmetricKey = SymmetricKey()
    symmetricKey.keyType = this.keyType.toNewLandKeyType()
    symmetricKey.keyUsage = this.keyUsage.toNewLandKeyUsage()
    symmetricKey.kcv = this.kcv
    symmetricKey.kcvMode = this.kcvMode.toNewLandMACType()
    return symmetricKey
}

internal fun XPayKeyInfoID.toNewLandXPayKeyInfoID(): KeyInfoID {
    return when (this) {
        XPayKeyInfoID.KEY_LEN -> KeyInfoID.KEY_LEN
        XPayKeyInfoID.KCV -> KeyInfoID.KCV
        XPayKeyInfoID.KSN -> KeyInfoID.KSN
        XPayKeyInfoID.CERTIFICATE -> KeyInfoID.CERTIFICATE
        XPayKeyInfoID.CERTIFICATE_LEN -> KeyInfoID.CERTIFICATE_LEN
        XPayKeyInfoID.PUBLIC_KEY -> KeyInfoID.PUBLIC_KEY
        XPayKeyInfoID.CMAC_KCV -> KeyInfoID.CMAC_KCV
        XPayKeyInfoID.RKI_CA_CERT -> KeyInfoID.RKI_CA_CERT
        XPayKeyInfoID.RKI_CA_PUBKEY -> KeyInfoID.RKI_CA_PUBKEY
    }
}

internal fun XPayKeyGenerateMethod.toNewLandKeyGenerateMethod(): KeyGenerateMethod {
    return when (this) {
        XPayKeyGenerateMethod.CLEAR -> KeyGenerateMethod.CLEAR
        XPayKeyGenerateMethod.CIPHER -> KeyGenerateMethod.CIPHER
        XPayKeyGenerateMethod.TR31 -> KeyGenerateMethod.TR31
        XPayKeyGenerateMethod.RANDOM -> KeyGenerateMethod.RANDOM
        XPayKeyGenerateMethod.RANDOM_OUT -> KeyGenerateMethod.RANDOM_OUT
        XPayKeyGenerateMethod.DUKPT_DERIVE -> KeyGenerateMethod.DUKPT_DERIVE
        XPayKeyGenerateMethod.DIVERSIFY_X -> KeyGenerateMethod.DIVERSIFY_X
        XPayKeyGenerateMethod.GISKE -> KeyGenerateMethod.GISKE
        XPayKeyGenerateMethod.RANDOM_OUT_TR31 -> KeyGenerateMethod.RANDOM_OUT_TR31
        XPayKeyGenerateMethod.CIPHER_VTB -> KeyGenerateMethod.CIPHER_VTB
        XPayKeyGenerateMethod.AES_DUKPT_UPDATE_IK -> KeyGenerateMethod.AES_DUKPT_UPDATE_IK
        XPayKeyGenerateMethod.HKDF -> KeyGenerateMethod.HKDF
        XPayKeyGenerateMethod.ANSI_X9143 -> KeyGenerateMethod.ANSI_X9143
    }
}

internal fun XPayCipherMode.toNewLandCipherMode(): CipherMode {
    return when (this) {
        XPayCipherMode.ECB -> CipherMode.ECB
        XPayCipherMode.CBC -> CipherMode.CBC
        XPayCipherMode.CFB -> CipherMode.CFB
        XPayCipherMode.OFB -> CipherMode.OFB
        XPayCipherMode.CTR -> CipherMode.CTR
        XPayCipherMode.GCM -> CipherMode.GCM
        XPayCipherMode.STREAM -> CipherMode.STREAM
        XPayCipherMode.CCM -> CipherMode.CCM
    }
}

internal fun XPayAlgorithmParameters.toNewLandAlgorithmParameters(): AlgorithmParameters {
    val algorithmParameters = AlgorithmParameters()
    algorithmParameters.paddingMode = this.paddingMode.toNewLandPaddingMode()
    algorithmParameters.cipherMode = this.cipherMode.toNewLandCipherMode()
    algorithmParameters.iv = this.iv
    return algorithmParameters
}

internal fun XPayKey.toNewLandKey(): Key {
    val newLandKey = when (this) {
        is XPaySymmetricKey -> {
            val symmetricKey = SymmetricKey()
            symmetricKey.keyType = this.keyType.toNewLandKeyType()
            symmetricKey.keyUsage = this.keyUsage.toNewLandKeyUsage()
            symmetricKey.kcv = this.kcv
            symmetricKey.kcvMode = this.kcvMode.toNewLandMACType()
            symmetricKey.keyLen = this.keyLen
            symmetricKey.keyID = this.keyID
            symmetricKey.keyData = this.keyData
            symmetricKey
        }

        else -> {
            val xPayAsymmetricKey = (this as XPayAsymmetricKey)
            val asymmetricKey = AsymmetricKey()
            asymmetricKey.keyType = xPayAsymmetricKey.keyType.toNewLandAsymKeyType()
            asymmetricKey.keyUsage = xPayAsymmetricKey.keyUsage.toNewLandAsymKeyUsage()
            asymmetricKey.keyLen = xPayAsymmetricKey.keyLen
            asymmetricKey.keyID = xPayAsymmetricKey.keyID
            asymmetricKey.keyData = xPayAsymmetricKey.keyData
            asymmetricKey
        }
    }
    return newLandKey
}