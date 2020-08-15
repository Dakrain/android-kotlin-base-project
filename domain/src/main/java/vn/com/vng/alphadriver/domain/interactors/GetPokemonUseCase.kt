package vn.com.vng.alphadriver.domain.interactors

import io.reactivex.Observable
import vn.com.vng.alphadriver.domain.entity.Pokemon
import vn.com.vng.alphadriver.domain.repository.PokemonRepository
import vn.com.vng.alphadriver.domain.scheduler.SchedulerProvider
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    schedulerProvider: SchedulerProvider
) :
    BaseUseCase(schedulerProvider) {

    fun getPokemonByName(pokemonName: String): Observable<Pokemon> {
        return repository.getPokemonDetail(pokemonName)
    }

}