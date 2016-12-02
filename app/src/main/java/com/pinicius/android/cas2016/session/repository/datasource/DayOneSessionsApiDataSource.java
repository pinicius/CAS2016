package com.pinicius.android.cas2016.session.repository.datasource;

import com.karumi.rosie.repository.datasource.EmptyReadableDataSource;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.datasource.mapper.SessionDtoToSessionMapper;
import com.pinicius.android.casapiclient.SessionApiClient;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayOneSessionsApiDataSource extends EmptyReadableDataSource<Integer, Session> {
    private static final String DAY_ONE_DATE = "2016-12-1";

    private final SessionApiClient sessionApiClient;
    private final SessionDtoToSessionMapper sessionDtoToSessionMapper;

    @Inject
    public DayOneSessionsApiDataSource(SessionApiClient sessionApiClient, SessionDtoToSessionMapper sessionDtoToSessionMapper) {
        this.sessionApiClient = sessionApiClient;
        this.sessionDtoToSessionMapper = sessionDtoToSessionMapper;
    }

    @Override
    public Collection<Session> getAll() throws Exception {
        return sessionDtoToSessionMapper.map(sessionApiClient.getSessionsByDate(DAY_ONE_DATE));
    }

    @Override
    public Session getByKey(Integer key) throws Exception {
        return sessionDtoToSessionMapper.map(sessionApiClient.getSession(key));
    }
}
