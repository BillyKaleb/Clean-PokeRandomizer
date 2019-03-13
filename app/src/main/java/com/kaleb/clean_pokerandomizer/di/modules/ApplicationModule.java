package com.kaleb.clean_pokerandomizer.di.modules;

import com.kaleb.clean_pokerandomizer.UIThread;
import com.kaleb.data.JobExecutor;
import com.kaleb.data.main.repository.MainEntityRepository;
import com.kaleb.domain.PostExecutionThread;
import com.kaleb.domain.ThreadExecutor;
import com.kaleb.domain.main.repository.MainRepository;

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

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    MainRepository provideMainRepository(MainEntityRepository mainEntityRepository) {
        return mainEntityRepository;
    }
}
