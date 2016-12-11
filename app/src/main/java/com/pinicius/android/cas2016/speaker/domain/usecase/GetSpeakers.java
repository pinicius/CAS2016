package com.pinicius.android.cas2016.speaker.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.karumi.rosie.repository.policy.ReadPolicy;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.repository.SpeakersRepository;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class GetSpeakers extends RosieUseCase {

    private final SpeakersRepository repository;

    @Inject
    public GetSpeakers(SpeakersRepository repository) {
        this.repository = repository;
    }

    public Collection<Speaker> getAllSpeakersInCache() {
        Collection<Speaker> all;
        try {
            all = repository.getAll(ReadPolicy.CACHE_ONLY);
        } catch (Exception e) {
            all = new ArrayList<>();
        }

        if (all == null) {
            all = new ArrayList<>();
        }

        return all;
    }

    @UseCase
    public void getSpeakers() throws Exception {
        Collection<Speaker> speakers = repository.getAll();
        notifySuccess(speakers);
    }
}
