package br.com.fabianoluiz.pokemonsearch.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import br.com.fabianoluiz.pokemonsearch.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val getPokemonUseCase: GetPokemonUseCase): ViewModel() {

    private val _pokemonData = MutableLiveData<Pokemon>()
    val pokemonData: LiveData<Pokemon> get() = _pokemonData

    fun fetchPokemon(id: Int){
        viewModelScope.launch {
            val result = getPokemonUseCase(id)
            _pokemonData.value = result
        }
    }
}