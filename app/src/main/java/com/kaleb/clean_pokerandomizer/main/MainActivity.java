package com.kaleb.clean_pokerandomizer.main;

import com.bumptech.glide.Glide;
import com.kaleb.clean_pokerandomizer.R;
import com.kaleb.clean_pokerandomizer.base.BaseActivity;
import com.kaleb.clean_pokerandomizer.di.components.DaggerMainComponent;
import com.kaleb.clean_pokerandomizer.di.components.MainComponent;
import com.kaleb.clean_pokerandomizer.di.modules.MainModule;

import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.iv_sprite)
    ImageView ivSprite;

    @Inject
    MainContract.Presenter mainPresenter;

    @BindView(R.id.tv_pokeheight)
    TextView tvPokeheight;

    @BindView(R.id.tv_pokeid)
    TextView tvPokeid;

    @BindView(R.id.tv_pokename)
    TextView tvPokename;

    @BindView(R.id.tv_pokeweight)
    TextView tvPokeweight;

    private MainComponent mainComponent;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initInjector();
        mainPresenter.getFromData();
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

    @Override
    public void setText(String name, int id, int height, int weight) {
        tvPokename.setText(name);
        tvPokeid.setText(Integer.toString(id));
        tvPokeheight.setText(Integer.toString(height));
        tvPokeweight.setText(Integer.toString(weight));
    }

    @Override
    public void displayImage(String url) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(ivSprite);
    }
}
