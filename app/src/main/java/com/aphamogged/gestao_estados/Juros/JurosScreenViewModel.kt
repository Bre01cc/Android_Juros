package com.aphamogged.gestao_estados.Juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aphamogged.gestao_estados.Calculos.calcularJuros
import com.aphamogged.gestao_estados.Calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {
    private val _capitalState  = MutableLiveData<String>()

    var capital: LiveData<String> = _capitalState

    private val _taxaState = MutableLiveData<String>()

    var taxa: LiveData<String> = _taxaState

    private val _tempoState = MutableLiveData<String>()

    var tempo: LiveData<String> = _tempoState


    private val _jurosStage = MutableLiveData<Double>()

    var juros : LiveData<Double> = _jurosStage


    private val _montante = MutableLiveData<Double>()

    var montante : LiveData<Double> = _montante
    fun onCapitalChange (novoCapital: String){
        _capitalState.value = novoCapital
    }

    fun onTaxaChange (novaTaxa: String){
        _taxaState.value = novaTaxa
    }
    fun onTimeChange (novoTempo: String){
        _tempoState.value = novoTempo
    }

    fun calcularJurosInvestimento(){
        _jurosStage.value = calcularJuros(
            capital = _capitalState.value!!.toDouble(),
            taxa = _taxaState.value!!.toDouble(),
            tempo = _tempoState.value!!.toDouble()
        )
    }
    fun calcularMontanteInvestimento(){
        _montante.value = calcularMontante(
            capital = _capitalState.value!!.toDouble(),
            juros = _jurosStage.value!!
        )

    }
}