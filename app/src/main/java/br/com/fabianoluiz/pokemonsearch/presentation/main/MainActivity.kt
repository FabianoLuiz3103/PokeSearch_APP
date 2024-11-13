package br.com.fabianoluiz.pokemonsearch.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.fabianoluiz.pokemonsearch.R
import br.com.fabianoluiz.pokemonsearch.databinding.ActivityMainBinding
import br.com.fabianoluiz.pokemonsearch.presentation.detail.PokemonDetailsActivity
import br.com.fabianoluiz.pokemonsearch.presentation.history.PokemonHistoryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPesquisar.setOnClickListener{
            val id = binding.etPokemonId.text.toString()
            val intent = Intent(this, PokemonDetailsActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        binding.btHistorico.setOnClickListener {
            val intent = Intent(this, PokemonHistoryActivity::class.java)
            startActivity(intent)
        }


    }
}