package com.pinicius.android.cas2016.session.repository;

import com.karumi.rosie.repository.RosieRepository;
import com.karumi.rosie.repository.datasource.ReadableDataSource;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.datasource.cache.DayOneSessionsInMemoryCache;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayOneSessionsRepository extends RosieRepository<Integer, Session> {

    @Inject public DayOneSessionsRepository(DayOneSessionsDataSourceFactory dayOneSessionsDataSourceFactory,
                                            DayOneSessionsInMemoryCache inMemoryCache) {
        ReadableDataSource<Integer, Session> dayOneSessionsDataSource = dayOneSessionsDataSourceFactory.createDataSource();
        addReadableDataSources(dayOneSessionsDataSource);
        addCacheDataSources(inMemoryCache);
    }
}
