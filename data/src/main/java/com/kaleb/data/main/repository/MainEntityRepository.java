package com.kaleb.data.main.repository;

import com.kaleb.data.Source;
import com.kaleb.data.main.mapper.MainMapper;
import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.MainEntityDataFactory;
import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;
import com.kaleb.data.main.repository.source.model.result.PokeResult;
import com.kaleb.domain.main.model.PokemonResponse;
import com.kaleb.domain.main.repository.MainRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;

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
    public Observable<PokemonResponse> observablePokemonResponse(int pokeId) {
        return createLocalData().getObservablePokemon(pokeId)
            .onErrorResumeNext(defaultIfEmpty(pokeId))
            .flatMap(pokeResult -> Observable.just(mainMapper.transform(pokeResult))
        );
    }

    private Function<Throwable, ObservableSource<PokeResult>> defaultIfEmpty(int pokeId){
        return throwable -> createNetworkData().getObservablePokemon(pokeId);
    }

    private MainEntityData createLocalData(){
        return mainEntityDataFactory.createData(Source.LOCAL);
    }

    private MainEntityData createNetworkData(){
        return mainEntityDataFactory.createData(Source.NETWORK);
    }

    @Override
    public Observable<Boolean> saveToLocalPokemonResponse(String name, int id, int weight,
        int height, String frontSprite) {
        LocalMainEntity localMainEntity = new LocalMainEntity(height, id, name, frontSprite,
            weight);
        return mainEntityDataFactory.createData(Source.LOCAL)
            .saveObservablePokemon(localMainEntity, id)
            .flatMap(
                (Function<Long, ObservableSource<Boolean>>) localMainId -> {
                    if (localMainId != null) {
                        return Observable.just(true);
                    }
                    return Observable.just(false);
                });
    }
}

