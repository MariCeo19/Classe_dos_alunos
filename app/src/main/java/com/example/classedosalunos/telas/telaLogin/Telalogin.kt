package com.example.classedosalunos.telas.telaLogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.classedosalunos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(
    controleDeNavegacao: NavHostController,
    telaLoginViewModel: TelaLoginViewModel = viewModel()
) {
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Login",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.Magenta

            )
           Image(
               painter = painterResource(id = R.drawable.login) ,
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .size(100.dp)
                   .clip(CircleShape)
           )

            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = telaLoginViewModel.login,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { telaLoginViewModel.updateLogin(it) },
                label = { Text(text = "Login")}
            )
            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = telaLoginViewModel.senha,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { telaLoginViewModel.updateSenha(it)},
                label = { Text(text = "Senha")}
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                          controleDeNavegacao.navigate("TelalistaDeAlunos")
                },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(7.dp)

                ) {
                Text(
                    text = "Entrar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Magenta
                )
            }
        }
    }
}