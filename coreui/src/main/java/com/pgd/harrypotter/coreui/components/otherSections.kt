package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ToolsSection() {
    // Example Tools Section
    Column(
        modifier = Modifier
            .heightIn(min = 200.dp, max = 500.dp)
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tools will be listed here")
    }
}

@Composable
fun StepsSection() {
    // Example Steps Section
    Column(
        modifier = Modifier
            .heightIn(min = 200.dp, max = 500.dp)
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Steps will be listed here")
    }
}
