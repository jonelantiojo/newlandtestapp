package com.jantiojo.xpaysdk.module.card

data class XPayMagCardInfo(
    val trackStatus: List<XPayTrackStatus> = emptyList(),
    val track1Data: ByteArray = byteArrayOf(),
    val track2Data: ByteArray = byteArrayOf(),
    val track3Data: ByteArray = byteArrayOf(),
    val panData: ByteArray = byteArrayOf(),
    val firstClearPAN: String = "",
    val lastClearPAN: String = "",
    val plainPANLen: Int = 0,
    val plainTrack1DataLen: Int = 0,
    val plainTrack2ataLen: Int = 0,
    val plainTrack3DataLen: Int = 0,
    val validDate: String = "",
    val serviceCode: String = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as XPayMagCardInfo

        if (trackStatus != other.trackStatus) return false
        if (!track1Data.contentEquals(other.track1Data)) return false
        if (!track2Data.contentEquals(other.track2Data)) return false
        if (!track3Data.contentEquals(other.track3Data)) return false
        if (!panData.contentEquals(other.panData)) return false
        if (firstClearPAN != other.firstClearPAN) return false
        if (lastClearPAN != other.lastClearPAN) return false
        if (plainPANLen != other.plainPANLen) return false
        if (plainTrack1DataLen != other.plainTrack1DataLen) return false
        if (plainTrack2ataLen != other.plainTrack2ataLen) return false
        if (plainTrack3DataLen != other.plainTrack3DataLen) return false
        if (validDate != other.validDate) return false
        if (serviceCode != other.serviceCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = trackStatus.hashCode()
        result = 31 * result + track1Data.contentHashCode()
        result = 31 * result + track2Data.contentHashCode()
        result = 31 * result + track3Data.contentHashCode()
        result = 31 * result + panData.contentHashCode()
        result = 31 * result + firstClearPAN.hashCode()
        result = 31 * result + lastClearPAN.hashCode()
        result = 31 * result + plainPANLen
        result = 31 * result + plainTrack1DataLen
        result = 31 * result + plainTrack2ataLen
        result = 31 * result + plainTrack3DataLen
        result = 31 * result + validDate.hashCode()
        result = 31 * result + serviceCode.hashCode()
        return result
    }
}