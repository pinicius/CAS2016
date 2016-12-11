package com.pinicius.android.cas2016.session.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;
import com.pinicius.android.cas2016.link.domain.model.Link;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionSummary implements Identifiable<Integer> {

    private final int id;
    private final String name;
    private final List<Link> links;

    public SessionSummary(int id, String name, List<Link> links) {
        this.id = id;
        this.name = name;
        this.links = links;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Link> getLinks() {
        return links;
    }
}
