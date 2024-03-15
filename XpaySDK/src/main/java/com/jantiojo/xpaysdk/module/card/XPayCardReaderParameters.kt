package com.jantiojo.xpaysdk.module.card

data class XPayCardReaderParameters(
    val contactLessCardTypes: List<XPayContactLessCardType> = emptyList(),
    val isVerifyTrack: Boolean = false,
    val typeFParameters: ByteArray = byteArrayOf(),
    val typeVParameters: ByteArray = byteArrayOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayCardReaderParameters

        if (contactLessCardTypes != other.contactLessCardTypes) return false
        if (isVerifyTrack != other.isVerifyTrack) return false
        if (!typeFParameters.contentEquals(other.typeFParameters)) return false
        if (!typeVParameters.contentEquals(other.typeVParameters)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = contactLessCardTypes.hashCode()
        result = 31 * result + isVerifyTrack.hashCode()
        result = 31 * result + typeFParameters.contentHashCode()
        result = 31 * result + typeVParameters.contentHashCode()
        return result
    }
}