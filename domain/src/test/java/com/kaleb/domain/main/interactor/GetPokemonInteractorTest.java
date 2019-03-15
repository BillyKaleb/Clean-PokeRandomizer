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
 * @version GetPokemonInteractorTest, v 0.1 15/03/19 15.00 by Billy Kaleb Hananto
 */
@RunWith(MockitoJUnitRunner.class)
public class GetPokemonInteractorTest {

    private static final int pokeId = 99;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private GetPokemonInteractor getPokemonInteractor;

    @Mock
    private MainRepository mockMainRepository;

    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Mock
    private ThreadExecutor mockThreadExecutor;

    @Before
    public void setUp() {
        getPokemonInteractor = new GetPokemonInteractor(mockThreadExecutor,
            mockPostExecutionThread, mockMainRepository);
    }

    @Test
    public void testGetCurrentWeatherUseCasePositiveCase() {
        getPokemonInteractor
            .buildUseCaseObservable(GetPokemonInteractor.Params.getPokemonById(pokeId));

        verify(mockMainRepository).observablePokemonResponse(pokeId);
        verifyNoMoreInteractions(mockMainRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }

    @Test
    public void testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException.class);
        getPokemonInteractor.buildUseCaseObservable(null);
    }
}
