package br.com.fabianoluiz.pokemonsearch.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val frontDefault: String?,    // Alterado para camelCase
    val backDefault: String?,
    val frontShiny: String?,
    val backShiny: String?,
    val officialArtwork: String?
) {
    fun toPokemon(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = frontDefault,  // Adaptado para o modelo
            backDefault = backDefault,
            frontShiny = frontShiny,
            backShiny = backShiny,
            officialArtwork = officialArtwork
        )
    }
}
