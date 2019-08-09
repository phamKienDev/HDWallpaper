
package com.hlub.dev.assandroidnet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content_ {

    @SerializedName("rendered")
    @Expose
    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

}
