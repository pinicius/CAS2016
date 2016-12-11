package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SessionDto;

import java.util.Collection;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by pinicius on 26/11/16.
 */

public interface SessionApiRest {

    @GET("sessions") Call<Collection<SessionDto>> getAllSessions();

    @GET("sessions/{id}") Call<SessionDto> getSession(@Path("id") int sessionId);

    @GET("sessions/{date}") Call<Collection<SessionDto>> getSessionsByDate(@Path("date") String date);
}
