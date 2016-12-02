package com.pinicius.android.cas2016.session.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;

import java.util.Collection;

/**
 * Created by pinicius on 28/11/16.
 */

public abstract class DaySessionsPresenter extends BasePresenter<DaySessionsPresenter.View> {

    public DaySessionsPresenter(UseCaseHandler useCaseHandler) {
        super(useCaseHandler);
    }

    public interface View extends BasePresenter.View {
        void hideSessions();

        void showSessions(Collection<SessionViewModel> sessions);

        void openSessionDetails(int sessionId);

        void clearSessions();
    }

    public void onCardViewClicked(SessionViewModel sessionViewModel) {
        int id = sessionViewModel.getId();
        getView().openSessionDetails(id);
    }
}
