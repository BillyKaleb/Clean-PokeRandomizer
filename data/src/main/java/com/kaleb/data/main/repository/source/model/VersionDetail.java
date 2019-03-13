package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version VersionDetail, v 0.1 13/03/19 15.37 by Billy Kaleb Hananto
 */
public class VersionDetail {

    @SerializedName("rarity")
    @Expose
    private Integer rarity;

    @SerializedName("version")
    @Expose
    private Version_ version;

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Version_ getVersion() {
        return version;
    }

    public void setVersion(Version_ version) {
        this.version = version;
    }
}
