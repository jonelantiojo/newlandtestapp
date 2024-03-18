package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.keymanager.XPayDUKPTDerivateKey
import com.jantiojo.xpaysdk.module.keymanager.XPayDUKPTDerivateUsage
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyType
import com.jantiojo.xpaysdk.module.keymanager.XPayKeyUsage
import com.jantiojo.xpaysdk.module.keymanager.XPaySymmetricKey
import com.newland.nsdk.core.api.common.keymanager.DUKPTDerivateKey
import com.newland.nsdk.core.api.common.keymanager.DUKPTDerivateUsage
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