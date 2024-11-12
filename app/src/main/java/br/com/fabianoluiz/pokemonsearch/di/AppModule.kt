package br.com.fabianoluiz.pokemonsearch.di

import androidx.room.Room
import br.com.fabianoluiz.pokemonsearch.data.local.AppDatabase
import br.com.fabianoluiz.pokemonsearch.data.remote.api.PokemonService
import br.com.fabianoluiz.pokemonsearch.data.repository.PokemonRepositoryImpl
import br.com.fabianoluiz.pokemonsearch.domain.repository.PokemonRepository
import br.com.fabianoluiz.pokemonsearch.domain.usecase.GetPokemonUseCase
import br.com.fabianoluiz.pokemonsearch.presentation.detail.PokemonDetailViewModel
import br.com.fabianoluiz.pokemonsearch.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl( "https://pokeapi.co/api/v2/" )
            .addConverterFactory( GsonConverterFactory .create())
            .build()
            .create( PokemonService ::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase ::class.java,
            "pokemon_database" )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().pokemonDao() }
}

val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }
}
val useCaseModule = module {
    factory { GetPokemonUseCase(get()) }
}
val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { PokemonDetailViewModel(get()) }
}
