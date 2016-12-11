package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pinicius on 26/11/16.
 */

public class SessionDto {

    @SerializedName("id") private int id;
    @SerializedName("title") private String title;
    @SerializedName("description") private String description;
    @SerializedName("duration") private int duration;
    @SerializedName("startTime") private String startTime;
    @SerializedName("endTime") private String endTime;
    @SerializedName("room") private RoomSummaryDto room;
    @SerializedName("speakers") private List<SpeakerSummaryDto> speakers;
    @SerializedName("tags") private List<TagDto> tags;
    @SerializedName("links") private List<LinkDto> links;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public RoomSummaryDto getRoom() {
        return room;
    }

    public List<SpeakerSummaryDto> getSpeakers() {
        return speakers;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "SessionDto{"
                + "id='"
                + id
                + '\''
                + ", title='"
                + title
                + '\''
                + ", description='"
                + description
                + '\''
                + ", duration='"
                + duration
                + '\''
                + ", startTime='"
                +startTime
                + '\''
                + ", endTime='"
                + endTime
                + '\''
                + ", speakers="
                + speakers
                + '\''
                + ", tags="
                + tags
                + '\''
                + ", links="
                + links
                +
                '}';
    }
}
