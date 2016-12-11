package com.pinicius.android.cas2016.link.view.viewmodel.mapper;

import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.cas2016.link.view.viewmodel.LinkViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class LinkToLinkViewModelMapper {

    @Inject public LinkToLinkViewModelMapper() {
    }

    public LinkViewModel map(Link link) {
        LinkViewModel linkViewModel = new LinkViewModel(link.getHref(), link.getRel());
        return linkViewModel;
    }

    public List<LinkViewModel> map(Collection<Link> links) {
        List<LinkViewModel> linkViewModels = new ArrayList<>();
        for (Link link : links) {
            LinkViewModel linkViewModel = map(link);
            linkViewModels.add(linkViewModel);
        }
        return linkViewModels;
    }
}
