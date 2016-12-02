package com.pinicius.android.cas2016.speaker.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;
import com.pinicius.android.cas2016.speaker.domain.usecase.GetSpeakers;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.mapper.SpeakerToSpeakerViewModelMapper;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakersPresenter extends BasePresenter<SpeakersPresenter.View> {
    private static final int ALL_SPEAKERS_COUNT = 37;

    private final GetSpeakers getSpeakers;
    private final SpeakerToSpeakerViewModelMapper mapper;

    @Inject SpeakersPresenter(UseCaseHandler useCaseHandler, GetSpeakers getSpeakers,
                      SpeakerToSpeakerViewModelMapper mapper) {
        super(useCaseHandler);
        this.getSpeakers = getSpeakers;
        this.mapper = mapper;
    }

    @Override
    public void update() {
        super.update();

        getView().clearSpeakers();
        getView().hideSpeakers();
        getView().showLoading();

        Collection<Speaker> speakersInCache = getSpeakers.getAllSpeakersInCache();
        if(speakersInCache.size() < ALL_SPEAKERS_COUNT) {
            loadSpeakers();
        } else {
            showSpeakers(speakersInCache);
        }
    }

    private void loadSpeakers() {
        createUseCaseCall(getSpeakers)
                .args()
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onSpeakersLoaded(Collection<Speaker> speakers) {
                        showSpeakers(speakers);
                    }
                }).onError(new OnErrorCallback() {
            @Override
            public boolean onError(Error error) {
                return false;
            }
        }).execute();
    }

    private void showSpeakers(Collection<Speaker> speakers) {
        List<SpeakerViewModel> speakerViewModels = mapper.map(speakers);
        getView().showSpeakers(speakerViewModels);
        getView().hideLoading();
    }

    public void onSpeakerViewClicked(SpeakerViewModel speakerViewModel) {
        int id = speakerViewModel.getId();
        getView().openSpeakerDetails(id);
    }

    public interface View extends BasePresenter.View {
        void hideSpeakers();

        void showSpeakers(Collection<SpeakerViewModel> speakers);

        void clearSpeakers();

        void openSpeakerDetails(int speakerId);
    }
}

