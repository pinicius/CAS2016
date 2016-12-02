package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pinicius on 26/11/16.
 */

public class RoomDto {
    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("capacity") private int capacity;
    @SerializedName("links") private List<LinkDto> links;
    @SerializedName("sessions") private List<SessionSummaryDto> sessions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public List<SessionSummaryDto> getSessions() {
        return sessions;
    }

    @Override
    public String toString() {
        return "RoomDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + '\''
                + ", capacity='"
                + capacity
                + '\''
                + ", links="
                + links
                + '\''
                + ", sessions (summary)="
                + sessions
                +
                '}';
    }
}
