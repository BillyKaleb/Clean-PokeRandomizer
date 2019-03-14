package com.kaleb.data.main.repository.source.network;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;
import com.kaleb.data.main.repository.source.model.result.PokeResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version NetworkMainEntityData, v 0.1 13/03/19 12.37 by Billy Kaleb Hananto
 */
public class NetworkMainEntityData implements MainEntityData {

    private final MainAPI mainAPI;

    public NetworkMainEntityData(MainAPI mainAPI) {
        this.mainAPI = mainAPI;
    }

    @Override
    public Observable<PokeResult> getObservablePokemon(int pokeId) {
        return mainAPI.getPokemon(pokeId).toObservable();
    }

    @Override
    public Observable<Long> saveObservablePokemon(LocalMainEntity localMainEntity, int pokeId) {
        return null;
    }
}
