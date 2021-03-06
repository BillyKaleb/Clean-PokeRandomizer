package com.kaleb.domain.main.interactor;

import com.kaleb.domain.PostExecutionThread;
import com.kaleb.domain.ThreadExecutor;
import com.kaleb.domain.UseCase;
import com.kaleb.domain.main.model.PokemonResponse;
import com.kaleb.domain.main.repository.MainRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version GetPokemonInteractor, v 0.1 13/03/19 11.26 by Billy Kaleb Hananto
 */
public class GetPokemonInteractor extends UseCase<PokemonResponse, GetPokemonInteractor.Params> {

    private MainRepository mainRepository;

    @Inject
    public GetPokemonInteractor(ThreadExecutor threadExecutor,
        PostExecutionThread postExecutionThread, MainRepository mainRepository) {
        super(threadExecutor, postExecutionThread);
        this.mainRepository = mainRepository;
    }

    @Override
    protected Observable<PokemonResponse> buildUseCaseObservable(Params params) {
        return mainRepository.observablePokemonResponse(params.pokeId);
    }

    public static class Params {

        private int pokeId;

        private Params(int pokeId) {
            this.pokeId = pokeId;
        }

        public static GetPokemonInteractor.Params getPokemonById(int pokeId) {
            return new GetPokemonInteractor.Params(pokeId);
        }
    }
}
