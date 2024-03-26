package com.example.loginjetpackcompose

import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.view.RoundedCorner
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginjetpackcompose.ui.theme.LoginJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavControllerHandler().Navigation(navController)
                    Login(navController)
                }
            }
        }
    }
}

@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {
    val modifier = Modifier
    var usernameTextField by rememberSaveable { mutableStateOf("") }
    var passwordTextField by rememberSaveable { mutableStateOf("") }
    Column (modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.captura_de_pantalla_2023_10_02_131011_removebg_preview),
            contentDescription = "IES Nervión",
            alignment = Alignment.Center,
            modifier = modifier
                .padding(5.dp)
                .size(300.dp, 100.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column (
                modifier.padding(10.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Username:",
                    modifier = modifier,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Password:",
                    modifier = modifier,
                    fontSize = 25.sp
                )
            }
            Column (
                modifier.padding(10.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = usernameTextField,
                    onValueChange = {newUsernameTextField -> usernameTextField = newUsernameTextField},
                    label = {Text(usernameTextField)},
                    modifier = modifier
                        .width(200.dp)
                        .height(25.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = passwordTextField,
                    onValueChange = {newPasswordTextField -> passwordTextField = newPasswordTextField},
                    label = {Text(passwordTextField)},
                    modifier = modifier
                        .width(200.dp)
                        .height(25.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginJetpackComposeTheme {
        val navController = rememberNavController()
        Login(navController)
    }
}