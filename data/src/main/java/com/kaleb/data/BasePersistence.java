package com.kaleb.data;

import android.content.Context;

import androidx.room.Room;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version BasePersistence, v 0.1 14/03/19 10.22 by Billy Kaleb Hananto
 */
public class BasePersistence {

    private static final String DB_NAME = "DB-" + BuildConfig.APPLICATION_ID + "-" + BuildConfig
        .FLAVOR;

    private BasePersistenceDao basePersistanceDao;

    private Context context;

    public BasePersistence(Context context) {
        this.context = context;
    }

    public BasePersistenceDao getDb() {
        if (basePersistanceDao == null) {
            init();
        }
        return basePersistanceDao;
    }

    private void init() {
        basePersistanceDao = Room.databaseBuilder(context, BasePersistenceDao.class, DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
    }
}
