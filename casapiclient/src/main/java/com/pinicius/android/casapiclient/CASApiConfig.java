package com.pinicius.android.casapiclient;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by pinicius on 26/11/16.
 */

public class CASApiConfig {

    private static CASApiConfig singleton;
    private final boolean debug;
    private final Retrofit retrofit;

    CASApiConfig(Retrofit retrofit, boolean debug) {
        this.retrofit = retrofit;
        this.debug = debug;
    }

    public static CASApiConfig get() {
        if (singleton == null) {
            singleton = new Builder().build();
        }
        return singleton;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class Builder {

        private static final String CAS_API_BASE_URL = "http://cas2016api.azurewebsites.net/";
        private boolean debug;
        private Retrofit retrofit;
        private String baseUrl = CAS_API_BASE_URL;

        public Builder() {}

        public Builder baserUrl(String baseURl) {
            this.baseUrl = baseURl;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Builder retrofit(Retrofit retrofit) {
            if(retrofit == null) {
                throw new IllegalArgumentException("retrofit must not be null");
            }
            this.retrofit = retrofit;
            return this;
        }

        public CASApiConfig build() {
            if(retrofit == null) {
                retrofit = createDefaultRetrofit(baseUrl, debug);
            }
            return new CASApiConfig(retrofit, debug);
        }

        private Retrofit createDefaultRetrofit(String baseUrl, boolean debug) {
            OkHttpClient client = new OkHttpClient();
            if (debug) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                client.interceptors().add(interceptor);
            }

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        }
    }
}