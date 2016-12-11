package com.pinicius.android.cas2016.room.repository.datasource.mapper;

import com.pinicius.android.cas2016.room.domain.model.RoomSummary;
import com.pinicius.android.casapiclient.model.RoomSummaryDto;

/**
 * Created by pinicius on 28/11/16.
 */

public class RoomSummaryDtoToRoomSummaryMapper {
    public RoomSummary map(RoomSummaryDto roomSummaryDto) {
        RoomSummary roomSummary =
                new RoomSummary(roomSummaryDto.getId(), roomSummaryDto.getName(), roomSummaryDto.getCapacity());
        return roomSummary;
    }
}
