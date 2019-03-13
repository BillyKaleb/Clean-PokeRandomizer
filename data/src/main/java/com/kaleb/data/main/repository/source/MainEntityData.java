package com.kaleb.data.main.repository.source;

import com.kaleb.data.main.repository.source.model.result.MainResult;

import io.reactivex.Observable;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainEntityData, v 0.1 13/03/19 12.25 by Billy Kaleb Hananto
 */
public interface MainEntityData {

    Observable<MainResult> observableMock();
}
