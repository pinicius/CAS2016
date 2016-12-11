package com.pinicius.android.cas2016.room.repository.datasource.mapper;

import com.pinicius.android.cas2016.link.mapper.LinkDtoToLinkMapper;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.session.repository.datasource.mapper.SessionSummaryDtoToSessionSummaryMapper;
import com.pinicius.android.casapiclient.model.RoomDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomDtoToRoomMapper {

    private LinkDtoToLinkMapper linkMapper =
            new LinkDtoToLinkMapper();
    private SessionSummaryDtoToSessionSummaryMapper sessionMapper =
            new SessionSummaryDtoToSessionSummaryMapper();

    public Room map(RoomDto roomDto) {
        Room room = new Room(roomDto.getId(), roomDto.getName(),
                roomDto.getCapacity(), linkMapper.map(roomDto.getLinks()),
                sessionMapper.map(roomDto.getSessions()));
        return room;
    }

    public List<Room> map(Collection<RoomDto> roomDtos) {
        List<Room> rooms = new ArrayList<>();
        for(RoomDto roomDto : roomDtos) {
            rooms.add(map(roomDto));
        }
        return rooms;
    }
}
