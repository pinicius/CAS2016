package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pinicius on 26/11/16.
 */

public class TagDto {

    @SerializedName("name") private String name;
    @SerializedName("links") private List<LinkDto> links;

    public String getName() {
        return name;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "TagDto{"
                + "name='"
                + name
                + '\''
                + ", links="
                + links
                +
                '}';
    }
}
