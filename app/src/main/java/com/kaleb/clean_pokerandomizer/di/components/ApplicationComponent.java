package com.kaleb.clean_pokerandomizer.di.components;

import com.kaleb.clean_pokerandomizer.PokeRandomizerApplication;
import com.kaleb.clean_pokerandomizer.base.BaseActivity;
import com.kaleb.clean_pokerandomizer.di.modules.ApiModule;
import com.kaleb.clean_pokerandomizer.di.modules.ApplicationModule;
import com.kaleb.clean_pokerandomizer.di.modules.NetworkModule;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ApplicationComponent, v 0.1 12/03/19 15.21 by Billy Kaleb Hananto
 */

@Singleton
@Component(modules = {
    ApplicationModule.class,
    NetworkModule.class,
    ApiModule.class
})
public interface ApplicationComponent {

    void inject(PokeRandomizerApplication pokeRandomizerApplication);

    void inject(BaseActivity baseActivity);

    Context context();

    Application application();
}
