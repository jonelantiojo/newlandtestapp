package com.jantiojo.xpaysdk.module.pinentry

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.module.keymanager.XPayKey
import com.jantiojo.xpaysdk.utils.toNewLandKey
import com.jantiojo.xpaysdk.utils.toNewLandPINEntryParameters
import com.jantiojo.xpaysdk.utils.toNewLandRSAKey
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.pinentry.PINEntry
import com.newland.nsdk.core.api.internal.pinentry.PINEntryListener
import com.newland.nsdk.core.api.internal.pinentry.PINEntryParameters

class XPayPINEntry : XPayModule() {

    private val pinEntry by lazy { xPayModuleManager.getModule(ModuleType.PIN_ENTRY) as PINEntry }


    /**
     * Draw a keyboard widget to get the coordinates of the buttons, and then call the initKeyLayout to initialize the layout.
     *
     * @param numBtn - [Required] 10 number buttons. Each button can be defined by two coordinate points(8 bytes): left-top and right-bottom.
     * @param  funcBtn - Required] Function buttons(Backspace, Cancel, Enter). Each button can be defined by key ID(4 bytes) and two coordinate points(8 bytes).
     * @param isRandomKeyboard - Whether return randomized number buffer or not.
     *
     * @return   10 number values that match the 10 number button. This can be used to display keyboard.
     */
    fun initKeyLayout(
        numBtn: ByteArray,
        funcBtn: ByteArray,
        isRandomKeyboard: Boolean
    ): ByteArray {
        return try {
            pinEntry.initKeyLayout(
                numBtn,
                funcBtn,
                isRandomKeyboard
            )
        } catch (e: NSDKException) {
            e.printStackTrace()
            byteArrayOf()
        }
    }

    /**
     * start online PIN Input
     *
     * @param xPayKey -
     * key - [Required] The key to encrypt PIN.
     *  Key ID
     *  Key type
     *  Key usage: If using DUKPT to encrypt PIN, set key usage to KeyUsage.DUKPT
     * @param pan - [Required] PAN.
     *
     *  @param timeout - [Required] Timeout for PIN entry. Unit: second. Value range: [5-200].
     *
     *  @param xPayPINEntryParameters - Required] PIN entry parameters.[Required] PIN block mode
     *  @see PINEntryParameters
     *
     * @param xPayPINEntryListener - [Required] Listens to PIN events. See PINEntryListener
     *
     */
    fun startOnlinePINEntry(
        xPayKey: XPayKey,
        pan: String,
        timeout: Int,
        xPayPINEntryParameters: XPayPINEntryParameters,
        xPayPINEntryListener: XPayPINEntryListener
    ) {
        try {
            pinEntry.startOnlinePINEntry(
                xPayKey.toNewLandKey(),
                pan,
                timeout,
                xPayPINEntryParameters.toNewLandPINEntryParameters(),
                object :
                    PINEntryListener {
                    override fun onFinish(p0: Int, p1: ByteArray?, p2: ByteArray?) {
                        xPayPINEntryListener.onFinish(p0, p1, p2)
                    }

                    override fun onTimeout() {
                        xPayPINEntryListener.onTimeout()
                    }

                    override fun onKeyPress() {
                        xPayPINEntryListener.onKeyPress()
                    }

                    override fun onCancel() {
                        xPayPINEntryListener.onCancel()
                    }

                    override fun onClear() {
                        xPayPINEntryListener.onClear()
                    }

                    override fun onBackspace() {
                        xPayPINEntryListener.onBackspace()
                    }

                    override fun onError(p0: Int, p1: String?) {
                        xPayPINEntryListener.onError(p0, p1)
                    }
                })
        } catch (e: NSDKException) {
            e.printStackTrace()
            xPayPINEntryListener.onError(e.code, e.message)
        }
    }


    /**
     * start online PIN Input
     *
     * Note: This method contains two options:
     * 1.Input offline PIN
     * 2.Verify offline PIN
     *
     * @param xPayRSAKey - [Optional] RSA key. This is required when cipher PIN, otherwise it can set to null.
     *
     *  @param timeout - [Required] Timeout for PIN entry. Unit: second. Value range: [5-200].
     *
     *  @param xPayPINEntryParameters - Required] PIN entry parameters.[Required] PIN block mode
     *  @see PINEntryParameters
     *
     * @param xPayPINEntryListener - [Required] Listens to PIN events. See PINEntryListener
     *
     */

    fun startOfflinePINEntry(
        xPayRSAKey: XPayRSAKey? = null,
        timeout: Int,
        xPayPINEntryParameters: XPayPINEntryParameters,
        xPayPINEntryListener: XPayPINEntryListener
    ) {
        try {
            pinEntry.startOfflinePINEntry(
                xPayRSAKey?.toNewLandRSAKey(),
                timeout,
                xPayPINEntryParameters.toNewLandPINEntryParameters(),
                object :
                    PINEntryListener {
                    override fun onFinish(p0: Int, p1: ByteArray?, p2: ByteArray?) {
                        xPayPINEntryListener.onFinish(p0, p1, p2)
                    }

                    override fun onTimeout() {
                        xPayPINEntryListener.onTimeout()
                    }

                    override fun onKeyPress() {
                        xPayPINEntryListener.onKeyPress()
                    }

                    override fun onCancel() {
                        xPayPINEntryListener.onCancel()
                    }

                    override fun onClear() {
                        xPayPINEntryListener.onClear()
                    }

                    override fun onBackspace() {
                        xPayPINEntryListener.onBackspace()
                    }

                    override fun onError(p0: Int, p1: String?) {
                        xPayPINEntryListener.onError(p0, p1)
                    }
                })
        } catch (e: NSDKException) {
            e.printStackTrace()
            xPayPINEntryListener.onError(e.code, e.message)
        }
    }

    /**
     * Cancels PIN entry.
     */
    fun cancelPINEntry() {
        try {
            pinEntry.cancelPINEntry()
        } catch (e: NSDKException) {
            e.printStackTrace()
        }
    }
}
