package com.pinicius.android.cas2016.link.view.viewmodel;

/**
 * Created by pinicius on 28/11/16.
 */

public class LinkViewModel {

    private final String href;
    private final String rel;

    public LinkViewModel(String href, String rel) {
        this.href = href;
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }
}
