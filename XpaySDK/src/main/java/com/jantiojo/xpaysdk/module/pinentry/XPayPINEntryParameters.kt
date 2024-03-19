package com.jantiojo.xpaysdk.module.pinentry


data class XPayPINEntryParameters(
    val pinLengthRange: ByteArray,
    val maxPINLen: Int = 12,
    val minPINLen: Int = 4,
    val pinBlockMode: XPayPINBlockMode,
    val isAutoComplete: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayPINEntryParameters

        if (!pinLengthRange.contentEquals(other.pinLengthRange)) return false
        if (maxPINLen != other.maxPINLen) return false
        if (minPINLen != other.minPINLen) return false
        if (pinBlockMode != other.pinBlockMode) return false
        if (isAutoComplete != other.isAutoComplete) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pinLengthRange.contentHashCode()
        result = 31 * result + maxPINLen
        result = 31 * result + minPINLen
        result = 31 * result + pinBlockMode.hashCode()
        result = 31 * result + isAutoComplete.hashCode()
        return result
    }
}