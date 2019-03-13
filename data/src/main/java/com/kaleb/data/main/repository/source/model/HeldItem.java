package com.kaleb.data.main.repository.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version HeldItem, v 0.1 13/03/19 15.33 by Billy Kaleb Hananto
 */
public class HeldItem {

    @SerializedName("item")
    @Expose
    private Item item;

    @SerializedName("version_details")
    @Expose
    private List<VersionDetail> versionDetails = null;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<VersionDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<VersionDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }
}
