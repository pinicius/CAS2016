package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SpeakerDto;

import java.util.Collection;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by pinicius on 26/11/16.
 */

public interface SpeakerApiRest {
    @GET("speakers") Call<Collection<SpeakerDto>> getAllSpeakers();

    @GET("speakers/{id}") Call<SpeakerDto> getSpeaker(@Path("id") int speakerId);
}
