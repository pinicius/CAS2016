package com.pinicius.android.cas2016.speaker.repository.datasource.mapper;

import com.pinicius.android.cas2016.link.mapper.LinkDtoToLinkMapper;
import com.pinicius.android.cas2016.session.repository.datasource.mapper.SessionSummaryDtoToSessionSummaryMapper;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.casapiclient.model.SpeakerDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakerDtoToSpeakerMapper {

    private LinkDtoToLinkMapper linkMapper = new LinkDtoToLinkMapper();
    private SessionSummaryDtoToSessionSummaryMapper sessionMapper = new SessionSummaryDtoToSessionSummaryMapper();

    public Speaker map(SpeakerDto speakerDto) {
        Speaker speaker = new Speaker(speakerDto.getId(), speakerDto.getName(),
                speakerDto.getBiography(), speakerDto.getTwitterProfile(),
                speakerDto.getLinkedinPprofile(), speakerDto.getWeb(),
                speakerDto.getCountry(), speakerDto.getCity(),
                speakerDto.getImage(), linkMapper.map(speakerDto.getLinks()), sessionMapper.map(speakerDto.getSessions()));
        return speaker;
    }

    public List<Speaker> map(Collection<SpeakerDto> speakerDtos) {
        List<Speaker> speakers = new ArrayList<>();
        for (SpeakerDto speakerDto: speakerDtos) {
            speakers.add(map(speakerDto));
        }
        return speakers;
    }
}
