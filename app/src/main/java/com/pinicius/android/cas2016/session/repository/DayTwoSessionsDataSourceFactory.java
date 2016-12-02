package com.pinicius.android.cas2016.session.repository;

import com.karumi.rosie.repository.datasource.ReadableDataSource;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.datasource.DayTwoSessionsApiDataSource;
import com.pinicius.android.cas2016.session.repository.datasource.mapper.SessionDtoToSessionMapper;
import com.pinicius.android.casapiclient.CASApiConfig;
import com.pinicius.android.casapiclient.SessionApiClient;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayTwoSessionsDataSourceFactory {
    private SessionDtoToSessionMapper sessionDtoToSessionMapper = new SessionDtoToSessionMapper();

    @Inject
    public DayTwoSessionsDataSourceFactory() {}

    ReadableDataSource<Integer, Session> createDataSource() {
        SessionApiClient sessionApiClient = new SessionApiClient(CASApiConfig.get());
        return new DayTwoSessionsApiDataSource(sessionApiClient, sessionDtoToSessionMapper);
    }
}