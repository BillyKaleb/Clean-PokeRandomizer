package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version Stat, v 0.1 13/03/19 15.36 by Billy Kaleb Hananto
 */
public class Stat {

    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;

    @SerializedName("effort")
    @Expose
    private Integer effort;

    @SerializedName("stat")
    @Expose
    private Stat_ stat;

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Stat_ getStat() {
        return stat;
    }

    public void setStat(Stat_ stat) {
        this.stat = stat;
    }
}
