package com.jantiojo.xpaysdk.module.crypto

import com.jantiojo.xpaysdk.module.keymanager.XPayKey

data class XPayAsymmetricKey(
    val keyType: XPayAsymKeyType,
    val keyUsage: XPayAsymKeyUsage,
    override val keyLen: Int,
    override val keyID: Byte,
    override val keyData: ByteArray
) : XPayKey() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayAsymmetricKey

        if (keyType != other.keyType) return false
        if (keyUsage != other.keyUsage) return false
        if (keyLen != other.keyLen) return false
        if (keyID != other.keyID) return false
        if (!keyData.contentEquals(other.keyData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = keyType.hashCode()
        result = 31 * result + keyUsage.hashCode()
        result = 31 * result + keyLen
        result = 31 * result + keyID
        result = 31 * result + keyData.contentHashCode()
        return result
    }
}
