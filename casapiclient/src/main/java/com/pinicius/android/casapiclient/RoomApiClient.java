package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.RoomDto;

import java.util.Collection;

import retrofit.Call;

/**
 * Created by pinicius on 26/11/16.
 */

public class RoomApiClient extends CASApiClient {

    public RoomApiClient(CASApiConfig casApiConfig) {
        super(casApiConfig);
    }

    public Collection<RoomDto> getAll() throws CASApiException {
        RoomApiRest api = getApi(RoomApiRest.class);
        Call<Collection<RoomDto>> call = api.getAllRooms();
        return execute(call);
    }

    public RoomDto getRoom(int roomId) throws CASApiException {
        RoomApiRest api = getApi(RoomApiRest.class);
        Call<RoomDto> call = api.getRoom(roomId);
        return execute(call);
    }
}
