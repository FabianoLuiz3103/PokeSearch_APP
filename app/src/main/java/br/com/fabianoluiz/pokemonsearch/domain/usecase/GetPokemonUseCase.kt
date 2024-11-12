package br.com.fabianoluiz.pokemonsearch.domain.usecase

import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import br.com.fabianoluiz.pokemonsearch.domain.repository.PokemonRepository

class GetPokemonUseCase(private val repository: PokemonRepository) {

    suspend operator fun invoke(id: Int): Pokemon {
        return repository.getPokemon(id)
    }
}