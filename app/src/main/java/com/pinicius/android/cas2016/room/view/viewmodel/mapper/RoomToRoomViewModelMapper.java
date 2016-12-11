package com.pinicius.android.cas2016.room.view.viewmodel.mapper;

import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomToRoomViewModelMapper {

    @Inject RoomToRoomViewModelMapper(){
    }

    public RoomViewModel map(Room room) {
        RoomViewModel roomViewModel = new RoomViewModel(room.getKey(), room.getName(), room.getCapacity());
        return roomViewModel;
    }

    public List<RoomViewModel> map(Collection<Room> rooms) {
        List<RoomViewModel> roomViewModels = new ArrayList<>();
        for (Room room : rooms) {
            roomViewModels.add(map(room));
        }
        return roomViewModels;
    }
}
