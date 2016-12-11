package com.pinicius.android.cas2016.room.repository;

import com.pinicius.android.cas2016.room.repository.datasource.RoomsApiDataSource;
import com.pinicius.android.cas2016.room.repository.datasource.mapper.RoomDtoToRoomMapper;
import com.pinicius.android.casapiclient.CASApiConfig;
import com.pinicius.android.casapiclient.RoomApiClient;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomsDataSourceFactory {
    private RoomDtoToRoomMapper roomMapper = new RoomDtoToRoomMapper();

    @Inject public RoomsDataSourceFactory() {}

    RoomsApiDataSource createDataSource() {
        RoomApiClient roomApiClient = new RoomApiClient(CASApiConfig.get());
        return new RoomsApiDataSource(roomApiClient, roomMapper);
    }
}
