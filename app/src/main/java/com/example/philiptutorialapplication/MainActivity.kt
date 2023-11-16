package com.example.philiptutorialapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.philiptutorialapplication.ui.theme.PhilipTutorialApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhilipTutorialApplicationTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("anya") { AnyaScreen() }
        composable("dollar") { DollarScreen() }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
    ) {
        Greeting("Joseph Marks", navController)
    }
}

@Composable
fun Greeting(name: String, navController: NavHostController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TitleSection()
        CatImages()
        GreetText(name)
        CatButtons(navController)
    }
}

@Composable
fun TitleSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.paw_print2),
            contentDescription = "Left Paw Print",
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Cute Cat App!",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(R.drawable.paw_print2),
            contentDescription = "Right Paw Print",
            modifier = Modifier.size(25.dp)
        )
    }
}

@Composable
fun CatImages() {
    DisplayAnyaImage()
    DisplayDollarImage()
}

@Composable
fun GreetText(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.White,
        fontSize = 30.sp,
        modifier = Modifier.padding(5.dp)
    )
    Text(
        text = "Look at your babies!",
        color = Color.White,
        fontSize = 30.sp,
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun CatButtons(navController: NavHostController) {
    Row(
        modifier = Modifier
            .padding(35.dp)
            .fillMaxWidth(), // Fill the maximum width available
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { navController.navigate("anya") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF0EAE2) // Off-white color for the button background
            ),
            modifier = Modifier
                .height(50.dp) // Adjust the height as needed
                .weight(1f) // Use weight to make the buttons expand equally
        ) {
            Text("Anya", color = Color.Black) // Text color set to black
        }

        Spacer(modifier = Modifier.width(16.dp)) // Space between the buttons

        Button(
            onClick = { navController.navigate("dollar") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF0EAE2) // Off-white color for the button background
            ),
            modifier = Modifier
                .height(50.dp) // Adjust the height as needed
                .weight(1f) // Use weight to make the buttons expand equally
        ) {
            Text("Dollar", color = Color.Black) // Text color set to black
        }
    }
}

@Composable
fun DisplayAnyaImage() {
    Image(
        painter = painterResource(R.drawable.anya),
        contentDescription = "My Cat",
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun DisplayDollarImage() {
    Image(
        painter = painterResource(R.drawable.dollar),
        contentDescription = "My Cat",
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun AnyaScreen() {
    // ... UI for Anya's screen
}

@Composable
fun DollarScreen() {
    // ... UI for Dollar's screen
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhilipTutorialApplicationTheme {
        MainScreen(rememberNavController())
    }
}
