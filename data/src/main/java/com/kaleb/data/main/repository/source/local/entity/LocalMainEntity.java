package com.kaleb.data.main.repository.source.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version LocalMainEntity, v 0.1 14/03/19 10.03 by Billy Kaleb Hananto
 */
@Entity
public class LocalMainEntity {

    private int pokeHeight;

    @PrimaryKey
    private int pokeId;

    private String pokeName;

    private String pokeSpriteFront;

    private int pokeWeight;

    public LocalMainEntity() {
        //No Implementation
    }

    @Ignore
    public LocalMainEntity(int pokeHeight, int pokeId, String pokeName, String pokeSpriteFront,
        int pokeWeight) {
        this.pokeHeight = pokeHeight;
        this.pokeId = pokeId;
        this.pokeName = pokeName;
        this.pokeSpriteFront = pokeSpriteFront;
        this.pokeWeight = pokeWeight;
    }

    public int getPokeId() {
        return pokeId;
    }

    public void setPokeId(int pokeId) {
        this.pokeId = pokeId;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public int getPokeWeight() {
        return pokeWeight;
    }

    public void setPokeWeight(int pokeWeight) {
        this.pokeWeight = pokeWeight;
    }

    public int getPokeHeight() {
        return pokeHeight;
    }

    public void setPokeHeight(int pokeHeight) {
        this.pokeHeight = pokeHeight;
    }

    public String getPokeSpriteFront() {
        return pokeSpriteFront;
    }

    public void setPokeSpriteFront(String pokeSpriteFront) {
        this.pokeSpriteFront = pokeSpriteFront;
    }
}
