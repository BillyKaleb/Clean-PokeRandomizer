package com.kaleb.clean_pokerandomizer.di.components;

import com.kaleb.clean_pokerandomizer.di.PerActivity;
import com.kaleb.clean_pokerandomizer.di.modules.MainModule;
import com.kaleb.clean_pokerandomizer.main.MainActivity;

import dagger.Component;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainComponent, v 0.1 13/03/19 09.44 by Billy Kaleb Hananto
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
