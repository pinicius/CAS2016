package com.pinicius.android.cas2016.main.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class MainPresenter extends BasePresenter<MainPresenter.View> {

    private int currentSection = R.id.sessions_section;

    @Inject public MainPresenter(UseCaseHandler useCaseHandler) {
        super(useCaseHandler);
    }

    @Override
    public void initialize() {
        super.initialize();
        configureCurrentSection();
    }

    @Override
    public void update() {
        super.update();
    }

    private void configureCurrentSection() {
        switch (currentSection) {
            case R.id.sessions_section:
                getView().showSessionsSection();
                break;
            case R.id.speakers_section:
                getView().showSpeakersSection();
                break;
            case R.id.rooms_section:
                getView().showRoomsSection();
                break;
        }
    }

    public void onScheduleMenuOptionsSelected() {
        getView().showSessionsSection();
    }

    public void onSpeakersMenuOptionsSelected() {
        getView().showSpeakersSection();
    }

    public void onRoomsMenuOptionsSelected() {
        getView().showRoomsSection();
    }

    public interface View extends BasePresenter.View {
        void showSessionsSection();

        void showSpeakersSection();

        void showRoomsSection();
    }
}
