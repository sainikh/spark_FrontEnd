package com.saiapp.sparkit

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            App()
            LoginScreen()
        }
    }
}


@Composable
fun LoginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Box(modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.TopCenter){
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
                    .padding(top = 20.dp),
                text = "SparkIT",
                style = TextStyle(
                    fontSize = 60.sp,
//                fontFamily = FontFamily(Font(R.font.kurale_regular)),
                    fontWeight = FontWeight(400)
                ),
                color = Color.White,
            )

            Column(modifier = Modifier.align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(250.dp)
                .blur(200.dp, BlurredEdgeTreatment.Rectangle)) {
            }


            Column(modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent,
                            Color.Black.copy(alpha = 1.0f)),
                        startY = 0.0f,
                        endY = 150.0f,
                    ))
                .align(Alignment.BottomCenter)) {

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp).
                        padding(bottom = 100.dp ),
                    onClick = {},
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                )
                {
                    Row (Modifier.padding(10.dp)) {
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
//                fontFamily = FontFamily(Font(R.font.kurale_regular)),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                ),
                color = Color.White,
            )
        }
    }

}

@Preview
@Composable
fun AppAndroidPreview() {
    Surface {
        LoginScreen()
    }
}