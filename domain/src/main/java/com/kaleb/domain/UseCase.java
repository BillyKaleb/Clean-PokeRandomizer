package com.kaleb.domain;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version UseCase, v 0.1 13/03/19 11.07 by Billy Kaleb Hananto
 *
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a
 * {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase<T, Params> {

    /** disposables */
    private final CompositeDisposable disposables;

    /** postExecutionThread */
    private final PostExecutionThread postExecutionThread;

    /** threadExecutor */
    private final ThreadExecutor threadExecutor;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        disposables = new CompositeDisposable();
    }

    /**
     * Execute the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildUseCaseObservable(Params)} ()} method.
     */
    public void execute(DisposableObserver<T> observer) {
        execute(observer, null);
    }

    /**
     * Execute the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildUseCaseObservable(Params)} ()} method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    public void execute(DisposableObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);

        final Observable<T> observable = buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler());

        addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}
     *
     * @param params Parameters (Optional) used to build/execute this use case.
     * @return Observable
     */
    protected abstract Observable<T> buildUseCaseObservable(Params params);

    /**
     * Dispose from current {@link CompositeDisposable}
     *
     * @param disposable {@link Disposable}
     */
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

    /**
     * Dispose from current {@link CompositeDisposable}
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}