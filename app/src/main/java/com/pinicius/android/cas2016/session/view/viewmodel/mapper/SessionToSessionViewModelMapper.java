package com.pinicius.android.cas2016.session.view.viewmodel.mapper;

import com.pinicius.android.cas2016.room.view.viewmodel.RoomSummaryViewModel;
import com.pinicius.android.cas2016.room.view.viewmodel.mapper.RoomSummaryToRoomSummaryViewModelMapper;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.mapper.SpeakerSummaryToSpeakerSummaryViewModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionToSessionViewModelMapper {

    private final RoomSummaryToRoomSummaryViewModelMapper roomToRoomViewModelMapper;
    private final SpeakerSummaryToSpeakerSummaryViewModelMapper speakerSummaryToSpeakerSummaryViewModelMapper;

    @Inject
    public SessionToSessionViewModelMapper(RoomSummaryToRoomSummaryViewModelMapper roomToRoomViewModelMapper,
                                           SpeakerSummaryToSpeakerSummaryViewModelMapper speakerSummaryToSpeakerSummaryViewModelMapper){
        this.speakerSummaryToSpeakerSummaryViewModelMapper = speakerSummaryToSpeakerSummaryViewModelMapper;
        this.roomToRoomViewModelMapper = roomToRoomViewModelMapper;
    }

    public SessionViewModel map(Session session) {
        RoomSummaryViewModel roomSummaryViewModel = roomToRoomViewModelMapper.map(session.getRoom());
        List<SpeakerSummaryViewModel> speakerSummaryViewModels = speakerSummaryToSpeakerSummaryViewModelMapper.map(session.getSpeakers());
        SessionViewModel sessionViewModel = new SessionViewModel(session.getKey(), session.getName(),
                session.getDescription(), session.getDuration(), session.getStartTime(), session.getEndTime(), roomSummaryViewModel, speakerSummaryViewModels);
        return sessionViewModel;
    }

    public List<SessionViewModel> map(Collection<Session> sessions) {
        List<SessionViewModel> sessionViewModels = new ArrayList<>();
        for (Session session : sessions) {
            SessionViewModel sessionViewModel = map(session);
            sessionViewModels.add(sessionViewModel);
        }
        return sessionViewModels;
    }
}