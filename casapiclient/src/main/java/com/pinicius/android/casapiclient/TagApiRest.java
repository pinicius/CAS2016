package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SessionDto;
import com.pinicius.android.casapiclient.model.TagDto;

import java.util.Collection;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by pinicius on 26/11/16.
 */

public interface TagApiRest {
    @GET("tags") Call<Collection<TagDto>> getAllTags();

    @GET("sessions/tags/{name}") Call<Collection<SessionDto>> getTagSessions(@Path("name") String tagName);
}
