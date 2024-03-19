package com.jantiojo.xpaysdk.module.serialportmanager

import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayBaudRate
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayDataBits
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayParityBit
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayStopBits

data class XPaySerialPortSettings(
    val baudRate: XPayBaudRate = XPayBaudRate.BPS115200,
    val dataBits: XPayDataBits = XPayDataBits.DATA_BIT_8,
    val parityBit: XPayParityBit = XPayParityBit.NO_CHECK,
    val stopBits: XPayStopBits = XPayStopBits.STOP_BIT_ONE,
    val isBlocked: Boolean = false,
    val isFlowCtr: Boolean = false,
)
