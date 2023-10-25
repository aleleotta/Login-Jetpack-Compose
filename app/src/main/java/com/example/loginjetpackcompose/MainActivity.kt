package com.example.loginjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginjetpackcompose.ui.theme.LoginJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginJetpackComposeTheme {
                //A surface container using the 'background' color from the theme.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login("Android")
                }
            }
        }
    }
}

@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    Row {
        Column {
            Image(
                painter = painterResource(id = R.drawable.captura_de_pantalla_2023_10_02_131011),
                contentDescription = "IES Nervión",
                alignment = Alignment.Center,
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Username:",
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Password:",
                modifier = modifier
            )
        }
        Column {
            Spacer(modifier = Modifier.height(53.dp))
            TextField)()
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Password:",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginJetpackComposeTheme {
        Login("Android")
    }
}