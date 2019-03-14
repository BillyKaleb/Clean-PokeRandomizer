package com.kaleb.clean_pokerandomizer.main;

import com.kaleb.clean_pokerandomizer.di.PerActivity;
import com.kaleb.domain.DefaultObserver;
import com.kaleb.domain.main.interactor.GetPokemonInteractor;
import com.kaleb.domain.main.interactor.SaveToLocalPokemonInteractor;
import com.kaleb.domain.main.model.PokemonResponse;

import android.content.Context;

import javax.inject.Inject;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainPresenter, v 0.1 13/03/19 09.34 by Billy Kaleb Hananto
 */
@PerActivity
public class MainPresenter implements MainContract.Presenter {

    private final GetPokemonInteractor getPokemonInteractor;

    private final SaveToLocalPokemonInteractor saveToLocalPokemonInteractor;

    private final MainContract.View view;

    private Context context;

    @Inject
    public MainPresenter(GetPokemonInteractor getPokemonInteractor, Context context,
        MainContract.View view, SaveToLocalPokemonInteractor saveToLocalPokemonInteractor) {
        this.getPokemonInteractor = getPokemonInteractor;
        this.context = context;
        this.view = view;
        this.saveToLocalPokemonInteractor = saveToLocalPokemonInteractor;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getFromData() {
        getPokemonInteractor
            .execute(getPokemonResponse(), GetPokemonInteractor.Params.getPokemonById(77));
    }

    private DefaultObserver<PokemonResponse> getPokemonResponse() {
        view.showProgress();
        return new DefaultObserver<PokemonResponse>() {
            @Override
            public void onNext(PokemonResponse pokemonResponse) {
                if (pokemonResponse.getPokemonName() != null && pokemonResponse
                    .getPokemonFrontLookSprite() != null) {
                    view.displayImage(pokemonResponse.getPokemonFrontLookSprite());
                    view.setText(pokemonResponse.getPokemonName(), pokemonResponse.getPokemonId(),
                        pokemonResponse.getPokemonHeight(), pokemonResponse.getPokemonWeight());
                }
                saveToLocalPokemonInteractor.execute(new DefaultObserver<Boolean>() {
                    @Override
                    public void onError(Throwable e) {
                        //TODO (Billy Kaleb Hananto) : Fill the error handler
                    }
                }, SaveToLocalPokemonInteractor.Params
                    .savePokemonToLocal(pokemonResponse.getPokemonName(),
                        pokemonResponse.getPokemonId(), pokemonResponse.getPokemonHeight(),
                        pokemonResponse.getPokemonWeight(),
                        pokemonResponse.getPokemonFrontLookSprite()));
            }

            @Override
            public void onError(Throwable e) {
                view.dismissProgress();
            }

            @Override
            public void onComplete() {
                view.dismissProgress();
            }
        };
    }
}
