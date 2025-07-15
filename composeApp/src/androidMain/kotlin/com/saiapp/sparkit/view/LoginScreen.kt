package com.saiapp.sparkit.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.exceptions.GetCredentialException
import com.saiapp.sparkit.R
import com.saiapp.sparkit.ktorClient.KtorClient
import com.saiapp.sparkit.ktorClient.LoginViewModel
import com.saiapp.sparkit.model.GoogleAuth
import kotlinx.coroutines.launch

private const val TAG: String = "LoginScreen"

@Composable
fun LoginScreen() {
    val loginViewModel = LoginViewModel(KtorClient())
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val serverClientId = stringResource(R.string.server_client_id)
    val showNextScreen = loginViewModel.navigateToNextPage.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.login_background_img),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 100.dp),
                text = "SparkIT",
                style = TextStyle(
                    fontSize = 60.sp,
                    fontFamily = FontFamily(Font(R.font.kurale_regular)),
                    fontWeight = FontWeight(400)
                ),
                color = Color.White,
            )

            Column(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 1.0f)
                            ),
                            startY = 0.0f,
                            endY = 150.0f,
                        )
                    )
                    .align(Alignment.BottomCenter)
            ) {

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp)
                        .padding(bottom = 100.dp),
                    onClick = {
                        coroutineScope.launch {
                            GoogleAuth.launchSignIn(context, serverClientId,loginViewModel,coroutineScope)
                        }
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                )
                {
                    Row(Modifier.padding(10.dp)) {
                        Image(painter = painterResource(R.drawable.google_icon), "Google Icon")
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                        Text("Continue with Google", color = Color.Black)
                    }
                }
            }

            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp),
                text = "By signing up, you agree to our Terms. Learn how we use\n" +
                        " your data in our Privacy Policy.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.kurale_regular)),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                ),
                color = Color.White,
            )
        }
    }
}

fun handleFailure(e: GetCredentialException) {
    Log.e(TAG, "GetCredentialException : $e")
}

