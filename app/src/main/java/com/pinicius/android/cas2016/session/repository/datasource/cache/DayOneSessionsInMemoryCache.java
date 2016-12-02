package com.pinicius.android.cas2016.session.repository.datasource.cache;

import com.karumi.rosie.repository.datasource.InMemoryCacheDataSource;
import com.karumi.rosie.time.TimeProvider;
import com.pinicius.android.cas2016.session.domain.model.Session;

import javax.inject.Inject;

/**
 * Created by pinicius on 1/12/16.
 */

public class DayOneSessionsInMemoryCache extends InMemoryCacheDataSource<Integer, Session> {
    @Inject public DayOneSessionsInMemoryCache(TimeProvider timeProvider, long ttlInMillis) {
        super(timeProvider, ttlInMillis);
    }
}
