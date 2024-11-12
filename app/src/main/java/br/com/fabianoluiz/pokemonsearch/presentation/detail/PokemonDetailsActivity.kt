package br.com.fabianoluiz.pokemonsearch.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fabianoluiz.pokemonsearch.R
import br.com.fabianoluiz.pokemonsearch.databinding.ActivityPokemonDetailsBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailsBinding

    private val viewModel: PokemonDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtendo o ID do Pokémon, com verificação segura de valor
        val id = intent.getStringExtra("id")?.toIntOrNull() ?: 0
        viewModel.fetchPokemon(id)

        // Observando as mudanças nos dados do Pokémon
        viewModel.pokemonData.observe(this) { pokemon ->
            // Atualizando os dados de texto
            binding.tvPokemonId.text = pokemon.id.toString()
            binding.tvName.text = pokemon.name

            // Carregando as imagens usando Glide com verificações e placeholders
            pokemon.officialArtwork?.let {
                Glide.with(this)
                    .load(it)
                    //.placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)    // Imagem de erro
                    .into(binding.ivOfficialArtwork)
            }

            pokemon.frontDefault?.let {
                Glide.with(this)
                    .load(it)
                    //.placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)    // Imagem de erro
                    .into(binding.ivFrontDefault)
            }

            pokemon.backDefault?.let {
                Glide.with(this)
                    .load(it)
                    //.placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)    // Imagem de erro
                    .into(binding.ivBackDefault)
            }

            pokemon.frontShiny?.let {
                Glide.with(this)
                    .load(it)
                    //.placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)    // Imagem de erro
                    .into(binding.ivFrontShiny)
            }

            pokemon.backShiny?.let {
                Glide.with(this)
                    .load(it)
                    //.placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)    // Imagem de erro
                    .into(binding.ivBackShiny)
            }
        }
    }
}
