package com.jantiojo.xpaysdk.module.crypto

data class XPayMACOutput(
    val data: ByteArray,
    val ksn: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayMACOutput

        if (!data.contentEquals(other.data)) return false
        if (!ksn.contentEquals(other.ksn)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + ksn.contentHashCode()
        return result
    }
}
