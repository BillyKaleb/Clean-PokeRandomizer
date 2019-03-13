package com.kaleb.data.main.repository.source;

import com.kaleb.data.AbstractEntityDataFactory;
import com.kaleb.data.Source;
import com.kaleb.data.main.repository.source.mock.MockMainEntityData;
import com.kaleb.data.main.repository.source.network.NetworkMainEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainEntityDataFactory, v 0.1 13/03/19 12.25 by Billy Kaleb Hananto
 */
@Singleton
public class MainEntityDataFactory extends AbstractEntityDataFactory {

    @Inject
    public MainEntityDataFactory() {

    }

    @Override
    public MainEntityData createData(String source) {
        if (source.equals(Source.MOCK)) {
            return new MockMainEntityData();
        } else {
            return new NetworkMainEntityData();
        }
    }
}
