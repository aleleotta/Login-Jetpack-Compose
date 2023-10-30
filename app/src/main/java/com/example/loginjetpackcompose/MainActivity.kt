package com.example.loginjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
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

@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    var usernameTextField by rememberSaveable { mutableStateOf("") }
    var passwordTextField by rememberSaveable { mutableStateOf("") }
    Row {
        Column {
            Image(
                painter = painterResource(id = R.drawable.captura_de_pantalla_2023_10_02_131011),
                contentDescription = "IES Nervión",
                alignment = Alignment.Center,
                modifier = modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Username:",
                modifier = modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Password:",
                modifier = modifier.fillMaxSize()
            )
        }
        Column {
            Spacer(modifier = Modifier.height(53.dp))
            TextField(
                value = usernameTextField,
                onValueChange = {newUsernameTextField -> usernameTextField = newUsernameTextField},
                modifier = modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                value = passwordTextField,
                onValueChange = {newPasswordTextField -> passwordTextField = newPasswordTextField},
                modifier = modifier.fillMaxSize()
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