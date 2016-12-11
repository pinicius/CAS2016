package com.pinicius.android.cas2016.session.view.viewmodel.mapper;

import com.pinicius.android.cas2016.room.view.viewmodel.RoomSummaryViewModel;
import com.pinicius.android.cas2016.room.view.viewmodel.mapper.RoomSummaryToRoomSummaryViewModelMapper;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionDetailsViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.mapper.SpeakerSummaryToSpeakerSummaryViewModelMapper;
import com.pinicius.android.cas2016.tag.view.viewmodel.TagViewModel;
import com.pinicius.android.cas2016.tag.view.viewmodel.mapper.TagToTagViewModelMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 1/12/16.
 */

public class SessionToSessionDetailsViewModelMapper {
    private final RoomSummaryToRoomSummaryViewModelMapper roomToRoomViewModelMapper;
    private final SpeakerSummaryToSpeakerSummaryViewModelMapper speakerSummaryToSpeakerSummaryViewModelMapper;
    private final TagToTagViewModelMapper tagToTagViewModelMapper;

    @Inject SessionToSessionDetailsViewModelMapper(RoomSummaryToRoomSummaryViewModelMapper roomToRoomViewModelMapper,
                                           SpeakerSummaryToSpeakerSummaryViewModelMapper speakerSummaryToSpeakerSummaryViewModelMapper,
                                                  TagToTagViewModelMapper tagToTagViewModelMapper){

        this.speakerSummaryToSpeakerSummaryViewModelMapper = speakerSummaryToSpeakerSummaryViewModelMapper;
        this.roomToRoomViewModelMapper = roomToRoomViewModelMapper;
        this.tagToTagViewModelMapper = tagToTagViewModelMapper;
    }

    public SessionDetailsViewModel map(Session session) {
        RoomSummaryViewModel roomSummaryViewModel = roomToRoomViewModelMapper.map(session.getRoom());
        List<SpeakerSummaryViewModel> speakerSummaryViewModels = speakerSummaryToSpeakerSummaryViewModelMapper.map(session.getSpeakers());
        List<TagViewModel> tagViewModels = tagToTagViewModelMapper.map(session.getTags());
        SessionDetailsViewModel sessionViewModel = new SessionDetailsViewModel(session.getKey(), session.getName(),
                session.getDescription(), session.getDuration(), session.getStartTime(), session.getEndTime(), roomSummaryViewModel, speakerSummaryViewModels, tagViewModels);
        return sessionViewModel;
    }
}
