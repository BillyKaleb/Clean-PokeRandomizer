package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version Move, v 0.1 13/03/19 15.33 by Billy Kaleb Hananto
 */
public class Move {

    @SerializedName("move")
    @Expose
    private Move_ move;

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = null;

    public Move_ getMove() {
        return move;
    }

    public void setMove(Move_ move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }
}
