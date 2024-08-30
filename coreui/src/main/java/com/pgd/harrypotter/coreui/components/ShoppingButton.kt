package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingButton() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .height(100.dp)
        ) {
            // Content Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                // Reviews and Action Button
                Card(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp)),
                ) {
                    Button(
                        onClick = { /* Start cooking action */ },
                        colors = ButtonDefaults
                            .buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text("Add to shopping list", color = Color.Black)
                    }
                }
            }
        }
    }
}
