package br.com.fabianoluiz.pokemonsearch.data.remote.model

import br.com.fabianoluiz.pokemonsearch.data.local.entity.PokemonEntity
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites,
    val stats: List<Stat>
) {
    fun toPokemon(): Pokemon {

        var hp: Int? = null
        var attack: Int? = null
        var defense: Int? = null
        var specialAttack: Int? = null
        var specialDefense: Int? = null
        var speed: Int? = null


        stats.forEach { stat ->
            when (stat.stat.name) {
                "hp" -> hp = stat.base_stat
                "attack" -> attack = stat.base_stat
                "defense" -> defense = stat.base_stat
                "special-attack" -> specialAttack = stat.base_stat
                "special-defense" -> specialDefense = stat.base_stat
                "speed" -> speed = stat.base_stat
            }
        }

        return Pokemon(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = sprites.front_default,
            frontShiny = sprites.front_shiny,
            backDefault = sprites.back_default,
            backShiny = sprites.back_shiny,
            officialArtwork = sprites.other?.officialArtwork?.front_default,
            hp = hp,
            attack = attack,
            defense = defense,
            specialAttack = specialAttack,
            specialDefense = specialDefense,
            speed = speed
        )
    }

    fun toPokemonEntity(): PokemonEntity {
        // Inicializa variáveis para armazenar os valores base_stat relevantes
        var hp: Int? = null
        var attack: Int? = null
        var defense: Int? = null
        var specialAttack: Int? = null
        var specialDefense: Int? = null
        var speed: Int? = null


        stats.forEach { stat ->
            when (stat.stat.name) {
                "hp" -> hp = stat.base_stat
                "attack" -> attack = stat.base_stat
                "defense" -> defense = stat.base_stat
                "special-attack" -> specialAttack = stat.base_stat
                "special-defense" -> specialDefense = stat.base_stat
                "speed" -> speed = stat.base_stat
            }
        }
        return PokemonEntity(
            id = id,
            name = name,
            weight = weight,
            height = height,
            frontDefault = sprites.front_default,
            frontShiny = sprites.front_shiny,
            backDefault = sprites.back_default,
            backShiny = sprites.back_shiny,
            officialArtwork = sprites.other?.officialArtwork?.front_default,
            hp = hp,
            attack = attack,
            defense = defense,
            specialAttack = specialAttack,
            specialDefense = specialDefense,
            speed = speed
        )
    }

}


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

data class Stat(
    @SerializedName("base_stat") val base_stat: Int,
    val effort: Int,
    val stat: StatDetail
)

// Classe para representar detalhes de cada stat
data class StatDetail(
    val name: String,
    val url: String
)
