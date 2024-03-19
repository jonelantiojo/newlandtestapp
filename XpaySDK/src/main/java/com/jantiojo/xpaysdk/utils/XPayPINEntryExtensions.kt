package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.pinentry.XPayPINBlockMode
import com.jantiojo.xpaysdk.module.pinentry.XPayPINEntryParameters
import com.jantiojo.xpaysdk.module.pinentry.XPayRSAKey
import com.newland.nsdk.core.api.common.pinentry.PINBlockMode
import com.newland.nsdk.core.api.internal.pinentry.PINEntryParameters
import com.newland.nsdk.core.api.internal.pinentry.RSAKey

internal fun XPayPINBlockMode.toNewLandPINBlockMode(): PINBlockMode {
    return when (this) {
        XPayPINBlockMode.ISO9564_0 -> PINBlockMode.ISO9564_0
        XPayPINBlockMode.ISO9564_1 -> PINBlockMode.ISO9564_1
        XPayPINBlockMode.ISO9564_2 -> PINBlockMode.ISO9564_2
        XPayPINBlockMode.ISO9564_3 -> PINBlockMode.ISO9564_3
        XPayPINBlockMode.SM4_1 -> PINBlockMode.SM4_1
        XPayPINBlockMode.SM4_2 -> PINBlockMode.SM4_2
        XPayPINBlockMode.SM4_3 -> PINBlockMode.SM4_3
        XPayPINBlockMode.SM4_4 -> PINBlockMode.SM4_4
        XPayPINBlockMode.SM4_5 -> PINBlockMode.SM4_5
        XPayPINBlockMode.ISO9564_4 -> PINBlockMode.ISO9564_4
    }
}

internal fun XPayPINEntryParameters.toNewLandPINEntryParameters(): PINEntryParameters {
    val pinEntryParameters = PINEntryParameters()
    pinEntryParameters.pinLengthRange = pinLengthRange
    pinEntryParameters.maxPINLen = maxPINLen
    pinEntryParameters.minPINLen = minPINLen
    pinEntryParameters.pinBlockMode = pinBlockMode.toNewLandPINBlockMode()
    pinEntryParameters.isAutoComplete = isAutoComplete
    return pinEntryParameters
}

internal fun XPayRSAKey.toNewLandRSAKey(): RSAKey {
    val rsaKey = RSAKey()
    rsaKey.modulus = modulus
    rsaKey.exponent = exponent
    return rsaKey
}
