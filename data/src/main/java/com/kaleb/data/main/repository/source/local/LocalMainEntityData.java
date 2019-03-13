package com.kaleb.data.main.repository.source.local;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.model.result.PokeResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version LocalMainEntityData, v 0.1 13/03/19 15.43 by Billy Kaleb Hananto
 */
public class LocalMainEntityData implements MainEntityData {

    @Override
    public Observable<PokeResult> observablePokemon() {
        return null;
    }
}
