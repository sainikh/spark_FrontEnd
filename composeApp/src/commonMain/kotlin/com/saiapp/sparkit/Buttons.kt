package com.saiapp.sparkit
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview



@Composable
fun LoginButton(onClick : () -> Unit) {

    Button(onClick = onClick){
//        Image(
//            painter = painterResource(GoogleImageLogo()),
//            contentDescription = "Image in Button",
//            modifier = Modifier.size(24.dp)
//        )
        Text(text = "Google Login")
    }

}

@Preview
@Composable
fun PreviewImageButton() {
    LoginButton(onClick = { })
}