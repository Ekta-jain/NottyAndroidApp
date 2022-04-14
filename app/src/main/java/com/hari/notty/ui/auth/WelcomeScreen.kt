package com.hari.notty.ui.auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.hari.notty.R
import com.hari.notty.ui.destinations.SignInScreenDestination
import com.hari.notty.ui.theme.Facebook
import com.hari.notty.ui.theme.Google
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun WelcomeScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.padding(horizontal = 15.dp),
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "Welcome Image"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Welcome",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "A KSP library that processes annotations and generates code that uses Official Jetpack.",
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .weight(1.0f)
                    .padding(start = 40.dp),
                onClick = { navigator.navigate(SignInScreenDestination) },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(vertical = 5.dp),
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedButton(
                modifier = Modifier
                    .weight(1.0f)
                    .padding(end = 40.dp),
                onClick = { },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Blue
                ),
                border = BorderStroke(width = 1.dp, Color.Blue)
            ) {
                Text(
                    text = "Signup",
                    modifier = Modifier.padding(vertical = 5.dp),
                    style = MaterialTheme.typography.button
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Or via social media",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .then(Modifier.size(50.dp))
                    .background(Facebook, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook button",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            IconButton(
                onClick = { },
                modifier = Modifier
                    .then(Modifier.size(50.dp))
                    .background(Google, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google button",
                    tint = Color.White
                )
            }

        }


    }
}


@Preview
@Composable
fun WelcomeScreenPreview() {
    // WelcomeScreen()
}