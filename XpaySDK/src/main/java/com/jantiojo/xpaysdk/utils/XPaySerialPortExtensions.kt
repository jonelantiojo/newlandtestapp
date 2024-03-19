package com.jantiojo.xpaysdk.utils

import com.jantiojo.xpaysdk.module.serialportmanager.XPaySerialPortSettings
import com.jantiojo.xpaysdk.module.serialportmanager.XPaySerialPortType
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayBaudRate
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayDataBits
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayParityBit
import com.jantiojo.xpaysdk.module.serialportmanager.serialport.XPayStopBits
import com.newland.nsdk.core.api.common.serialport.BaudRate
import com.newland.nsdk.core.api.common.serialport.DataBits
import com.newland.nsdk.core.api.common.serialport.ParityBit
import com.newland.nsdk.core.api.common.serialport.SerialPortSettings
import com.newland.nsdk.core.api.common.serialport.StopBits
import com.newland.nsdk.core.api.internal.serialportmanager.SerialPortType

internal fun XPaySerialPortType.toNewLandSerialPortType(): SerialPortType {
    return when (this) {
        XPaySerialPortType.RS232 -> SerialPortType.RS232
        XPaySerialPortType.RS232B -> SerialPortType.RS232B
        XPaySerialPortType.PINPAD -> SerialPortType.PINPAD
        XPaySerialPortType.USB -> SerialPortType.USB
        XPaySerialPortType.USB_HOST -> SerialPortType.USB_HOST
    }
}

internal fun XPayBaudRate.toNewLandBaudRate(): BaudRate {
    return when (this) {
        XPayBaudRate.BPS300 -> BaudRate.BPS300
        XPayBaudRate.BPS1200 -> BaudRate.BPS1200
        XPayBaudRate.BPS2400 -> BaudRate.BPS2400
        XPayBaudRate.BPS4800 -> BaudRate.BPS4800
        XPayBaudRate.BPS7200 -> BaudRate.BPS7200
        XPayBaudRate.BPS9600 -> BaudRate.BPS9600
        XPayBaudRate.BPS19200 -> BaudRate.BPS19200
        XPayBaudRate.BPS38400 -> BaudRate.BPS38400
        XPayBaudRate.BPS57600 -> BaudRate.BPS57600
        XPayBaudRate.BPS115200 -> BaudRate.BPS115200
    }
}

internal fun XPayDataBits.toNewLandDataBits(): DataBits {
    return when (this) {
        XPayDataBits.DATA_BIT_5 -> DataBits.DATA_BIT_5
        XPayDataBits.DATA_BIT_6 -> DataBits.DATA_BIT_6
        XPayDataBits.DATA_BIT_7 -> DataBits.DATA_BIT_7
        XPayDataBits.DATA_BIT_8 -> DataBits.DATA_BIT_8
    }
}

internal fun XPayParityBit.toNewLandParityBit(): ParityBit {
    return when (this) {
        XPayParityBit.NO_CHECK -> ParityBit.NO_CHECK
        XPayParityBit.ODD_CHECK -> ParityBit.ODD_CHECK
        XPayParityBit.EVEN_CHECK -> ParityBit.EVEN_CHECK
    }
}

internal fun XPayStopBits.toNewLandStopBits(): StopBits {
    return when (this) {
        XPayStopBits.STOP_BIT_ONE -> StopBits.STOP_BIT_ONE
        XPayStopBits.STOP_BIT_TWO -> StopBits.STOP_BIT_TWO
    }
}

internal fun XPaySerialPortSettings.toNewLandSerialPortSettings(): SerialPortSettings {
    return SerialPortSettings(
        this.baudRate.toNewLandBaudRate(),
        this.dataBits.toNewLandDataBits(),
        this.parityBit.toNewLandParityBit(),
        this.stopBits.toNewLandStopBits(),
        this.isBlocked,
        this.isFlowCtr
    )
}