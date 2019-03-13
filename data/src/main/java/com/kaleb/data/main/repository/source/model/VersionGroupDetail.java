package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version VersionGroupDetail, v 0.1 13/03/19 15.38 by Billy Kaleb Hananto
 */
public class VersionGroupDetail {

    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;

    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;

    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }
}
