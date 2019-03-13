package com.kaleb.data.main.repository.source.mock;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.model.Sprites;
import com.kaleb.data.main.repository.source.model.result.PokeResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MockMainEntityData, v 0.1 13/03/19 12.37 by Billy Kaleb Hananto
 */
public class MockMainEntityData implements MainEntityData {

    @Override
    public Observable<PokeResult> observablePokemon() {
        return Observable.just(dummyPokeResult());
    }

    public PokeResult dummyPokeResult() {
        PokeResult pokeResult = new PokeResult();
        pokeResult.setName("Yorushika");
        pokeResult.setId(999);
        pokeResult.setHeight(30);
        pokeResult.setWeight(200);
        pokeResult.setSprites(sprites());
        return pokeResult;
    }

    public Sprites sprites() {
        Sprites sprites = new Sprites();
        sprites.setFrontDefault("Front Def");
        sprites.setBackDefault("Back Def");
        sprites.setBackFemale("Back Fem");
        sprites.setBackShiny("Back Shin");
        return sprites;
    }
}
