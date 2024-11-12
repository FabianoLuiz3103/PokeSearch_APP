package br.com.fabianoluiz.pokemonsearch.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fabianoluiz.pokemonsearch.data.local.entity.PokemonEntity
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon_table WHERE id = :id LIMIT 1")
    suspend fun getPokemon(id: Int): PokemonEntity?
}