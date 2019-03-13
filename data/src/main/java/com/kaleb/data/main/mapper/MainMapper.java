package com.kaleb.data.main.mapper;

import com.kaleb.data.main.repository.source.model.result.PokeResult;
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
    public MainMapper() {

    }

    public PokemonResponse transform(PokeResult pokeResult) {
        PokemonResponse pokeResponse = null;

        if (pokeResult != null) {
            pokeResponse = new PokemonResponse();
            pokeResponse.setPokemonName(pokeResult.getName());
            pokeResponse.setPokemonId(pokeResult.getId());
            pokeResponse.setPokemonHeight(pokeResult.getHeight());
            pokeResponse.setPokemonWeight(pokeResult.getWeight());
            pokeResponse.setPokemonFrontLookSprite(pokeResult.getSprites().getFrontDefault());
        }

        return pokeResponse;
    }
}
