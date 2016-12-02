package com.pinicius.android.cas2016.room.view.viewmodel.mapper;

import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomDetailsViewModel;
import com.pinicius.android.cas2016.session.view.viewmodel.mapper.SessionSummaryToSessionSummaryViewModelMapper;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomToRoomDetailsViewModelMapper {

    private final SessionSummaryToSessionSummaryViewModelMapper mapper;

    @Inject RoomToRoomDetailsViewModelMapper(SessionSummaryToSessionSummaryViewModelMapper mapper){
        this.mapper = mapper;
    }

    public RoomDetailsViewModel map(Room room) {
        return new RoomDetailsViewModel(room.getKey(), room.getName(), room.getCapacity(), mapper.map(room.getSessions()));
    }
}
