package com.pinicius.android.cas2016.speaker.repository.datasource;

import com.karumi.rosie.repository.datasource.EmptyReadableDataSource;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.repository.datasource.mapper.SpeakerDtoToSpeakerMapper;
import com.pinicius.android.casapiclient.SpeakerApiClient;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakersApiDataSource extends EmptyReadableDataSource<Integer, Speaker>
        implements SpeakersDataSource {

    private SpeakerApiClient speakerApiClient;
    private final SpeakerDtoToSpeakerMapper mapper;

    @Inject
    public SpeakersApiDataSource(SpeakerApiClient speakerApiClient, SpeakerDtoToSpeakerMapper mapper) {
        this.speakerApiClient = speakerApiClient;
        this.mapper = mapper;
    }

    @Override
    public Speaker getByKey(Integer key) throws Exception {
        return mapper.map(speakerApiClient.getSpeaker(key));
    }

    @Override
    public Collection<Speaker> getAll() throws Exception {
        return mapper.map(speakerApiClient.getAll());
    }
}
