package com.jantiojo.xpaysdk.module.card

data class XPayActivationResult(
    val uid :ByteArray = byteArrayOf(),
    val atqa :ByteArray = byteArrayOf(),
    val ats :ByteArray = byteArrayOf(),
    val atqb :ByteArray = byteArrayOf(),
    val sak :ByteArray = byteArrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayActivationResult

        if (!uid.contentEquals(other.uid)) return false
        if (!atqa.contentEquals(other.atqa)) return false
        if (!ats.contentEquals(other.ats)) return false
        if (!atqb.contentEquals(other.atqb)) return false
        if (!sak.contentEquals(other.sak)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uid.contentHashCode()
        result = 31 * result + atqa.contentHashCode()
        result = 31 * result + ats.contentHashCode()
        result = 31 * result + atqb.contentHashCode()
        result = 31 * result + sak.contentHashCode()
        return result
    }
}