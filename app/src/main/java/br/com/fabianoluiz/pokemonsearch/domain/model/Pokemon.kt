package br.com.fabianoluiz.pokemonsearch.domain.model

data class Pokemon(
    val id: Int,
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

)
