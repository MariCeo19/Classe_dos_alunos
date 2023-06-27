package com.example.classedosalunos.data

import com.example.classedosalunos.model.Aluno

class ListaDeAlunos {
    fun carregarListaDeAluno():List<Aluno>{
        return listOf<Aluno>(
            Aluno("Harry Potter", "Mágia Avançada"),
            Aluno("Hermione Granger", "Mágia Avançada"),
            Aluno("Ron Weasley", "Mágia Avançada"),
            Aluno("Gina Weasley", "Mágia Intermediaria"),
            Aluno("Luna Lovegood", "Mágia Intermediaria"),
            Aluno("Dobby", "Mágia II"),
            Aluno("Neville Longbottom", "Mágia Avançada")

        )
    }
}