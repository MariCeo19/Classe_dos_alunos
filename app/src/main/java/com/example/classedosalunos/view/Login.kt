package com.example.classedosalunos.view

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Login(){
    Column() {
        Text(
            text = "login"
        )
        Spacer(modifier = Modifier.size(20.dp))

        TextField(
            value = login,
            onValueChange = {login=it}
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextField(
            value = senha,
            onValueChange = {senha=it}
        )
    }
}