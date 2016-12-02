package com.pinicius.android.cas2016.session.view.viewmodel.mapper;

import com.pinicius.android.cas2016.session.domain.model.SessionSummary;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class SessionSummaryToSessionSummaryViewModelMapper {

    @Inject
    public SessionSummaryToSessionSummaryViewModelMapper() {
    }

    public SessionSummaryViewModel map(SessionSummary sessionSummary) {
        SessionSummaryViewModel sessionSummaryViewModel =
                new SessionSummaryViewModel(sessionSummary.getKey(), sessionSummary.getName(), sessionSummary.getLinks());
        return sessionSummaryViewModel;
    }

    public List<SessionSummaryViewModel> map(Collection<SessionSummary> sessionSummaries) {
        List<SessionSummaryViewModel> sessionSummaryViewModels = new ArrayList<>();
        for (SessionSummary sessionSummary : sessionSummaries) {
            sessionSummaryViewModels.add(map(sessionSummary));
        }
        return sessionSummaryViewModels;
    }
}
