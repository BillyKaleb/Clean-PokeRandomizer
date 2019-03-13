package com.kaleb.clean_pokerandomizer.di.modules;

import com.kaleb.clean_pokerandomizer.di.PerActivity;
import com.kaleb.clean_pokerandomizer.main.MainContract;
import com.kaleb.clean_pokerandomizer.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainModule, v 0.1 13/03/19 09.33 by Billy Kaleb Hananto
 */
@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainContract.View provideView() {
        return view;
    }

    @Provides
    @PerActivity
    MainContract.Presenter providePresenter(MainPresenter mainPresenter) {
        return mainPresenter;
    }
}
