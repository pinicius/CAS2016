package com.pinicius.android.cas2016.tag.repository.datasource.mapper;

import com.pinicius.android.cas2016.link.mapper.LinkDtoToLinkMapper;
import com.pinicius.android.cas2016.tag.domain.model.Tag;
import com.pinicius.android.casapiclient.model.TagDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class TagDtoToTagMapper {

    private LinkDtoToLinkMapper linkMapper = new LinkDtoToLinkMapper();

    public Tag map(TagDto tagDto) {
        Tag tag = new Tag(tagDto.getName(), linkMapper.map(tagDto.getLinks()));
        return tag;
    }

    public List<Tag> map(Collection<TagDto> tagDtos) {
        List<Tag> tags = new ArrayList<>();
        for (TagDto tagDto : tagDtos) {
            Tag tag = new Tag(tagDto.getName(), linkMapper.map(tagDto.getLinks()));
            tags.add(tag);
        }
        return tags;
    }
}
