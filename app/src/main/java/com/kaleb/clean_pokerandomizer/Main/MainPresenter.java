package com.kaleb.clean_pokerandomizer.main;

import com.kaleb.clean_pokerandomizer.di.PerActivity;

import android.content.Context;

import javax.inject.Inject;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainPresenter, v 0.1 13/03/19 09.34 by Billy Kaleb Hananto
 */
@PerActivity
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    private Context context;

    @Inject
    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }
}
