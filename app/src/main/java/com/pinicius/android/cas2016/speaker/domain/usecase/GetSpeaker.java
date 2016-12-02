package com.pinicius.android.cas2016.speaker.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.repository.SpeakersRepository;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class GetSpeaker extends RosieUseCase {
    private final SpeakersRepository repository;


    @Inject GetSpeaker(SpeakersRepository repository) {
        this.repository = repository;
    }

    @UseCase
    public void getSpeaker(int speakerId) throws Exception {
        Speaker speaker = repository.getByKey(speakerId);
        notifySuccess(speaker);
    }
}
