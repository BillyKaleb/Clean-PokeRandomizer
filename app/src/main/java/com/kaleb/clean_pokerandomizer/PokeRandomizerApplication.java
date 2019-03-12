package com.kaleb.clean_pokerandomizer;

import com.kaleb.clean_pokerandomizer.di.ComponentHolder;
import com.kaleb.clean_pokerandomizer.di.components.ApplicationComponent;
import com.kaleb.clean_pokerandomizer.di.components.DaggerApplicationComponent;
import com.kaleb.clean_pokerandomizer.di.modules.ApiModule;
import com.kaleb.clean_pokerandomizer.di.modules.ApplicationModule;
import com.kaleb.clean_pokerandomizer.di.modules.NetworkModule;

import android.app.Application;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version PokeRandomizerApplication, v 0.1 12/03/19 14.27 by Billy Kaleb Hananto
 */
public class PokeRandomizerApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
    }

    private void initInjector() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .apiModule(new ApiModule())
                .build();
        }
        applicationComponent.inject(this);

        ComponentHolder.set(applicationComponent);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
