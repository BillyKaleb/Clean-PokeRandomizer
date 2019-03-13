package com.kaleb.clean_pokerandomizer.main;

import com.kaleb.clean_pokerandomizer.di.PerActivity;
import com.kaleb.domain.DefaultObserver;
import com.kaleb.domain.main.interactor.GetPokemonInteractor;
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

    private final MainContract.View view;

    private Context context;

    @Inject
    public MainPresenter(GetPokemonInteractor getPokemonInteractor, Context context,
        MainContract.View view) {
        this.getPokemonInteractor = getPokemonInteractor;
        this.context = context;
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getFromData() {
        getPokemonInteractor.execute(getPokemonResponse());
    }

    private DefaultObserver<PokemonResponse> getPokemonResponse() {
        view.showProgress();
        return new DefaultObserver<PokemonResponse>() {
            @Override
            public void onNext(PokemonResponse pokemonResponse) {
                if (pokemonResponse.getPokemonName() != null) {
                    view.setText(pokemonResponse.getPokemonName());
                }
            }

            @Override
            public void onError(Throwable e) {
                view.onError("Error from mock");
                view.dismissProgress();
            }

            @Override
            public void onComplete() {
                view.dismissProgress();
            }
        };
    }
}
