package vn.com.vng.alphadriver.data

import io.reactivex.Observable
import vn.com.vng.alphadriver.data.service.ApiService
import vn.com.vng.alphadriver.domain.entity.Pokemon
import vn.com.vng.alphadriver.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val apiService: ApiService) : PokemonRepository {

    override fun getPokemonDetail(pokemonName: String): Observable<Pokemon> = apiService.getPokemon(pokemonName.toLowerCase())

}