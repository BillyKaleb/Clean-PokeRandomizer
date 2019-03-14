package com.kaleb.domain.main.interactor;

import com.kaleb.domain.PostExecutionThread;
import com.kaleb.domain.ThreadExecutor;
import com.kaleb.domain.UseCase;
import com.kaleb.domain.main.repository.MainRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version SaveToLocalPokemonInteractor, v 0.1 14/03/19 11.02 by Billy Kaleb Hananto
 */
public class SaveToLocalPokemonInteractor extends UseCase<Boolean,
    SaveToLocalPokemonInteractor.Params> {

    private final MainRepository mainRepository;

    @Inject
    public SaveToLocalPokemonInteractor(ThreadExecutor threadExecutor,
        PostExecutionThread postExecutionThread, MainRepository mainRepository) {
        super(threadExecutor, postExecutionThread);
        this.mainRepository = mainRepository;
    }

    @Override
    protected Observable<Boolean> buildUseCaseObservable(Params params) {
        return mainRepository
            .saveToLocalPokemonResponse(params.pokeName, params.pokeId, params.pokeWeight,
                params.pokeHeight,
                params.pokeFrontSprite);
    }

    public static class Params {

        private String pokeFrontSprite;

        private int pokeHeight;

        private int pokeId;

        private String pokeName;

        private int pokeWeight;

        private Params(String pokeName, int pokeId, int pokeHeight, int pokeWeight,
            String pokeFrontSprite) {
            this.pokeName = pokeName;
            this.pokeId = pokeId;
            this.pokeHeight = pokeHeight;
            this.pokeWeight = pokeWeight;
            this.pokeFrontSprite = pokeFrontSprite;
        }

        public static SaveToLocalPokemonInteractor.Params savePokemonToLocal(String pokeName,
            int pokeId, int pokeHeight, int pokeWeight,
            String pokeFrontSprite) {
            return new SaveToLocalPokemonInteractor.Params(pokeName, pokeId, pokeHeight, pokeWeight,
                pokeFrontSprite);
        }
    }
}
