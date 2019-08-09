
package com.hlub.dev.assandroidnet.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links___ {

    @SerializedName("self")
    @Expose
    private List<Self___> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection___> collection = null;
    @SerializedName("about")
    @Expose
    private List<About_> about = null;
    @SerializedName("author")
    @Expose
    private List<Author___> author = null;
    @SerializedName("replies")
    @Expose
    private List<Reply__> replies = null;

    public List<Self___> getSelf() {
        return self;
    }

    public void setSelf(List<Self___> self) {
        this.self = self;
    }

    public List<Collection___> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection___> collection) {
        this.collection = collection;
    }

    public List<About_> getAbout() {
        return about;
    }

    public void setAbout(List<About_> about) {
        this.about = about;
    }

    public List<Author___> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author___> author) {
        this.author = author;
    }

    public List<Reply__> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply__> replies) {
        this.replies = replies;
    }

}
