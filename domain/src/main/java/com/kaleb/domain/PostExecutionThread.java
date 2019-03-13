package com.kaleb.domain;

import io.reactivex.Scheduler;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version PostExecutionThread, v 0.1 13/03/19 11.06 by Billy Kaleb Hananto
 */
public interface PostExecutionThread {

    Scheduler getScheduler();
}
