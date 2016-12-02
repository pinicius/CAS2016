package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pinicius on 26/11/16.
 */

public class RoomSummaryDto {

    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("capacity") private int capacity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "RoomSummaryDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + '\''
                + ", capacity='"
                + capacity
                +
                '}';
    }
}
