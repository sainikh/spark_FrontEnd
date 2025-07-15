package com.saiapp.sparkit

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PreviewHomeScreen() {
    MaterialTheme {
        Column {
            Button(onClick = {}) { Text("Hello Sai") }
        }
    }
}