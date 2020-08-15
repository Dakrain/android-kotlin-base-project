package vn.com.vng.alphadriver.di.module

import dagger.Binds
import dagger.Module
import vn.com.vng.alphadriver.data.PokemonRepositoryImpl
import vn.com.vng.alphadriver.domain.repository.PokemonRepository
import javax.inject.Singleton

/**
 * Module that bind repository interface and repository impl to app
 */
@Module
abstract class RepositoryModule {
    //Bind repository here

    @Singleton
    @Binds
    abstract fun providePokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}