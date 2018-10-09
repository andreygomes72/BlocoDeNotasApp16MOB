package com.andreygomes.blocodenotasapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.andreygomes.blocodenotasapp.model.Nota
import com.andreygomes.blocodenotasapp.model.ResponseStatus
import com.andreygomes.blocodenotasapp.repository.NotaRepository

class FormularioViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    fun salvar(titulo: String, descricao: String) {
        val nota = Nota(null, titulo, descricao)
        notaRepository.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true,
                            "Dados gravado com sucesso!")
                }, onError = {
                responseStatus.value = ResponseStatus(false,
                        it?.message!!)
        })


    }
}