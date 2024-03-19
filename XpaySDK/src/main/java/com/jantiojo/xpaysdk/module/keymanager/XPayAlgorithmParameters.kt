package com.jantiojo.xpaysdk.module.keymanager

import com.jantiojo.xpaysdk.module.crypto.XPayPaddingMode

data class XPayAlgorithmParameters(
    val paddingMode: XPayPaddingMode,
    val cipherMode: XPayCipherMode,
    val iv: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayAlgorithmParameters

        if (paddingMode != other.paddingMode) return false
        if (cipherMode != other.cipherMode) return false
        if (!iv.contentEquals(other.iv)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = paddingMode.hashCode()
        result = 31 * result + cipherMode.hashCode()
        result = 31 * result + iv.contentHashCode()
        return result
    }
}
