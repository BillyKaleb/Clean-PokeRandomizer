package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version GameIndex, v 0.1 13/03/19 15.32 by Billy Kaleb Hananto
 */
public class GameIndex {

    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;

    @SerializedName("version")
    @Expose
    private Version version;

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
