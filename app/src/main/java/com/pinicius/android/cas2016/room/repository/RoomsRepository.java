package com.pinicius.android.cas2016.room.repository;

import com.karumi.rosie.repository.RosieRepository;
import com.karumi.rosie.repository.datasource.InMemoryCacheDataSource;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.repository.datasource.RoomsApiDataSource;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class RoomsRepository extends RosieRepository<Integer, Room> {

    private RoomsApiDataSource roomApiDataSource;

    @Inject RoomsRepository(RoomsDataSourceFactory roomsDataSourceFactory,
                            InMemoryCacheDataSource<Integer, Room> inMemoryCache) {
        roomApiDataSource = roomsDataSourceFactory.createDataSource();
        addReadableDataSources(roomApiDataSource);
        addCacheDataSources(inMemoryCache);
    }

    @Override
    public Collection<Room> getAll() throws Exception {
        return roomApiDataSource.getAll();
    }
}
