package com.kaleb.clean_pokerandomizer.base;

import io.reactivex.disposables.Disposable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version DisposableHandler, v 0.1 12/03/19 14.55 by Billy Kaleb Hananto
 */
public interface DisposableHandler {

    void addDisposable(Disposable disposable);

    void disposeDisposable();

}
