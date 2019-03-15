package com.kaleb.data.main.mapper;

import com.kaleb.data.main.repository.source.model.Sprites;
import com.kaleb.data.main.repository.source.model.result.PokeResult;
import com.kaleb.domain.main.model.PokemonResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainMapperTest, v 0.1 15/03/19 15.12 by Billy Kaleb Hananto
 */
public class MainMapperTest {

    private static final String pokeFrontSprites = "FrontSprites";

    private static final int pokeHeight = 888;

    private static final int pokeId = 999;

    private static final String pokeName = "PokeName";

    private static final int pokeWeight = 777;

    @Mock
    private MainMapper mainMapper;

    @Spy
    private PokeResult pokeResult;

    @Mock
    private PokemonResponse pokemonResponse;

    @Mock
    private Sprites sprites;

    @Before
    public void setUp() {
        mainMapper = new MainMapper();
        pokeResult = spy(PokeResult.class);
        pokemonResponse = mock(PokemonResponse.class);
        sprites = mock(Sprites.class);
    }

    @Test
    public void transformnPokeResultToPokemonResponse() {
        when(pokeResult.getName()).thenReturn(pokeName);
        when(pokeResult.getId()).thenReturn(pokeId);
        when(pokeResult.getHeight()).thenReturn(pokeHeight);
        when(pokeResult.getWeight()).thenReturn(pokeWeight);
        when(pokeResult.getSprites()).thenReturn(sprites);
        when(pokeResult.getSprites().getFrontDefault()).thenReturn(pokeFrontSprites);
        pokemonResponse = mainMapper.transform(pokeResult);
        assertEquals(pokemonResponse.getPokemonName(), pokeName);
        assertEquals(pokemonResponse.getPokemonId(), pokeId);
        assertEquals(pokemonResponse.getPokemonHeight(), pokeHeight);
        assertEquals(pokemonResponse.getPokemonWeight(), pokeWeight);
        assertEquals(pokemonResponse.getPokemonFrontLookSprite(), pokeFrontSprites);
    }

}
