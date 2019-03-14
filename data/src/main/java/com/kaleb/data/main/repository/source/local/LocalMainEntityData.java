package com.kaleb.data.main.repository.source.local;

import com.kaleb.data.BasePersistence;
import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;
import com.kaleb.data.main.repository.source.model.Sprites;
import com.kaleb.data.main.repository.source.model.result.PokeResult;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version LocalMainEntityData, v 0.1 13/03/19 15.43 by Billy Kaleb Hananto
 */
public class LocalMainEntityData extends BasePersistence implements MainEntityData {

    @Inject
    public LocalMainEntityData(Context context) {
        super(context);
    }

    @Override
    public Observable<PokeResult> getObservablePokemon(int pokeId) {
        LocalMainEntity localMainEntity = getDb().localMainDao().getLocalMainEntity(pokeId);
        if (localMainEntity == null) {
            return null;
        }
        return Observable.just(localPokeResultMapper(localMainEntity));
    }

    @Override
    public Observable<Long> saveObservablePokemon(LocalMainEntity localMainEntity, int pokeId) {
        LocalMainEntity localMainEntitySaved = getDb().localMainDao().getLocalMainEntity(pokeId);
        Long result;
        if (!isExist(localMainEntitySaved)) {
            Log.d("DebugCheck", "saveObservablePokemon: Saved!");
            result = getDb().localMainDao().insertLocalMain(localMainEntity);
        } else {
            Log.d("DebugCheck", "saveObservablePokemon: Updated!");
            result = (long) getDb().localMainDao().updateLocalMain(localMainEntity);
        }
        return Observable.just(result);
    }

    private boolean isExist(LocalMainEntity localMainEntity) {
        if (localMainEntity == null) {
            return false;
        }
        return true;
    }

    private PokeResult localPokeResultMapper(LocalMainEntity localMainEntity) {
        PokeResult pokeResult = new PokeResult();
        pokeResult.setName(localMainEntity.getPokeName());
        pokeResult.setId(localMainEntity.getPokeId());
        pokeResult.setHeight(localMainEntity.getPokeHeight());
        pokeResult.setWeight(localMainEntity.getPokeWeight());
        pokeResult.setSprites(sprites(localMainEntity));
        return pokeResult;
    }

    private Sprites sprites(LocalMainEntity localMainEntity) {
        Sprites sprites = new Sprites();
        sprites.setFrontDefault(localMainEntity.getPokeSpriteFront());
        sprites.setBackDefault("Back Def");
        sprites.setBackFemale("Back Fem");
        sprites.setBackShiny("Back Shin");
        return sprites;
    }
}
