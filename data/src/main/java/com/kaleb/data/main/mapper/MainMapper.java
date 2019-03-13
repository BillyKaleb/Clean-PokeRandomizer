package com.kaleb.data.main.mapper;

import com.kaleb.data.main.repository.source.model.result.MainResult;
import com.kaleb.domain.main.model.PokemonResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainMapper, v 0.1 13/03/19 13.04 by Billy Kaleb Hananto
 */
@Singleton
public class MainMapper {

    @Inject
    public MainMapper(){

    }

    public PokemonResponse transform(MainResult mainResult) {
        //TODO(Billy Kaleb) : Changes from null to proper mapper
        return null;
    }
}
