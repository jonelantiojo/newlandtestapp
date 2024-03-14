package com.jantiojo.xpaysdk.module

import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.beeper.Beeper

class XPayBeeper : XPayModule() {

    private val beeper by lazy { xPayModuleManager.getModule(ModuleType.BEEPER) as Beeper }

    /**
     *  call to make sounds or beep
     *
     *  @param frequency - Beeping frequency, unit：Hz, value range: (0-4000]
     *  @param duration - The period of time to beep. Unit ms and value must >0
     */
    fun playSound(frequency: Int, duration: Int) {
        try {
            beeper.beep(frequency, duration)
        } catch (e: NSDKException) {
            e.printStackTrace()
            //Add Error Listener Here
        }
    }
}