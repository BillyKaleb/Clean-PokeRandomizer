package com.kaleb.domain.main.interactor;

import com.kaleb.domain.PostExecutionThread;
import com.kaleb.domain.ThreadExecutor;
import com.kaleb.domain.main.repository.MainRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version SaveToLocalPokemonInteractorTest, v 0.1 15/03/19 15.05 by Billy Kaleb Hananto
 */
@RunWith(MockitoJUnitRunner.class)
public class SaveToLocalPokemonInteractorTest {

    private static final String pokeFrontSprite = "FrontSprite";

    private static final int pokeHeight = 123456789;

    private static final int pokeId = 111111111;

    private static final String pokeName = "Name";

    private static final int pokeWeight = 987654321;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private MainRepository mockMainRepository;

    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Mock
    private ThreadExecutor mockThreadExecutor;

    private SaveToLocalPokemonInteractor saveToLocalPokemonInteractor;

    @Before
    public void setUp() {
        saveToLocalPokemonInteractor = new SaveToLocalPokemonInteractor(mockThreadExecutor,
            mockPostExecutionThread, mockMainRepository);
    }

    @Test
    public void testSaveToLocalPokemonInteractorPositiveCase() {
        saveToLocalPokemonInteractor
            .buildUseCaseObservable(SaveToLocalPokemonInteractor.Params
                .savePokemonToLocal(pokeName, pokeId, pokeHeight, pokeWeight, pokeFrontSprite));

        verify(mockMainRepository)
            .saveToLocalPokemonResponse(pokeName, pokeId, pokeHeight, pokeWeight, pokeFrontSprite);
        verifyNoMoreInteractions(mockMainRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }

    @Test
    public void testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException.class);
        saveToLocalPokemonInteractor.buildUseCaseObservable(null);
    }
}
