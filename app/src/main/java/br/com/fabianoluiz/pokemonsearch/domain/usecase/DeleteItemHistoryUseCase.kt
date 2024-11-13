package br.com.fabianoluiz.pokemonsearch.domain.usecase

import br.com.fabianoluiz.pokemonsearch.domain.repository.PokemonRepository

class DeleteItemHistoryUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(id: Int){
        return repository.deleteItemHistory(id)
    }
}