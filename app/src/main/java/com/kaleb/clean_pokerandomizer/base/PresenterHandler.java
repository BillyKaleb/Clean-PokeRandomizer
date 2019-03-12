package com.kaleb.clean_pokerandomizer.base;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version PresenterHandler, v 0.1 12/03/19 14.56 by Billy Kaleb Hananto
 */
public interface PresenterHandler {

    void registerPresenter(AbstractContract.AbstractPresenter... presenters);

    void disposePresenter();
}
