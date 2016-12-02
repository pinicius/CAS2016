package com.pinicius.android.cas2016.session.view.viewmodel;

import com.pinicius.android.cas2016.link.domain.model.Link;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionSummaryViewModel {
    private final int id;
    private final String name;
    private final List<Link> links;

    public SessionSummaryViewModel(int id, String name, List<Link> links) {
        this.id = id;
        this.name = name;
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Link> getLinks() {
        return links;
    }
}
