package com.pinicius.android.cas2016.room.view.viewmodel.mapper;

import com.pinicius.android.cas2016.room.domain.model.RoomSummary;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomSummaryViewModel;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class RoomSummaryToRoomSummaryViewModelMapper {
    @Inject public RoomSummaryToRoomSummaryViewModelMapper() {}

    public RoomSummaryViewModel map(RoomSummary room) {
        RoomSummaryViewModel roomViewModel = new RoomSummaryViewModel(room.getKey(), room.getName(), room.getCapacity());
        return roomViewModel;
    }
}
