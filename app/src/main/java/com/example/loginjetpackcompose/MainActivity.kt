package com.example.loginjetpackcompose

import android.os.Bundle
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    navController.navigate("Login")
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
            onClick = {
                if(usernameTextField == "user" && passwordTextField == "login2024") {
                    navController.navigate("AccessGranted")
                } else {
                    navController.navigate("AccessDenied")
                }
                      },
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

@Composable
fun AccessGranted(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier,
        ) {
            Button(
                onClick = {
                    navController.navigate("Login")
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Go back", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(500.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Access granted!",
            color = Color.Black,
            modifier = Modifier,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        ItemList(
            listOf(
                Contact("user1", "0363402302", "Male"),
                Contact("user2", "0363402302", "Female"),
                Contact("user3", "0363402302", "Male"),
                Contact("user4", "3480792302", "Female"),
                Contact("user5", "0363402302", "Male"),
                Contact("user6", "0363402302", "Female"),
                Contact("user7", "0363402302", "Male"),
                Contact("user8", "0363402302", "Male"),
                Contact("user9", "0363402302", "Female"),
                Contact("user10", "0363402302", "Female"),
                Contact("user10", "0363402302", "Non-Binary")
            )
        )
    }
}

@Composable
fun ItemList(contactItem: List<Contact>) {
    LazyColumn {
        items(contactItem) {
            contactItem -> ContactView(contact = contactItem)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ContactView(contact: Contact) {
    Card(Modifier.fillMaxWidth()) {
        Row {
            Column {
                Image(
                    painter = {
                        if (contact.gender == "Male") {
                            painterResource(id = R.drawable.male)
                        } else {
                            painterResource(id = R.drawable.female)
                        }
                    }
                    contentDescription = "Contact photo",
                    Modifier.height(100.dp)
                )
            }
            Column {
                Text(
                    text = contact.name,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = contact.phoneNumber,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


@Composable
fun AccessDenied(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier,
        ) {
            Button(
                onClick = {
                    navController.navigate("Login")
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Go back", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(500.dp))
        }
        Spacer(modifier = Modifier.height(300.dp))
        Text(
            text = "Access denied!",
            color = Color.Black,
            modifier = Modifier,
            fontSize = 40.sp
        )
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

@Preview(showBackground = true)
@Composable
fun AccessGrantedPreview() {
    LoginJetpackComposeTheme {
        val navController = rememberNavController()
        AccessGranted(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun AccessDeniedPreview() {
    LoginJetpackComposeTheme {
        val navController = rememberNavController()
        AccessDenied(navController)
    }
}