package com.kaleb.data.main.repository.source.local.dao;

import com.kaleb.data.main.repository.source.local.entity.LocalMainEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version LocalMainDao, v 0.1 14/03/19 10.10 by Billy Kaleb Hananto
 */
@Dao
public interface LocalMainDao {

    @Insert
    Long insertLocalMain(LocalMainEntity localMainEntity);

    @Query("SELECT * FROM LocalMainEntity WHERE pokeId = :pokeId")
    LocalMainEntity getLocalMainEntity(int pokeId);

    @Update
    int updateLocalMain(LocalMainEntity localMainEntity);
}
