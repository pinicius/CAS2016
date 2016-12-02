package com.pinicius.android.cas2016.speaker.repository;

import com.pinicius.android.cas2016.speaker.repository.datasource.SpeakersApiDataSource;
import com.pinicius.android.cas2016.speaker.repository.datasource.mapper.SpeakerDtoToSpeakerMapper;
import com.pinicius.android.casapiclient.CASApiConfig;
import com.pinicius.android.casapiclient.SpeakerApiClient;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakersDataSourceFactory {
    private SpeakerDtoToSpeakerMapper mapper = new SpeakerDtoToSpeakerMapper();

    @Inject SpeakersDataSourceFactory() {
    }

    SpeakersApiDataSource createDataSource() {
        SpeakerApiClient apiClient = new SpeakerApiClient(CASApiConfig.get());
        return new SpeakersApiDataSource(apiClient, mapper);
    }
}
