package com.kaleb.clean_pokerandomizer.main;

import com.kaleb.clean_pokerandomizer.base.AbstractContract;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version MainContract, v 0.1 13/03/19 09.34 by Billy Kaleb Hananto
 */
public interface MainContract {

    interface View extends AbstractContract.AbstractView {

        void setText(String name, int id, int height, int weight);

        void displayImage(String url);
    }

    interface Presenter extends AbstractContract.AbstractPresenter {

        void getFromData(int pokeId);

        void getRandomPokemonFromData();
    }
}
