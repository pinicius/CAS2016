package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pinicius on 26/11/16.
 */

public class LinkDto {

    @SerializedName("href") private String href;
    @SerializedName("rel") private String rel;

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }

    @Override
    public String toString() {
        return "LinkDto{"
                + "href='"
                + href
                + '\''
                + ", rel='"
                + rel
                +
                '}';
    }
}
