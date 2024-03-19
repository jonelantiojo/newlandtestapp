package com.jantiojo.xpaysdk.module.keymanager

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.module.crypto.XPayAsymmetricKey
import com.jantiojo.xpaysdk.utils.toNewLandAlgorithmParameters
import com.jantiojo.xpaysdk.utils.toNewLandAsymmetricKey
import com.jantiojo.xpaysdk.utils.toNewLandKey
import com.jantiojo.xpaysdk.utils.toNewLandKeyGenerateMethod
import com.jantiojo.xpaysdk.utils.toNewLandXPayKeyInfoID
import com.jantiojo.xpaysdk.utils.toNewLandXPaySymmetricKey
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.keymanager.KeyManager

class XPayKeyManager : XPayModule() {

    private val keyManager by lazy { xPayModuleManager.getModule(ModuleType.KEY_MANAGER) as KeyManager }

    fun generateKey(
        keyGenerateMethod: XPayKeyGenerateMethod,
        algorithmParameters: XPayAlgorithmParameters? = null,
        symmetricKey: XPaySymmetricKey? = null,
        asymmetricKey: XPayAsymmetricKey? = null,
        dataArray: ByteArray? = null
    ) {
        keyManager.generateKey(
            keyGenerateMethod.toNewLandKeyGenerateMethod(),
            algorithmParameters?.toNewLandAlgorithmParameters(),
            symmetricKey?.toNewLandXPaySymmetricKey(),
            asymmetricKey?.toNewLandAsymmetricKey(),
            dataArray
        )
    }

    fun decryptAsym(
        keyInfoID: XPayKeyInfoID,
        key: XPaySymmetricKey,
    ): ByteArray {
        return try {
            keyManager.getKeyInfo(
                keyInfoID.toNewLandXPayKeyInfoID(),
                key.toNewLandXPaySymmetricKey()
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    fun deleteKey(key: XPayKey) {
        keyManager.deleteKey(key.toNewLandKey())
    }
}