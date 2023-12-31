package com.example.classedosalunos.telas.telaListaDeAlunos

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classedosalunos.data.ListaDeAlunos
import com.example.classedosalunos.model.Aluno


@Composable
fun TelaListaDeAlunos() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(ListaDeAlunos().carregarListaDeAluno()) {
                    Aluno -> CardAluno(aluno = Aluno)

            }
        }
    }
}


@Composable
fun CardAluno(
    aluno: Aluno
) {

    var expandir by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(20.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = aluno.foto),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(105.dp)
                        .clip(CircleShape)

                )
                Column() {
                    Text(
                        text = aluno.nome,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = aluno.curso,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.width(80.dp))
                Icon(
                    imageVector =
                    if (expandir)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expandir = !expandir }
                )
            }
            if (expandir == true) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Faltas: ${aluno.faltas}",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black

                )
                Text(
                    text = "Nota: ${aluno.nota}",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black,

                    )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardAluno() {
    CardAluno(
        aluno = Aluno(
            nome = "Harry Potter",
            curso = "Mágia Avançada"
        )
    )
}
