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
    val frontDefault: String?,
    val backDefault: String?,
    val frontShiny: String?,
    val backShiny: String?,
    val officialArtwork: String?,
    val hp: Int?,
    val attack: Int?,
    val defense: Int?,
    val specialAttack: Int?,
    val specialDefense: Int?,
    val speed: Int?
) {
    fun toPokemon(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = frontDefault,
            backDefault = backDefault,
            frontShiny = frontShiny,
            backShiny = backShiny,
            officialArtwork = officialArtwork,
            hp = hp,
            attack = attack,
            defense = defense,
            specialAttack = specialAttack,
            specialDefense = specialDefense,
            speed = speed
        )
    }
}
