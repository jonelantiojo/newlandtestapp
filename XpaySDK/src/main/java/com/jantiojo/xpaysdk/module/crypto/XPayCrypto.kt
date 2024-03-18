package com.jantiojo.xpaysdk.module.crypto

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.module.keymanager.XPayDUKPTDerivateKey
import com.jantiojo.xpaysdk.module.keymanager.XPaySymmetricKey
import com.jantiojo.xpaysdk.utils.toNewLandAsymmetricKey
import com.jantiojo.xpaysdk.utils.toNewLandDUKPTDerivateKey
import com.jantiojo.xpaysdk.utils.toNewLandMACType
import com.jantiojo.xpaysdk.utils.toNewLandXPaySymmetricKey
import com.jantiojo.xpaysdk.utils.toXPayMACOutput
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.crypto.Crypto

class XPayCrypto : XPayModule() {

    private val crypto by lazy { xPayModuleManager.getModule(ModuleType.CRYPTO) as Crypto }


    fun generateMAC(
        macIndex: Byte,
        macType: XPayMACType,
        dataByteArray: ByteArray
    ): XPayMACOutput {
        return crypto.generateMAC(
            macIndex,
            macType.toNewLandMACType(),
            null,
            dataByteArray
        ).toXPayMACOutput()
    }

    fun generateMACDerivateKey(
        key: XPayDUKPTDerivateKey,
        macType: XPayMACType,
        dataByteArray: ByteArray
    ): XPayMACOutput {
        return crypto.generateMAC(
            key.toNewLandDUKPTDerivateKey(),
            macType.toNewLandMACType(),
            null,
            dataByteArray
        ).toXPayMACOutput()
    }

    fun encrypt(
        symmetricKey: XPaySymmetricKey,
        cipherType: XPayCipherType,
        paddingMode: XPayPaddingMode? = null,
        byte: ByteArray? = null,
        dataIn: ByteArray
    ) {
        crypto.encrypt(
            symmetricKey.toNewLandXPaySymmetricKey(),
            cipherType.toNewLandMACType(),
            paddingMode?.toNewLandMACType(),
            byte,
            dataIn
        )
    }

    fun decrypt(
        symmetricKey: XPaySymmetricKey,
        cipherType: XPayCipherType,
        paddingMode: XPayPaddingMode? = null,
        byte: ByteArray? = null,
        dataIn: ByteArray
    ) {
        crypto.decrypt(
            symmetricKey.toNewLandXPaySymmetricKey(),
            cipherType.toNewLandMACType(),
            paddingMode?.toNewLandMACType(),
            byte,
            dataIn
        )
    }

    fun getRandom(dataLen: Int): ByteArray {
        return try {
            crypto.getRandom(dataLen)
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    fun signAsym(
        key: XPayAsymmetricKey,
        parameters: XPayAsymAlgorithmParameters,
        hash: ByteArray
    ): ByteArray {
        return try {
            crypto.signAsym(
                key.toNewLandAsymmetricKey(),
                parameters.toNewLandAsymmetricKey(),
                hash
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    fun verifyAsym(
        key: XPayAsymmetricKey,
        parameters: XPayAsymAlgorithmParameters,
        hash: ByteArray,
        signedData: ByteArray
    ) {
        try {
            crypto.verifyAsym(
                key.toNewLandAsymmetricKey(),
                parameters.toNewLandAsymmetricKey(),
                hash,
                signedData
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    fun encryptAsym(
        key: XPayAsymmetricKey,
        parameters: XPayAsymAlgorithmParameters,
        data: ByteArray
    ): ByteArray {
        return try {
            crypto.encryptAsym(
                key.toNewLandAsymmetricKey(),
                parameters.toNewLandAsymmetricKey(),
                data
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    fun decryptAsym(
        key: XPayAsymmetricKey,
        parameters: XPayAsymAlgorithmParameters,
        encrytedData: ByteArray
    ): ByteArray {
        return try {
            crypto.decryptAsym(
                key.toNewLandAsymmetricKey(),
                parameters.toNewLandAsymmetricKey(),
                encrytedData
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }
}