package com.jantiojo.xpaysdk.module.keymanager

import com.jantiojo.xpaysdk.module.crypto.XPayKCVMode

open class XPaySymmetricKey(
    open val keyType: XPayKeyType,
    open val keyUsage: XPayKeyUsage,
    open val kcv : ByteArray,
    open val kcvMode : XPayKCVMode
)
