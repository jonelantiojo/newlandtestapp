package com.jantiojo.xpaysdk.module.ethernetmanager

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toXPayEthernetStatus
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.ethernetmanager.EthernetManager

class XPayEthernetManager : XPayModule() {

    private val ethernetManager by lazy { xPayModuleManager.getModule(ModuleType.ETHERNET_MANAGER) as EthernetManager }


    val ethernetStatus: XPayEthernetStatus = ethernetManager.status.toXPayEthernetStatus()

    val config: String = ethernetManager.config

    fun open() {
        try {
            ethernetManager.enable()
        } catch (e: NSDKException) {
            // Handle the exception.
        }
    }

    fun close() {
        try {
            ethernetManager.disable()
        } catch (e: NSDKException) {
            // Handle the exception.
        }
    }
}