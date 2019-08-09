
package com.hlub.dev.assandroidnet.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded {

    @SerializedName("author")
    @Expose
    private List<Author_> author = null;
    @SerializedName("replies")
    @Expose
    private List<List<Reply_>> replies = null;
    @SerializedName("wp:featuredmedia")
    @Expose
    private List<WpFeaturedmedium_> wpFeaturedmedia = null;
    @SerializedName("wp:term")
    @Expose
    private List<List<WpTerm_>> wpTerm = null;

    public List<Author_> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author_> author) {
        this.author = author;
    }

    public List<List<Reply_>> getReplies() {
        return replies;
    }

    public void setReplies(List<List<Reply_>> replies) {
        this.replies = replies;
    }

    public List<WpFeaturedmedium_> getWpFeaturedmedia() {
        return wpFeaturedmedia;
    }

    public void setWpFeaturedmedia(List<WpFeaturedmedium_> wpFeaturedmedia) {
        this.wpFeaturedmedia = wpFeaturedmedia;
    }

    public List<List<WpTerm_>> getWpTerm() {
        return wpTerm;
    }

    public void setWpTerm(List<List<WpTerm_>> wpTerm) {
        this.wpTerm = wpTerm;
    }

}
