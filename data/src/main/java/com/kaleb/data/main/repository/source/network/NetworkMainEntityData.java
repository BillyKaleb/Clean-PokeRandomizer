package com.kaleb.data.main.repository.source.network;

import com.kaleb.data.main.repository.source.MainEntityData;
import com.kaleb.data.main.repository.source.model.result.MainResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version NetworkMainEntityData, v 0.1 13/03/19 12.37 by Billy Kaleb Hananto
 */
public class NetworkMainEntityData implements MainEntityData {

    @Override
    public Observable<MainResult> observableMock() {
        return null;
    }
}
