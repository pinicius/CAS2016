package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SessionDto;
import com.pinicius.android.casapiclient.model.TagDto;

import java.util.Collection;

import retrofit.Call;

/**
 * Created by pinicius on 26/11/16.
 */

public class TagApiClient extends CASApiClient {

    public TagApiClient(CASApiConfig casApiConfig) {
        super(casApiConfig);
    }

    public Collection<TagDto> getAll() throws CASApiException {
        TagApiRest api = getApi(TagApiRest.class);
        Call<Collection<TagDto>> call = api.getAllTags();
        return execute(call);
    }

    public Collection<SessionDto> getTagSessions(String tagName) throws CASApiException {
        TagApiRest api = getApi(TagApiRest.class);
        Call<Collection<SessionDto>> call = api.getTagSessions(tagName);
        return execute(call);
    }
}
