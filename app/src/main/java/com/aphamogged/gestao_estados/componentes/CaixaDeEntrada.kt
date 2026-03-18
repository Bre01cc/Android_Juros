package com.aphamogged.gestao_estados.componentes

import android.R.attr.text
import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    value: String,
    modifier: Modifier,
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
        value = value,
        onValueChange = {
            atualizarValor(it)
        }
    )
}