
package com.hlub.dev.assandroidnet.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links____ {

    @SerializedName("self")
    @Expose
    private List<Self____> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection____> collection = null;
    @SerializedName("about")
    @Expose
    private List<About__> about = null;
    @SerializedName("wp:post_type")
    @Expose
    private List<WpPostType> wpPostType = null;
    @SerializedName("curies")
    @Expose
    private List<Cury_> curies = null;

    public List<Self____> getSelf() {
        return self;
    }

    public void setSelf(List<Self____> self) {
        this.self = self;
    }

    public List<Collection____> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection____> collection) {
        this.collection = collection;
    }

    public List<About__> getAbout() {
        return about;
    }

    public void setAbout(List<About__> about) {
        this.about = about;
    }

    public List<WpPostType> getWpPostType() {
        return wpPostType;
    }

    public void setWpPostType(List<WpPostType> wpPostType) {
        this.wpPostType = wpPostType;
    }

    public List<Cury_> getCuries() {
        return curies;
    }

    public void setCuries(List<Cury_> curies) {
        this.curies = curies;
    }

}
