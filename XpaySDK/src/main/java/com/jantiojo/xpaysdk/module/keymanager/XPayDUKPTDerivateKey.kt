package com.jantiojo.xpaysdk.module.keymanager

import com.jantiojo.xpaysdk.module.crypto.XPayKCVMode

data class XPayDUKPTDerivateKey(
    val derivateUsage: XPayDUKPTDerivateUsage,
    val derivateKeyLen: Int,

    override val kcv: ByteArray,
    override val kcvMode: XPayKCVMode,
    override val keyType: XPayKeyType,
    override val keyUsage: XPayKeyUsage

) : XPaySymmetricKey(
    keyType,
    keyUsage,
    kcv,
    kcvMode
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayDUKPTDerivateKey

        if (derivateUsage != other.derivateUsage) return false
        if (derivateKeyLen != other.derivateKeyLen) return false
        if (!kcv.contentEquals(other.kcv)) return false
        if (kcvMode != other.kcvMode) return false
        if (keyType != other.keyType) return false
        if (keyUsage != other.keyUsage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = derivateUsage.hashCode()
        result = 31 * result + derivateKeyLen
        result = 31 * result + kcv.contentHashCode()
        result = 31 * result + kcvMode.hashCode()
        result = 31 * result + keyType.hashCode()
        result = 31 * result + keyUsage.hashCode()
        return result
    }
}
