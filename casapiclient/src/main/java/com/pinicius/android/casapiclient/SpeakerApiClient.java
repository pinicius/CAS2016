package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SpeakerDto;

import java.util.Collection;

import retrofit.Call;

/**
 * Created by pinicius on 26/11/16.
 */

public class SpeakerApiClient extends CASApiClient {

    public SpeakerApiClient(CASApiConfig casApiConfig) {
        super(casApiConfig);
    }

    public Collection<SpeakerDto> getAll() throws CASApiException {
        SpeakerApiRest api = getApi(SpeakerApiRest.class);
        Call<Collection<SpeakerDto>> call = api.getAllSpeakers();
        return  execute(call);
    }

    public SpeakerDto getSpeaker(int speakerId) throws CASApiException {
        SpeakerApiRest apiRest = getApi(SpeakerApiRest.class);
        Call<SpeakerDto> call = apiRest.getSpeaker(speakerId);
        return execute(call);
    }
}
