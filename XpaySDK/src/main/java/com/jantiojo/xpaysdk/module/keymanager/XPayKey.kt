package com.jantiojo.xpaysdk.module.keymanager

abstract class XPayKey{
     abstract val keyLen: Int
     abstract val keyID: Byte
     abstract val keyData: ByteArray
}