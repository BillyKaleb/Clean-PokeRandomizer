package com.kaleb.clean_pokerandomizer.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ApplicationModule, v 0.1 12/03/19 16.14 by Billy Kaleb Hananto
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }
}
