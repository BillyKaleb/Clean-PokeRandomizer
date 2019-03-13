package com.kaleb.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version Source, v 0.1 13/03/19 11.41 by Billy Kaleb Hananto
 */

@StringDef({Source.LOCAL, Source.NETWORK, Source.MOCK})
@Retention(RetentionPolicy.SOURCE)
public @interface Source {

    String LOCAL = "local";

    String NETWORK = "network";

    String MOCK = "mock";
}

