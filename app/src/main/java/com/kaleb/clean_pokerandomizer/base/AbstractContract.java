package com.kaleb.clean_pokerandomizer.base;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version AbstractContract, v 0.1 12/03/19 14.46 by Billy Kaleb Hananto
 */
public interface AbstractContract {

    interface AbstractView {

        void showProgress();

        void dismissProgress();

        void onError(String errorMessage);

    }

    interface AbstractPresenter {

        void onDestroy();

    }
}
