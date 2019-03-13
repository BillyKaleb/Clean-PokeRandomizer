package com.kaleb.clean_pokerandomizer;

import com.kaleb.domain.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version UIThread, v 0.1 13/03/19 13.41 by Billy Kaleb Hananto
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
