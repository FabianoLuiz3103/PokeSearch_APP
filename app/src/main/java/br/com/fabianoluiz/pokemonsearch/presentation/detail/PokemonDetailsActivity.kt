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


        val id = intent.getStringExtra("id")?.toIntOrNull() ?: 0
        viewModel.fetchPokemon(id)

        viewModel.pokemonData.observe(this) { pokemon ->

            binding.tvPokemonId.text = buildString {
                append('#')
                append(pokemon.id.toString())
            }
            binding.tvName.text = pokemon.name

            binding.pbHp.progress = pokemon.hp!!
            binding.pbAttack.progress = pokemon.attack!!
            binding.pbDefesa.progress = pokemon.defense!!
            binding.pbSpecialAttack.progress = pokemon.specialAttack!!
            binding.pbSpecialDefesa.progress = pokemon.specialDefense!!
            binding.pbSpeed.progress = pokemon.speed!!
            pokemon.officialArtwork?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)
                    .into(binding.ivOfficialArtwork)
            }

            pokemon.frontDefault?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)
                    .into(binding.ivFrontDefault)
            }

            pokemon.backDefault?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)
                    .into(binding.ivBackDefault)
            }

            pokemon.frontShiny?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)
                    .into(binding.ivFrontShiny)
            }

            pokemon.backShiny?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.poke_logo)
                    .into(binding.ivBackShiny)
            }
        }
    }
}
