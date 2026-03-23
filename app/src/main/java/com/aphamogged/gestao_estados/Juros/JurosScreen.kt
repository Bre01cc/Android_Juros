package com.aphamogged.gestao_estados.Juros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aphamogged.gestao_estados.Calculos.calcularJuros
import com.aphamogged.gestao_estados.Calculos.calcularMontante
import com.aphamogged.gestao_estados.componentes.CaixaDeEntrada
import com.aphamogged.gestao_estados.componentes.CardResultado

@Composable
fun JurosScreen(
    modifier: Modifier = Modifier,
    jurosScreenViewModel : JurosScreenViewModel
    ) {
    val cordoApp = Color(136, 38, 199, 255)

    val capital by jurosScreenViewModel.capital.observeAsState("")
//    var capital by remember {
//        mutableStateOf("")
//    }
    val taxa by jurosScreenViewModel.taxa.observeAsState("")
//    var taxa by remember {
//        mutableStateOf("")
//    }

    val tempo by jurosScreenViewModel.tempo.observeAsState("")
//    var tempo by remember {
//        mutableStateOf("")
//    }
    val juros by jurosScreenViewModel.juros.observeAsState(0.0)
//    var juros by remember {
//        mutableDoubleStateOf(0.0)
//    }
//
    val  montante by jurosScreenViewModel.montante.observeAsState(0.0)
//    var montante by remember {
//        mutableDoubleStateOf(0.0)
//    }



    Column (
        modifier = modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(color = cordoApp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Calculadora Juros Simples",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-30).dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF9F6F6)
                    ),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Dados do investimento",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        CaixaDeEntrada(
                            label =  "valor investimento",
                            placeholder = "Quanto deseja investir?",
                            modifier = Modifier,
                            value = capital,
                            keyboardType = KeyboardType.Decimal,
                            corApp = cordoApp,
                            atualizarValor = {
                                jurosScreenViewModel.onCapitalChange(it)
                            }
                        )
                        CaixaDeEntrada(
                            label =  "Taxa de juros mensal",
                            placeholder = "Qual a taxa de juros mensal?",
                            modifier = Modifier,
                            value = taxa,
                            keyboardType = KeyboardType.Decimal,
                            corApp = cordoApp,
                            atualizarValor = {
                               jurosScreenViewModel.onTaxaChange(it)
                            }
                        )

                        CaixaDeEntrada(
                            label =  "Período em meses",
                            placeholder = "Qual o tempo em meses?",
                            modifier = Modifier,
                            value = tempo,
                            keyboardType = KeyboardType.Decimal,
                            corApp = cordoApp,
                            atualizarValor = {
                                jurosScreenViewModel.onTimeChange(it)
                            }
                        )

                        Button(
                            onClick = {
                               jurosScreenViewModel.calcularJurosInvestimento()

                               jurosScreenViewModel.calcularMontanteInvestimento()
                            },
                            modifier = Modifier.fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = "CALCULAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
                CardResultado(juros,montante)
                // Resultado
            }
        }
    }
}