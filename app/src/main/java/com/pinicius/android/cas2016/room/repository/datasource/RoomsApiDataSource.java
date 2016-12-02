package com.pinicius.android.cas2016.room.repository.datasource;

import com.karumi.rosie.repository.datasource.EmptyReadableDataSource;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.repository.datasource.mapper.RoomDtoToRoomMapper;
import com.pinicius.android.casapiclient.RoomApiClient;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class RoomsApiDataSource extends EmptyReadableDataSource<Integer, Room> {
    private final RoomApiClient roomApiClient;
    private final RoomDtoToRoomMapper roomMapper;

    @Inject public RoomsApiDataSource(RoomApiClient roomApiClient, RoomDtoToRoomMapper roomMapper) {
        this.roomApiClient = roomApiClient;
        this.roomMapper = roomMapper;
    }

    @Override
    public Collection<Room> getAll() throws Exception {
        return roomMapper.map(roomApiClient.getAll());
    }

    @Override
    public Room getByKey(Integer key) throws Exception {
        return roomMapper.map(roomApiClient.getRoom(key));
    }
}
