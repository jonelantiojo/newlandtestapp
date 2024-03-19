package com.jantiojo.xpaysdk.module.routemanager

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandNetworkType
import com.jantiojo.xpaysdk.utils.toXPayRouteInfo
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.internal.routemanager.RouteManager

class XPayRouteManager : XPayModule() {

    private val routeManager by lazy { xPayModuleManager.getModule(ModuleType.ROUTE_MANAGER) as RouteManager }


    val routeList: List<XPayRouteInfo> = routeManager.routeList.map { it.toXPayRouteInfo() }

    fun enableMultiPath() {
        try {
            routeManager.enableMultiPath()
        } catch (e: NSDKException) {
            //Exception Here
        }
    }

    fun disableMultiPath() {
        try {
            routeManager.disableMultiPath()
        } catch (e: NSDKException) {
            //Exception Here
        }
    }

    fun addRoute(ip: String, networkType: XPayNetworkType) {
        try {
            routeManager.addRoute(ip, networkType.toNewLandNetworkType())
        } catch (e: NSDKException) {
            //Exception Here
        }
    }

    fun removeRoute(ip: String, networkType: XPayNetworkType) {
        try {
            routeManager.removeRoute(ip, networkType.toNewLandNetworkType())
        } catch (e: NSDKException) {
            //Exception Here
        }
    }

    fun removeAllRoute() {
        try {
            routeManager.removeAllRoute()
        } catch (e: NSDKException) {
            //Exception Here
        }
    }

    fun queryRouteByIp(ip: String): XPayRouteInfo? {
        return try {
            routeManager.queryRouteByIp(ip)?.toXPayRouteInfo()
        } catch (e: NSDKException) {
            //Exception Here
            null
        }
    }

}