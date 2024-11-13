package br.com.fabianoluiz.pokemonsearch.presentation.history

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fabianoluiz.pokemonsearch.R
import br.com.fabianoluiz.pokemonsearch.databinding.ActivityPokemonHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
class PokemonHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonHistoryBinding
    private val viewModel: PokemonHistoryViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonHistoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.getHistory()

        viewModel.pokemonAllHistory.observe(this){
            val adapter = PokemonHistoryAdapter(onDeleteClick = {
                viewModel.delete(it.id)
            })
            binding.rvHistory.adapter = adapter
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            adapter.setPokemons(it)
        }
    }
}