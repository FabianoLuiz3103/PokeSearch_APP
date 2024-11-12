package br.com.fabianoluiz.pokemonsearch

import android.app.Application
import br.com.fabianoluiz.pokemonsearch.di.databaseModule
import br.com.fabianoluiz.pokemonsearch.di.networkModule
import br.com.fabianoluiz.pokemonsearch.di.repositoryModule
import br.com.fabianoluiz.pokemonsearch.di.useCaseModule
import br.com.fabianoluiz.pokemonsearch.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PokemonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonApplication )
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }

    }
}