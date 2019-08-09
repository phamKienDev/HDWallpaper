
package com.hlub.dev.assandroidnet.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private List<Self__> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection__> collection = null;
    @SerializedName("author")
    @Expose
    private List<Author__> author = null;
    @SerializedName("up")
    @Expose
    private List<Up> up = null;
    @SerializedName("in-reply-to")
    @Expose
    private List<InReplyTo> inReplyTo = null;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;

    public List<Self__> getSelf() {
        return self;
    }

    public void setSelf(List<Self__> self) {
        this.self = self;
    }

    public List<Collection__> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection__> collection) {
        this.collection = collection;
    }

    public List<Author__> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author__> author) {
        this.author = author;
    }

    public List<Up> getUp() {
        return up;
    }

    public void setUp(List<Up> up) {
        this.up = up;
    }

    public List<InReplyTo> getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(List<InReplyTo> inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

}
