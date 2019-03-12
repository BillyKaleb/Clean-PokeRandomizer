package com.kaleb.clean_pokerandomizer.di.components;

import com.kaleb.clean_pokerandomizer.base.BaseActivity;
import com.kaleb.clean_pokerandomizer.di.PerActivity;
import com.kaleb.clean_pokerandomizer.di.modules.ActivityModule;

import dagger.Component;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ActivityComponent, v 0.1 12/03/19 16.13 by Billy Kaleb Hananto
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    BaseActivity activity();

}
