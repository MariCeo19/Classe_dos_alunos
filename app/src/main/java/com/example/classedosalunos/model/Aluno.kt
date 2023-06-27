package com.example.classedosalunos.model

import com.example.classedosalunos.R

class Aluno(
    val nome:String,
    val curso:String
) {
    var faltas:Int = 0
    var nota:Int = 0
    var foto:Int = R.drawable.harry_potter

}