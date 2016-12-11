package com.pinicius.android.cas2016.tag.view.viewmodel.mapper;

import com.pinicius.android.cas2016.link.view.viewmodel.LinkViewModel;
import com.pinicius.android.cas2016.link.view.viewmodel.mapper.LinkToLinkViewModelMapper;
import com.pinicius.android.cas2016.tag.domain.model.Tag;
import com.pinicius.android.cas2016.tag.view.viewmodel.TagViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class TagToTagViewModelMapper {

    private final LinkToLinkViewModelMapper linkToLinkViewModelMapper;

    @Inject
    TagToTagViewModelMapper(LinkToLinkViewModelMapper linkToLinkViewModelMapper) {
        this.linkToLinkViewModelMapper = linkToLinkViewModelMapper;
    }

    public TagViewModel map(Tag tag) {
        List<LinkViewModel> linkViewModels = linkToLinkViewModelMapper.map(tag.getLinks());
        TagViewModel tagViewModel = new TagViewModel(tag.getKey(), linkViewModels);
        return tagViewModel;
    }

    public List<TagViewModel> map(Collection<Tag> tags) {
        List<TagViewModel> tagViewModels = new ArrayList<>();
        for (Tag tag : tags) {
            TagViewModel tagViewModel = map(tag);
            tagViewModels.add(tagViewModel);
        }
        return tagViewModels;
    }
}