package com.kaleb.clean_pokerandomizer.base;

import com.kaleb.clean_pokerandomizer.PokeRandomizerApplication;
import com.kaleb.clean_pokerandomizer.di.components.ApplicationComponent;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version BaseActivity, v 0.1 12/03/19 14.52 by Billy Kaleb Hananto
 */
public abstract class BaseActivity extends AppCompatActivity implements DisposableHandler,
    PresenterHandler {

    private CompositeDisposable compositeDisposable;

    private List<AbstractContract.AbstractPresenter> presenterList;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);

        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);

        init(savedInstanceState);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((PokeRandomizerApplication) getApplication()).getApplicationComponent();
    }

    public abstract int getLayout();

    public void init(Bundle savedInstanceState) {
        init();
    }

    public abstract void init();

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        disposeDisposable();
        disposePresenter();
        super.onDestroy();
    }

    @Override
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(compositeDisposable);
        compositeDisposable.add(disposable);
    }

    @Override
    public void disposeDisposable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
    }

    @Override
    public void registerPresenter(AbstractContract.AbstractPresenter... presenters) {
        if (presenterList == null) {
            presenterList = new ArrayList<>();
        }
        if (presenters != null && presenters.length > 0) {
            presenterList.addAll(Arrays.asList(presenters));
        }
    }

    @Override
    public void disposePresenter() {
        if (presenterList != null) {
            for (AbstractContract.AbstractPresenter presenter : presenterList) {
                presenter.onDestroy();
            }
        }
    }
}
