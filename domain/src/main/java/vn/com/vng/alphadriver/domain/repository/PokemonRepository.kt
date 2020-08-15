package vn.com.vng.alphadriver.domain.repository

import io.reactivex.Observable
import vn.com.vng.alphadriver.domain.entity.Pokemon

interface PokemonRepository {
    fun getPokemonDetail(pokemonName : String): Observable<Pokemon>
}