package com.kaleb.domain.main.repository;

import com.kaleb.domain.main.model.PokemonResponse;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainRepository, v 0.1 13/03/19 11.21 by Billy Kaleb Hananto
 */
public interface MainRepository {

    Observable<PokemonResponse> observablePokemonResponse();
}
