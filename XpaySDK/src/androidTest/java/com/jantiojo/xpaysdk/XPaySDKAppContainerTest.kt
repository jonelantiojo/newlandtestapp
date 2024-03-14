package com.jantiojo.xpaysdk

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.jantiojo.xpaysdk.module.XPayBeeper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class XPaySDKAppContainerTest {

    @Mock
    lateinit var xPayModuleProvider: XPayModuleProvider

    lateinit var xPaySDKAppContainer: XPaySDKAppContainer

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        val context: Context = ApplicationProvider.getApplicationContext()
        xPaySDKAppContainer = XPaySDKAppContainer(xPayModuleProvider)
        xPaySDKAppContainer.setupXPayProvider(context)
    }

    @After
    fun tearDown() {
        xPaySDKAppContainer.closeXPayProvider()
    }

    @Test
    fun xPaySDKAppContainer_getModule_returnBeeperModule() {
        whenever(xPayModuleProvider.getXPayModule(XPayModuleType.BEEPER)).thenReturn(XPayBeeper())
        val module = xPaySDKAppContainer.getXPayModule(XPayModuleType.BEEPER)
       assertEquals(XPayBeeper(), module)
    }
}