package com.jantiojo.xpaysdk.module.card

data class XPayContactlessCardInfo(
    val iDmPMm: ByteArray = byteArrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayContactlessCardInfo

        return iDmPMm.contentEquals(other.iDmPMm)
    }

    override fun hashCode(): Int {
        return iDmPMm.contentHashCode()
    }
}