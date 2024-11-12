package br.com.fabianoluiz.pokemonsearch.domain.repository

import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemon(id: Int): Pokemon
}