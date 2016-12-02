package com.pinicius.android.cas2016.speaker.repository;

import com.karumi.rosie.repository.RosieRepository;
import com.karumi.rosie.repository.datasource.InMemoryCacheDataSource;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.repository.datasource.SpeakersApiDataSource;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakersRepository extends RosieRepository<Integer, Speaker> {

    private SpeakersApiDataSource speakerApiDataSource;

    @Inject SpeakersRepository(SpeakersDataSourceFactory speakersDataSourceFactory,
                       InMemoryCacheDataSource<Integer, Speaker> inMemoryCacheDataSource) {
        speakerApiDataSource = speakersDataSourceFactory.createDataSource();
        addReadableDataSources(speakerApiDataSource);
        addCacheDataSources(inMemoryCacheDataSource);
    }

    @Override
    public Collection<Speaker> getAll() throws Exception {
        return speakerApiDataSource.getAll();
    }
}
