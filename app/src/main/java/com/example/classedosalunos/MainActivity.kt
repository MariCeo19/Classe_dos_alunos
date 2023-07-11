package com.example.classedosalunos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.classedosalunos.telas.telaListaDeAlunos.TelaListaDeAlunos
import com.example.classedosalunos.telas.telaLogin.TelaLogin
import com.example.classedosalunos.ui.theme.ClasseDosAlunosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClasseDosAlunosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  AppDiariodeClasse()
                }
            }
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun AppDiariodeClasse(){

    val controleDeNavegacao = rememberNavController()

      NavHost(
          navController = controleDeNavegacao ,
          startDestination = " telaDeLogin"
      ){

          composable(
              route = "telaDeLogin"
          ){
              TelaLogin(controleDeNavegacao)
          }
          composable(
              route = "telaListaDeAlunos"
          ){
              TelaListaDeAlunos()
          }
      }



}










     