package com.kaleb.data.main.repository.source.mock;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;
import com.kaleb.data.main.repository.source.model.Sprites;
import com.kaleb.data.main.repository.source.model.result.PokeResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MockMainEntityData, v 0.1 13/03/19 12.37 by Billy Kaleb Hananto
 */
public class MockMainEntityData implements MainEntityData {

    @Override
    public Observable<PokeResult> getObservablePokemon(int pokeId) {
        return Observable.just(dummyPokeResult());
    }

    @Override
    public Observable<Long> saveObservablePokemon(LocalMainEntity localMainEntity, int pokeId) {
        return null;
    }

    private PokeResult dummyPokeResult() {
        PokeResult pokeResult = new PokeResult();
        pokeResult.setName("Yorushika");
        pokeResult.setId(99999);
        pokeResult.setHeight(30);
        pokeResult.setWeight(200);
        pokeResult.setSprites(sprites());
        return pokeResult;
    }

    private Sprites sprites() {
        Sprites sprites = new Sprites();
        sprites.setFrontDefault("http://mikudb.moe/wp-content/uploads/2018/08/Cover.jpg");
        sprites.setBackDefault("Back Def");
        sprites.setBackFemale("Back Fem");
        sprites.setBackShiny("Back Shin");
        return sprites;
    }
}
