package vn.com.vng.alphadriver.data.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import vn.com.vng.alphadriver.domain.entity.Pokemon

interface ApiService {

    @GET("pokemon/{pokemonName}")
    fun getPokemon(@Path("pokemonName") pokemonName: String): Observable<Pokemon>
}