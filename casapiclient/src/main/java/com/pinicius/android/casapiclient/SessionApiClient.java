package com.pinicius.android.casapiclient;

import com.pinicius.android.casapiclient.model.SessionDto;

import java.util.Collection;

import retrofit.Call;

/**
 * Created by pinicius on 26/11/16.
 */

public class SessionApiClient extends CASApiClient {

    public SessionApiClient(CASApiConfig casApiConfig) {
        super(casApiConfig);
    }

    public Collection<SessionDto> getAll() throws CASApiException {
        SessionApiRest api = getApi(SessionApiRest.class);
        Call<Collection<SessionDto>> call = api.getAllSessions();
        return  execute(call);
    }

    public SessionDto getSession(int sessionId) throws CASApiException {
        SessionApiRest apiRest = getApi(SessionApiRest.class);
        Call<SessionDto> call = apiRest.getSession(sessionId);
        return execute(call);
    }

    public Collection<SessionDto> getSessionsByDate(String date) throws CASApiException {
        SessionApiRest apiRest = getApi(SessionApiRest.class);
        Call<Collection<SessionDto>> call = apiRest.getSessionsByDate(date);
        return execute(call);
    }
}
