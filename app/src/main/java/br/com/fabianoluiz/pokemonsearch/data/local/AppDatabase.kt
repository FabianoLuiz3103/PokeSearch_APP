package br.com.fabianoluiz.pokemonsearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fabianoluiz.pokemonsearch.data.local.dao.PokemonDao
import br.com.fabianoluiz.pokemonsearch.data.local.entity.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}