package com.pinicius.android.cas2016.room.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;
import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.cas2016.session.domain.model.SessionSummary;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class Room implements Identifiable<Integer> {

    private final int id;
    private final String name;
    private final int capacity;
    private List<Link> links;
    private List<SessionSummary> sessions;

    public Room(int id, String name, int capacity, List<Link> links, List<SessionSummary> sessions) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.links = links;
        this.sessions = sessions;
    }
    @Override
    public Integer getKey() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Link> getLinks() {
        return links;
    }

    public List<SessionSummary> getSessions() {
        return sessions;
    }
}

