package com.pinicius.android.cas2016.session.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.domain.usecase.GetDayTwoSessions;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;
import com.pinicius.android.cas2016.session.view.viewmodel.mapper.SessionToSessionViewModelMapper;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayTwoSessionsPresenter extends DaySessionsPresenter {

    private final GetDayTwoSessions getDayTwoSessions;
    private final SessionToSessionViewModelMapper mapper;

    @Inject
    DayTwoSessionsPresenter(UseCaseHandler useCaseHandler, GetDayTwoSessions getDayTwoSessions,
                            SessionToSessionViewModelMapper mapper) {
        super(useCaseHandler);
        this.getDayTwoSessions = getDayTwoSessions;
        this.mapper = mapper;
    }

    @Override
    public void update() {
        super.update();
        getView().hideSessions();
        getView().showLoading();

        Collection<Session> sessionsInCache = getDayTwoSessions.getAllSessionsInCache();
        if(sessionsInCache.size() <= 1) {
            loadSessions();
        } else {
            getView().clearSessions();
            showSessions(sessionsInCache);
        }
    }

    private void loadSessions() {
        createUseCaseCall(getDayTwoSessions)
                .args()
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onDaySessionsLoaded(Collection<Session> sessions) {
                        showSessions(sessions);
                    }
                }).onError(new OnErrorCallback() {
            @Override
            public boolean onError(Error error) {
                return false;
            }
        }).execute();
    }

    private void showSessions(Collection<Session> sessions) {
        List<SessionViewModel> sessionViewModels = mapper.map(sessions);
        getView().showSessions(sessionViewModels);
        getView().hideLoading();
    }
}
