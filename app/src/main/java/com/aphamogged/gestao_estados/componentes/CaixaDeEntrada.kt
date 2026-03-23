package com.aphamogged.gestao_estados.componentes

import android.R
import android.R.attr.text
import android.inputmethodservice.Keyboard
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    value: String,
    corApp: Color,
    modifier: Modifier,
    //Atualizar constantemente o campo de digitação sem retornar valor
    atualizarValor : (String)-> Unit
) {
    OutlinedTextField(
        label ={
            Text(text  = label)
        },
        placeholder={
            Text(text = placeholder)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = corApp,
            unfocusedBorderColor = corApp
        ),
        value = value,
        onValueChange = {
            atualizarValor(it)
        }
    )
}