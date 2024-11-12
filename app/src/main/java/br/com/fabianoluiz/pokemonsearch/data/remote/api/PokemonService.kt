package br.com.fabianoluiz.pokemonsearch.data.remote.api
import br.com.fabianoluiz.pokemonsearch.data.remote.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
}