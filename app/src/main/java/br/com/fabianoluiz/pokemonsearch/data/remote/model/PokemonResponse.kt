package br.com.fabianoluiz.pokemonsearch.data.remote.model

import br.com.fabianoluiz.pokemonsearch.data.local.entity.PokemonEntity
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
) {
    fun toPokemon(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = sprites.front_default,
            frontShiny = sprites.front_shiny,
            backDefault = sprites.back_default,
            backShiny = sprites.back_shiny,
            officialArtwork = sprites.other?.officialArtwork?.front_default
        )
    }

    fun toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = sprites.front_default,
            frontShiny = sprites.front_shiny,
            backDefault = sprites.back_default,
            backShiny = sprites.back_shiny,
            officialArtwork = sprites.other?.officialArtwork?.front_default
        )
    }
}

// Classe principal para representar "sprites"
data class Sprites(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?,
    val other: OtherSprites?
)

// Classe para representar o campo "other"
data class OtherSprites(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork?
)


// Classe para representar "official-artwork"
data class OfficialArtwork(
    val front_default: String?
)

