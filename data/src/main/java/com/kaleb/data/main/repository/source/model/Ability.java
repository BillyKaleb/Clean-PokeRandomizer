package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version Ability, v 0.1 13/03/19 15.31 by Billy Kaleb Hananto
 */
public class Ability {

    @SerializedName("ability")
    @Expose
    private Ability_ ability;

    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;

    @SerializedName("slot")
    @Expose
    private Integer slot;

    public Ability_ getAbility() {
        return ability;
    }

    public void setAbility(Ability_ ability) {
        this.ability = ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
