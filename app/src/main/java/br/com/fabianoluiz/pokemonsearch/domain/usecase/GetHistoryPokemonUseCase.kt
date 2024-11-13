package br.com.fabianoluiz.pokemonsearch.domain.usecase

import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import br.com.fabianoluiz.pokemonsearch.domain.repository.PokemonRepository

class GetHistoryPokemonUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(): List<Pokemon> {
        return repository.getHistoryPokemon()
    }
}