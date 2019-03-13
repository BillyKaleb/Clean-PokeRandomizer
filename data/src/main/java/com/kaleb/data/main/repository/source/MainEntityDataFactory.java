package com.kaleb.data.main.repository.source;

import com.kaleb.data.AbstractEntityDataFactory;
import com.kaleb.data.Source;
import com.kaleb.data.main.repository.source.local.LocalMainEntityData;
import com.kaleb.data.main.repository.source.mock.MockMainEntityData;
import com.kaleb.data.main.repository.source.network.MainAPI;
import com.kaleb.data.main.repository.source.network.NetworkMainEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainEntityDataFactory, v 0.1 13/03/19 12.25 by Billy Kaleb Hananto
 */
@Singleton
public class MainEntityDataFactory extends AbstractEntityDataFactory {

    private final MainAPI mainAPI;

    @Inject
    public MainEntityDataFactory(MainAPI mainAPI) {
        this.mainAPI = mainAPI;
    }

    @Override
    public MainEntityData createData(String source) {
        if (source.equals(Source.MOCK)) {
            return new MockMainEntityData();
        } else if (source.equals(Source.LOCAL)) {
            return new LocalMainEntityData();
        } else {
            return new NetworkMainEntityData(mainAPI);
        }
    }
}
