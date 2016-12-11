package com.pinicius.android.cas2016.tag.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;
import com.pinicius.android.cas2016.link.domain.model.Link;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class Tag implements Identifiable<String> {

    private final String name;
    private final List<Link> links;

    public Tag(String name, List<Link> links) {
        this.name = name;
        this.links = links;
    }

    @Override
    public String getKey() {
        return name;
    }

    public List<Link> getLinks() {
        return links;
    }
}
