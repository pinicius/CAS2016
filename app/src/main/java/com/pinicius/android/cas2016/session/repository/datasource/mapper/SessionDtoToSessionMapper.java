package com.pinicius.android.cas2016.session.repository.datasource.mapper;

import com.pinicius.android.cas2016.link.mapper.LinkDtoToLinkMapper;
import com.pinicius.android.cas2016.room.repository.datasource.mapper.RoomSummaryDtoToRoomSummaryMapper;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.speaker.repository.datasource.mapper.SpeakerSummaryDtoToSpeakerSummaryMapper;
import com.pinicius.android.cas2016.tag.repository.datasource.mapper.TagDtoToTagMapper;
import com.pinicius.android.casapiclient.model.SessionDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionDtoToSessionMapper {
    private RoomSummaryDtoToRoomSummaryMapper roomMapper = new RoomSummaryDtoToRoomSummaryMapper();
    private SpeakerSummaryDtoToSpeakerSummaryMapper speakerMapper = new SpeakerSummaryDtoToSpeakerSummaryMapper();
    private LinkDtoToLinkMapper linkMapper = new LinkDtoToLinkMapper();
    private TagDtoToTagMapper tagMapper = new TagDtoToTagMapper();

    public Session map(SessionDto sessionDto) {
        Session session = new Session(sessionDto.getId(), sessionDto.getTitle(),
                sessionDto.getDescription(), sessionDto.getDuration(), sessionDto.getStartTime(),
                sessionDto.getEndTime(), roomMapper.map(sessionDto.getRoom()), speakerMapper.map(sessionDto.getSpeakers()),
                tagMapper.map(sessionDto.getTags()), linkMapper.map(sessionDto.getLinks()));
        return session;
    }

    public List<Session> map(Collection<SessionDto> sessionDtos) {
        List<Session> sessions = new ArrayList<>();
        for (SessionDto sessionDto: sessionDtos) {
            sessions.add(map(sessionDto));
        }
        return sessions;
    }
}
