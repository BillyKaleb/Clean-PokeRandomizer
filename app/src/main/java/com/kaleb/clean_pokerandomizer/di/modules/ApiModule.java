package com.kaleb.clean_pokerandomizer.di.modules;

import com.kaleb.clean_pokerandomizer.BuildConfig;
import com.kaleb.data.main.repository.source.network.MainAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ApiModule, v 0.1 12/03/19 16.43 by Billy Kaleb Hananto
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    MainAPI provideMainApi(Retrofit.Builder builder) {
        return builder
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(MainAPI.class);
    }
}
