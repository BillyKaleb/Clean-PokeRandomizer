package com.kaleb.data;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version AbstractEntityDataFactory, v 0.1 13/03/19 12.42 by Billy Kaleb Hananto
 */
public abstract class AbstractEntityDataFactory<T> {

    public abstract T createData(@Source String source);
}
