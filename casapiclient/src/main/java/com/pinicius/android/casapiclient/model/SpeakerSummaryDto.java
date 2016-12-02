package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pinicius on 26/11/16.
 */

public class SpeakerSummaryDto {

    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("lastName") private String lastName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "SpeakerSummaryDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + '\''
                + ", lastname='"
                + lastName
                +
                '}';
    }
}
