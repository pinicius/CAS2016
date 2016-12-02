package com.pinicius.android.cas2016.speaker.view.viewmodel.mapper;

import com.pinicius.android.cas2016.speaker.domain.model.SpeakerSummary;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakerSummaryToSpeakerSummaryViewModelMapper {

    @Inject public SpeakerSummaryToSpeakerSummaryViewModelMapper(){
    }

    public SpeakerSummaryViewModel map(SpeakerSummary speakerSummary) {
        return new SpeakerSummaryViewModel(speakerSummary.getKey(), speakerSummary.getName());
    }

    public List<SpeakerSummaryViewModel> map(List<SpeakerSummary> speakerSummaryList) {
        List<SpeakerSummaryViewModel> speakerSummaryViewModels = new ArrayList<>();
        for (SpeakerSummary speakerSummary : speakerSummaryList) {
            speakerSummaryViewModels.add(map(speakerSummary));
        }
        return speakerSummaryViewModels;
    }
}
