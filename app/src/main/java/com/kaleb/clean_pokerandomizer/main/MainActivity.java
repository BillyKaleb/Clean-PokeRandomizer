package com.kaleb.clean_pokerandomizer.main;

import com.kaleb.clean_pokerandomizer.R;
import com.kaleb.clean_pokerandomizer.base.BaseActivity;
import com.kaleb.clean_pokerandomizer.di.components.DaggerMainComponent;
import com.kaleb.clean_pokerandomizer.di.components.MainComponent;
import com.kaleb.clean_pokerandomizer.di.modules.MainModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter mainPresenter;

    private MainComponent mainComponent;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initInjector();
    }

    private void initInjector() {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .mainModule(new MainModule(this))
                .build();
        }
        mainComponent.inject(this);

        registerPresenter(mainPresenter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void onError(String errorMessage) {

    }
}
