package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.routemanager.XPayNetworkType
import com.jantiojo.xpaysdk.module.routemanager.XPayRouteInfo
import com.newland.nsdk.core.api.internal.routemanager.NetWorkType
import com.newland.nsdk.core.api.internal.routemanager.RouteInfo


internal fun XPayNetworkType.toNewLandNetworkType(): NetWorkType {
    return when (this) {
        XPayNetworkType.NET_WORK_MOBILE -> NetWorkType.NET_WORK_MOBILE
        XPayNetworkType.NET_WORK_WIFI -> NetWorkType.NET_WORK_WIFI
        XPayNetworkType.NET_WORK_ETHERNET -> NetWorkType.NET_WORK_ETHERNET
    }
}

internal fun RouteInfo.toXPayRouteInfo() : XPayRouteInfo {
    return XPayRouteInfo(
        address = address,
        networkType = networkType
    )
}