package com.kaleb.data.main.repository.source.network;

import com.kaleb.data.main.repository.source.model.result.PokeResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainAPI, v 0.1 13/03/19 14.57 by Billy Kaleb Hananto
 */
public interface MainAPI {

    @GET("pokemon/{PokemonNumber}")
    Single<PokeResult> getPokemon(@Path("PokemonNumber") int pokemonNumber);
}
