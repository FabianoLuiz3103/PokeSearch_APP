package br.com.fabianoluiz.pokemonsearch.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fabianoluiz.pokemonsearch.R
import br.com.fabianoluiz.pokemonsearch.databinding.ActivityPokemonHistoryBinding
import br.com.fabianoluiz.pokemonsearch.databinding.ActivityPokemonHistoryItemBinding
import br.com.fabianoluiz.pokemonsearch.domain.model.Pokemon
import com.bumptech.glide.Glide

class PokemonHistoryAdapter(
    private val onDeleteClick: (Pokemon) -> Unit
): RecyclerView.Adapter<PokemonHistoryAdapter.PokemonViewHolder>() {

    private var pokemons: List<Pokemon> = emptyList()

    class PokemonViewHolder(val binding: ActivityPokemonHistoryItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ActivityPokemonHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentPokemon = pokemons[position]
        holder.binding.tvName.text = currentPokemon.name
        currentPokemon.officialArtwork?.let {
            Glide.with(holder.itemView.context)
                .load(it)
                .placeholder(R.drawable.loading)
                .error(R.drawable.poke_logo)
                .into(holder.binding.ivPokemon)
        }
        holder.binding.buttonDelete.setOnClickListener{onDeleteClick(currentPokemon)}

    }

    override fun getItemCount() = pokemons.size

    fun setPokemons(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }
}