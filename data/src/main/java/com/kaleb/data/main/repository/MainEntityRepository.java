package com.kaleb.data.main.repository;

import com.kaleb.data.Source;
import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.MainEntityDataFactory;
import com.kaleb.data.main.repository.source.model.result.MainResult;
import com.kaleb.domain.main.model.PokemonResponse;
import com.kaleb.domain.main.repository.MainRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainEntityRepository, v 0.1 13/03/19 12.24 by Billy Kaleb Hananto
 */
@Singleton
public class MainEntityRepository implements MainRepository {

    private final MainEntityDataFactory mainEntityDataFactory;

    @Inject
    public MainEntityRepository(MainEntityDataFactory mainEntityDataFactory) {
        this.mainEntityDataFactory = mainEntityDataFactory;
    }

    @Override
    public Observable<PokemonResponse> observablePokemonResponse() {
        return createData().observableMock().flatMap(
            (Function<MainResult, ObservableSource<PokemonResponse>>)
                mainResult -> {
                    PokemonResponse pokemonResponse = new PokemonResponse();
                    pokemonResponse.setHelloWorld(mainResult.getDummy());
                    return Observable.just(pokemonResponse);
                });
    }

    private MainEntityData createData() {
        return mainEntityDataFactory.createData(Source.MOCK);
    }
}

