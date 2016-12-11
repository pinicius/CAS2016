package com.pinicius.android.cas2016.speaker.repository.datasource.mapper;

import com.pinicius.android.cas2016.speaker.domain.model.SpeakerSummary;
import com.pinicius.android.casapiclient.model.SpeakerSummaryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakerSummaryDtoToSpeakerSummaryMapper {

    public SpeakerSummary map(SpeakerSummaryDto speakerSummaryDto) {
        SpeakerSummary speaker = new SpeakerSummary(speakerSummaryDto.getId(), speakerSummaryDto.getName());
        return speaker;
    }

    public List<SpeakerSummary> map(Collection<SpeakerSummaryDto> speakerSummaryDtos) {
        List<SpeakerSummary> speakerSummaries = new ArrayList<>();
        for (SpeakerSummaryDto speakerSummaryDto : speakerSummaryDtos) {
            speakerSummaries.add(map(speakerSummaryDto));
        }
        return speakerSummaries;
    }
}
