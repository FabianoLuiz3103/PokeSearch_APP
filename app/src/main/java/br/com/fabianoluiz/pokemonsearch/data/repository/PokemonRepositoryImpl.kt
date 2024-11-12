package br.com.fabianoluiz.pokemonsearch.data.repository

import br.com.fabianoluiz.pokemonsearch.data.local.dao.PokemonDao
import br.com.fabianoluiz.pokemonsearch.data.remote.api.PokemonService
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import br.com.fabianoluiz.pokemonsearch.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonService: PokemonService
): PokemonRepository
{
    override suspend fun getPokemon(id: Int): Pokemon {
        val cachedPokemon = pokemonDao.getPokemon(id)
        return if(cachedPokemon != null){
            cachedPokemon.toPokemon()
        }else {
            val response = pokemonService.getPokemon(id)
            pokemonDao.insertPokemon(response.toPokemonEntity())
            response.toPokemon()
        }
    }

}