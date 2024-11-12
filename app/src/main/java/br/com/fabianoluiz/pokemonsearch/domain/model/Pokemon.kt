package br.com.fabianoluiz.pokemonsearch.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val frontDefault: String?,    // Alterado para camelCase
    val backDefault: String?,
    val frontShiny: String?,
    val backShiny: String?,
    val officialArtwork: String?

)
