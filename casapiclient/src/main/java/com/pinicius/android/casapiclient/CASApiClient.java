package com.pinicius.android.casapiclient;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit.Call;
import retrofit.Response;

/**
 * Created by pinicius on 26/11/16.
 */

public class CASApiClient {

    private final CASApiConfig casApiConfig;

    public CASApiClient(CASApiConfig casApiConfig) {
        this.casApiConfig = casApiConfig;
    }

    <T> T getApi(Class<T> apiRest) {
        return casApiConfig.getRetrofit().create(apiRest);
    }

    public <T> T execute(Call<T> call) throws CASApiException {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CASApiException("Network error!", e.getCause());
        }
        if (response.isSuccess()) {
            return response.body();
        } else {
            parseError(response);
            return null;
        }
    }

    private void parseError(Response execute) throws CASApiException {
        String description = "";
        if(execute.errorBody() != null) {
            Gson gson = new Gson();
            try {
                String errorBody = execute.errorBody().string();
                CASError casError = gson.fromJson(errorBody, CASError.class);
                description = casError.getMessage();
            } catch (IOException e) {

            }
            throw new CASApiException(description, null);

        }
    }
}