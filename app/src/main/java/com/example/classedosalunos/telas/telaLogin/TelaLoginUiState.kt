package com.example.classedosalunos.telas.telaLogin

data class TelaLoginUiState(
    val login:String="",
    val senha:String="",
    val erroLogin:Boolean = false,
    val logado:Boolean = false
)
