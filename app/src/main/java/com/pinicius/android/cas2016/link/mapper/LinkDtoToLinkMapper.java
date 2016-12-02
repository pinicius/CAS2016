package com.pinicius.android.cas2016.link.mapper;

import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.casapiclient.model.LinkDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class LinkDtoToLinkMapper {
    public Link map(LinkDto linkDto) {
        Link link = new Link(linkDto.getHref(), linkDto.getRel());
        return link;
    }

    public List<Link> map(Collection<LinkDto> linkDtos) {
        List<Link> links = new ArrayList<>();
        for (LinkDto linkDto : linkDtos) {
            links.add(map(linkDto));
        }
        return links;
    }
}
