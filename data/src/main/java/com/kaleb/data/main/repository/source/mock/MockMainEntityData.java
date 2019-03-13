package com.kaleb.data.main.repository.source.mock;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.model.result.MainResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MockMainEntityData, v 0.1 13/03/19 12.37 by Billy Kaleb Hananto
 */
public class MockMainEntityData implements MainEntityData {

    @Override
    public Observable<MainResult> observableMock() {
        return Observable.just(dummyMainResult());
    }

    public MainResult dummyMainResult() {
        MainResult mainResult = new MainResult();
        mainResult.setDummy("Hello world!");
        return mainResult;
    }
}
