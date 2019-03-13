package com.kaleb.domain;

import io.reactivex.observers.DisposableObserver;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version DefaultObserver, v 0.1 13/03/19 11.13 by Billy Kaleb Hananto
 */
public class DefaultObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        
    }

    @Override
    public void onComplete() {

    }
}
