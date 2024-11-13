package br.com.fabianoluiz.pokemonsearch.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import br.com.fabianoluiz.pokemonsearch.domain.usecase.DeleteItemHistoryUseCase
import br.com.fabianoluiz.pokemonsearch.domain.usecase.GetHistoryPokemonUseCase
import kotlinx.coroutines.launch

class PokemonHistoryViewModel(
    private val getHistoryPokemonUseCase: GetHistoryPokemonUseCase,
    private val deleteItemHistoryUseCase: DeleteItemHistoryUseCase
): ViewModel() {

    private val _pokemonAllHistory = MutableLiveData<List<Pokemon>>()
    val pokemonAllHistory: LiveData<List<Pokemon>> get() = _pokemonAllHistory

    fun getHistory(){
        viewModelScope.launch {
            val result = getHistoryPokemonUseCase()
            _pokemonAllHistory.value = result
        }
    }

    fun delete(id: Int){
        viewModelScope.launch {
            deleteItemHistoryUseCase(id)
            getHistory()
        }
    }
}