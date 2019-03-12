package com.kaleb.clean_pokerandomizer.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version BaseFragment, v 0.1 12/03/19 14.58 by Billy Kaleb Hananto
 */
public abstract class BaseFragment extends Fragment implements DisposableHandler,
    PresenterHandler {

    private BaseActivity baseActivity;

    private CompositeDisposable compositeDisposable;

    private List<AbstractContract.AbstractPresenter> presenterList;

    private Unbinder unbinder;

    public BaseActivity getBaseActivity() {
        return baseActivity;
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
                if (presenter != null) {
                    presenter.onDestroy();
                }
            }
            presenterList = null;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof BaseActivity) {
            baseActivity = (BaseActivity) getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view;
        if (getLayout() != 0) {
            view = inflater.inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract int getLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    protected abstract void init();

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        disposeDisposable();
        disposePresenter();
        super.onDestroyView();
    }
}
