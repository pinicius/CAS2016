package com.pinicius.android.cas2016.session.repository;

import com.karumi.rosie.repository.RosieRepository;
import com.karumi.rosie.repository.datasource.ReadableDataSource;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.datasource.cache.DayTwoSessionsInMemoryCache;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayTwoSessionsRepository extends RosieRepository<Integer, Session> {

    @Inject
    public DayTwoSessionsRepository(DayTwoSessionsDataSourceFactory dayTwoSessionsDataSourceFactory,
                                    DayTwoSessionsInMemoryCache inMemoryCache) {
        ReadableDataSource<Integer, Session> dayTwoSessionsDataSource = dayTwoSessionsDataSourceFactory.createDataSource();
        addReadableDataSources(dayTwoSessionsDataSource);
        addCacheDataSources(inMemoryCache);
    }
}
