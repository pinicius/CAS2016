package com.pinicius.android.cas2016.session.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;
import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.cas2016.room.domain.model.RoomSummary;
import com.pinicius.android.cas2016.speaker.domain.model.SpeakerSummary;
import com.pinicius.android.cas2016.tag.domain.model.Tag;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class Session implements Identifiable<Integer> {

    private final int id;
    private final String name;
    private final String description;
    private final int duration;
    private final String startTime;
    private final String endTime;
    private final RoomSummary room;
    private final List<SpeakerSummary> speakers;
    private final List<Tag> tags;
    private final List<Link> links;

    public Session(int id, String name,
                   String description, int duration,
                   String startTime, String endTime,
                   RoomSummary room, List<SpeakerSummary> speakers,
                   List<Tag> tags, List<Link> links) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.speakers = speakers;
        this.tags = tags;
        this.links = links;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String getName() {
        return name;
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

    public RoomSummary getRoom() {
        return room;
    }

    public List<SpeakerSummary> getSpeakers() {
        return speakers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Link> getLinks() {
        return links;
    }
}

