package com.kaleb.data;

import com.kaleb.data.main.repository.source.local.dao.LocalMainDao;
import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version BasePersistenceDao, v 0.1 14/03/19 10.22 by Billy Kaleb Hananto
 */
@Database(entities = {LocalMainEntity.class}, version = 2, exportSchema = false)
public abstract class BasePersistenceDao extends RoomDatabase {

    public abstract LocalMainDao localMainDao();
}
