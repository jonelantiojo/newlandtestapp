package com.jantiojo.xpaysdk.module

import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.setting.SettingsManager


class XPaySettingManager : XPayModule() {
    private val settingManager by lazy { xPayModuleManager.getModule(ModuleType.SETTINGS) as SettingsManager }

    /**
     *  call to get the device config.
     *
     *  @param settingName - [Required] The key of device config item.
     *  @param value - [Optional] The value of the config item.
     *  @return The config item value .
     */
    fun setConfig(settingName: String, value: String? = null) {
        try {
            settingManager.set(settingName, value)
        } catch (e: NSDKException) {
            //Handle the exception
        }
    }

    /**
     *  call to get the device config.
     *
     *  @param settingName - [Required] The key of device config item.
     *
     *  @return The config item value .
     */
    fun getConfig(settingName: String): String {
        return try {
            settingManager.get(settingName)
        } catch (e: NSDKException) {
            //Handle the exception
            ""
        }
    }
}