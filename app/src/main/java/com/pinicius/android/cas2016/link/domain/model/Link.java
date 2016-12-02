package com.pinicius.android.cas2016.link.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;

/**
 * Created by pinicius on 28/11/16.
 */

public class Link implements Identifiable<String> {

    private final String href;
    private final String rel;

    public Link(String href, String rel) {
        this.href = href;
        this.rel = rel;
    }

    @Override
    public String getKey() {
        return href;
    }

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }
}
