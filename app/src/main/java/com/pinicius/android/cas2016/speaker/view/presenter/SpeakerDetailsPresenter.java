package com.pinicius.android.cas2016.speaker.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.domain.usecase.GetSpeaker;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.mapper.SpeakerToSpeakerViewModelMapper;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerDetailsPresenter extends BasePresenter<SpeakerDetailsPresenter.View> {
    private int speakerId;
    private Speaker speaker;

    private final GetSpeaker getSpeaker;
    private final SpeakerToSpeakerViewModelMapper mapper;

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    @Inject public SpeakerDetailsPresenter(UseCaseHandler useCaseHandler, GetSpeaker getSpeaker,
                                           SpeakerToSpeakerViewModelMapper mapper) {
        super(useCaseHandler);
        this.getSpeaker = getSpeaker;
        this.mapper = mapper;
    }

    @Override
    public void update() {
        super.update();
        getView().showLoading();



        loadSpeakerDetails();
    }

    private void loadSpeakerDetails() {
        getView().hideSpeakerDetails();
        createUseCaseCall(getSpeaker)
                .args(speakerId)
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onSpeakerLoaded(Speaker speaker) {
                        getView().hideLoading();
                        showSpeakerDetails(speaker);
                    }
                }).onError(new OnErrorCallback() {
            @Override
            public boolean onError(Error error) {
                return false;
            }
        }).execute();
    }

    private void showSpeakerDetails(Speaker speaker) {
        this.speaker = speaker;
        getView().hideLoading();
        SpeakerViewModel speakerViewModel =
                mapper.map(speaker);
        getView().showSpeakerDetails(speakerViewModel);
    }

    public void onWebsiteClicked() {
        getView().openWebsite(speaker.getWebsite());
    }

    public void onTwitterProfileClicked() {
        getView().openTwitterProfile(speaker.getTwitterProfile());
    }

    public void onLinkedinProfileClicked() {
        getView().openLinkedinProfile(speaker.getLinkedinProfile());
    }

    public void onSessionViewClicked(SessionSummaryViewModel sessionSummary) {
        getView().openSessionDetails(sessionSummary.getId());
    }

    public interface View extends BasePresenter.View {
        void hideSpeakerDetails();

        void showSpeakerDetails(SpeakerViewModel speaker);

        void openTwitterProfile(String profileUrl);

        void openLinkedinProfile(String profileUrl);

        void openWebsite(String websiteUrl);

        void openSessionDetails(int sessionId);
    }
}
