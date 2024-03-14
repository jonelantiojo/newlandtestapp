package com.jantiojo.newlandnpttestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jantiojo.newlandnpttestapp.ui.theme.NewlandNPTTestAppTheme
import com.jantiojo.xpaysdk.XPayModuleManager
import com.jantiojo.xpaysdk.XPaySDKAppContainer

class MainActivity : ComponentActivity() {

    private val xPaySDKAppContainer by lazy { XPaySDKAppContainer(XPayModuleManager()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            xPaySDKAppContainer.setupXPayProvider(this)
            NewlandNPTTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        xPaySDKAppContainer.closeXPayProvider()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewlandNPTTestAppTheme {
        Greeting("Android")
    }
}