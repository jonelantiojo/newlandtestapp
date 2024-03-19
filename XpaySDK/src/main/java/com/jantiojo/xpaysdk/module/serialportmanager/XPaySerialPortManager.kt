package com.jantiojo.xpaysdk.module.serialportmanager

import com.jantiojo.xpaysdk.module.XPayModule
import com.jantiojo.xpaysdk.utils.toNewLandSerialPortSettings
import com.jantiojo.xpaysdk.utils.toNewLandSerialPortType
import com.newland.nsdk.core.api.common.ModuleType
import com.newland.nsdk.core.api.common.exception.NSDKException
import com.newland.nsdk.core.api.common.serialport.BaudRate
import com.newland.nsdk.core.api.common.serialport.DataBits
import com.newland.nsdk.core.api.common.serialport.ParityBit
import com.newland.nsdk.core.api.common.serialport.SerialPortSettings
import com.newland.nsdk.core.api.common.serialport.StopBits
import com.newland.nsdk.core.api.internal.serialportmanager.SerialPort
import com.newland.nsdk.core.api.internal.serialportmanager.SerialPortManager

class XPaySerialPortManager : XPayModule() {

    private val serialPortManager by lazy { xPayModuleManager.getModule(ModuleType.SERIAL_PORT_MANAGER) as SerialPortManager }

    lateinit var serialPort: SerialPort


    fun open(type: XPaySerialPortType) {
        try {
            serialPort.close()
            serialPort = serialPortManager.createInstance(
                type.toNewLandSerialPortType(),
                SerialPortSettings(
                    BaudRate.BPS115200,
                    DataBits.DATA_BIT_8,
                    ParityBit.NO_CHECK,
                    StopBits.STOP_BIT_ONE,
                    false
                )
            ) as SerialPort
            serialPort.open()
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
        }
    }

    fun openWithNodeName(nodeName: String) {
        try {
            serialPort.close()
            serialPort = serialPortManager.createInstance(
                nodeName,
                SerialPortSettings(
                    BaudRate.BPS115200,
                    DataBits.DATA_BIT_8,
                    ParityBit.NO_CHECK,
                    StopBits.STOP_BIT_ONE,
                    false
                )
            ) as SerialPort
            serialPort.open()
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
        }
    }


    fun write(byteArray: ByteArray, timeOut: Int): Int {
        return try {
            serialPort.write(byteArray, timeOut)
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
            0
        }
    }

    fun read(maxLength: Int, timeOut: Int): ByteArray {
        return try {
            serialPort.read(maxLength, timeOut)
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
            byteArrayOf()
        }
    }

    fun flush() {
        try {
            serialPort.flush()
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
        }
    }

    fun close() {
        try {
            serialPort.close()
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
        }
    }

    fun setConfig(xPaySerialPortSettings: XPaySerialPortSettings) {
        try {
            serialPort.setConfig(xPaySerialPortSettings.toNewLandSerialPortSettings())
        } catch (e: NSDKException) {
            e.printStackTrace()
            // Exception Here
        }
    }
}