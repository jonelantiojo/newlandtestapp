package com.jantiojo.xpaysdk

interface XPayModuleProvider {

    /**
     * call to initialize the underlying/3rd party payment Provider
     */
    fun setup()

    /**
     * call to close the connection from underlying/3rd party payment Provider
     */
    fun close()

    /**
     *  call to make sounds or beep
     *
     *  @param frequency - Beeping frequency, unit：Hz, value range: (0-4000]
     *  @param duration - The period of time to beep. Unit ms and value must >0
     */
    fun playSound(frequency: Int, duration: Int)

    /**
     *  call to male LED lights blink
     *
     *  @param ledColor - LED lights to control
     *  @param blinkCount - How many times to blink the lights, shall be >0
     *  @param timeInterval - time interval when to blink the LED lights, must be >0
     *
     *  @see XpayLEDColor
     */
    fun blinkLED(ledColor: List<XpayLEDColor>, blinkCount: Int, timeInterval: Int)

    /**
     *  call to set the state of specified LED lights
     *
     *  @param ledColor - LED lights to control.
     *  @param ledState - The state of LED lights.
     *
     * @see XpayLEDColor
     * @see XpayLEDState
     */
    fun controlLEDState(ledColor: XpayLEDColor, ledState: XpayLEDState)


}