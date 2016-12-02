package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.RoomDto;

import java.util.Collection;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by pinicius on 26/11/16.
 */

public interface RoomApiRest {
    @GET("rooms") Call<Collection<RoomDto>> getAllRooms();

    @GET("rooms/{id}") Call<RoomDto> getRoom(@Path("id") int roomId);
}
