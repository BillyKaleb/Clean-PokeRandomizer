package com.kaleb.clean_pokerandomizer.di.modules;

import com.kaleb.clean_pokerandomizer.base.BaseActivity;
import com.kaleb.clean_pokerandomizer.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ActivityModule, v 0.1 12/03/19 16.14 by Billy Kaleb Hananto
 */
@Module
public class ActivityModule {

    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @PerActivity
    BaseActivity activity() {
        return baseActivity;
    }
}
