package com.pinicius.android.cas2016.session.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.domain.usecase.GetSessionDetails;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionDetailsViewModel;
import com.pinicius.android.cas2016.session.view.viewmodel.mapper.SessionToSessionDetailsViewModelMapper;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionDetailsPresenter extends BasePresenter<SessionDetailsPresenter.View> {

    private Session currentSession;

    private int sessionId;

    private final GetSessionDetails getSessionDetails;
    private final SessionToSessionDetailsViewModelMapper sessionToSessionDetailsViewModelMapper;

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Inject
    public SessionDetailsPresenter(UseCaseHandler useCaseHandler, GetSessionDetails getSessionDetails,
                                   SessionToSessionDetailsViewModelMapper sessionToSessionDetailsViewModelMapper) {
        super(useCaseHandler);
        this.getSessionDetails = getSessionDetails;
        this.sessionToSessionDetailsViewModelMapper = sessionToSessionDetailsViewModelMapper;
    }

    @Override
    public void update() {
        super.update();

        getView().hideSessionDetails();
        getView().showLoading();

        loadSessionDetails();
    }

    private void loadSessionDetails() {
        createUseCaseCall(getSessionDetails)
                .args(sessionId)
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onSessionDetailsLoaded(Session session) {
                        showSessionDetails(session);
                    }
                })
                .onError(new OnErrorCallback() {
                    @Override
                    public boolean onError(Error error) {
                        return false;
                    }
                })
                .execute();
    }

    private void showSessionDetails(Session session) {
        currentSession = session;
        getView().hideLoading();
        SessionDetailsViewModel sessionViewModel =
                sessionToSessionDetailsViewModelMapper.map(session);
        getView().showSessionDetails(sessionViewModel);
    }

    public void onSpeakerClicked(SpeakerSummaryViewModel speaker) {
        getView().openSpeakerDetails(speaker.getId());
    }

    public void onRoomViewClicked() {
        getView().openRoomDetails(currentSession.getRoom().getKey());
    }

    public interface View extends BasePresenter.View {
        void hideSessionDetails();

        void showSessionDetails(SessionDetailsViewModel session);

        void openSpeakerDetails(int speakerId);

        void openRoomDetails(int roomId);
    }
}

