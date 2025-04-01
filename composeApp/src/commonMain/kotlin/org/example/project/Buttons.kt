package org.example.project
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
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