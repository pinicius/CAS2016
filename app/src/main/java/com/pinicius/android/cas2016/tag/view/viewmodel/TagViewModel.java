package com.pinicius.android.cas2016.tag.view.viewmodel;

import com.pinicius.android.cas2016.link.view.viewmodel.LinkViewModel;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class TagViewModel {

    private final String name;
    private final List<LinkViewModel> links;

    public TagViewModel(String name, List<LinkViewModel> links) {
        this.name = name;
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public List<LinkViewModel> getLinks() {
        return links;
    }
}
