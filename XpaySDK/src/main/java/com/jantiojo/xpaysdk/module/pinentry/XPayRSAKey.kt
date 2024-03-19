package com.jantiojo.xpaysdk.module.pinentry

data class XPayRSAKey(
    val modulus : ByteArray?,
    val exponent: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayRSAKey

        if (modulus != null) {
            if (other.modulus == null) return false
            if (!modulus.contentEquals(other.modulus)) return false
        } else if (other.modulus != null) return false
        if (exponent != null) {
            if (other.exponent == null) return false
            if (!exponent.contentEquals(other.exponent)) return false
        } else if (other.exponent != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = modulus?.contentHashCode() ?: 0
        result = 31 * result + (exponent?.contentHashCode() ?: 0)
        return result
    }
}