package com.kaleb.clean_pokerandomizer.base;

import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version BasePresenter, v 0.1 12/03/19 15.02 by Billy Kaleb Hananto
 */
public abstract class BasePresenter implements DisposableHandler {

    private CompositeDisposable disposables;

    @Override
    public void addDisposable(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }

        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

    @Override
    public void disposeDisposable() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
