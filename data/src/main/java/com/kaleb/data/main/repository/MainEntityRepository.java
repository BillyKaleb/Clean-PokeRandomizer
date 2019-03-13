package com.kaleb.data.main.repository;

import com.kaleb.data.Source;
import com.kaleb.data.main.mapper.MainMapper;
import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.MainEntityDataFactory;
import com.kaleb.domain.main.model.PokemonResponse;
import com.kaleb.domain.main.repository.MainRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainEntityRepository, v 0.1 13/03/19 12.24 by Billy Kaleb Hananto
 */
@Singleton
public class MainEntityRepository implements MainRepository {

    private final MainEntityDataFactory mainEntityDataFactory;

    private MainMapper mainMapper;

    @Inject
    public MainEntityRepository(MainEntityDataFactory mainEntityDataFactory,
        MainMapper mainMapper) {
        this.mainEntityDataFactory = mainEntityDataFactory;
        this.mainMapper = mainMapper;
    }

    @Override
    public Observable<PokemonResponse> observablePokemonResponse() {
        return createData().observablePokemon().flatMap(
            pokeResult -> Observable.just(mainMapper.transform(pokeResult))
        );
    }

    private MainEntityData createData() {
        return mainEntityDataFactory.createData(Source.NETWORK);
    }
}

