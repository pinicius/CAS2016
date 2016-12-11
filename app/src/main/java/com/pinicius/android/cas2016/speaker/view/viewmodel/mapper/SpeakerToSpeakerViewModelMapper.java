package com.pinicius.android.cas2016.speaker.view.viewmodel.mapper;

import com.pinicius.android.cas2016.session.view.viewmodel.mapper.SessionSummaryToSessionSummaryViewModelMapper;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerToSpeakerViewModelMapper {

    private final SessionSummaryToSessionSummaryViewModelMapper sessionMapper;

    @Inject
    public SpeakerToSpeakerViewModelMapper(SessionSummaryToSessionSummaryViewModelMapper sessionMapper) {
        this.sessionMapper = sessionMapper;
    }

    public SpeakerViewModel map(Speaker speaker) {
        SpeakerViewModel speakerViewModel = new SpeakerViewModel(speaker.getKey(), speaker.getName(),
                speaker.getBiography(), speaker.getTwitterProfile(),
                speaker.getLinkedinProfile(), speaker.getWebsite(),
                speaker.getCountry(), speaker.getCity(),
                speaker.getImage(),
                null,
                sessionMapper.map(speaker.getSessions()));
        return speakerViewModel;
    }

    public List<SpeakerViewModel> map(Collection<Speaker> speakers) {
        List<SpeakerViewModel> speakerViewModels = new ArrayList<>();
        for (Speaker speaker : speakers) {
            speakerViewModels.add(map(speaker));
        }
        return speakerViewModels;
    }
}
