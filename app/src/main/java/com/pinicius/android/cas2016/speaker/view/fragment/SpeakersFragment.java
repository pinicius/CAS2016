package com.pinicius.android.cas2016.speaker.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.karumi.rosie.view.Presenter;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.fragment.BaseFragment;
import com.pinicius.android.cas2016.speaker.view.activity.SpeakerDetailsActivity;
import com.pinicius.android.cas2016.speaker.view.presenter.SpeakersPresenter;
import com.pinicius.android.cas2016.speaker.view.renderer.SpeakerRendererBuilder;
import com.pinicius.android.cas2016.speaker.view.renderer.SpeakersAdapteeCollection;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakersFragment extends BaseFragment implements SpeakersPresenter.View {
    public static final String TAG = SpeakersFragment.class.getSimpleName();

    @Bind(R.id.rv_spakers)
    RecyclerView speakersView;
    @Bind(R.id.loading)
    RotateLoading loading;

    @Inject @Presenter SpeakersPresenter presenter;

    private RVRendererAdapter<SpeakerViewModel> speakersAdapter;
    private SpeakersAdapteeCollection speakersCollection;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_speakers;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeSpeakersView();
    }

    private void initializeSpeakersView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        speakersView.setLayoutManager(layoutManager);
        speakersView.setHasFixedSize(true);
        initializeAdapter();
        speakersView.setAdapter(speakersAdapter);
    }

    private void initializeAdapter() {
        RendererBuilder<SpeakerViewModel> rendererBuilder = new SpeakerRendererBuilder(presenter);
        speakersCollection = new SpeakersAdapteeCollection();
        speakersAdapter = new RVRendererAdapter<>(rendererBuilder, speakersCollection);
    }

    @Override
    public void hideSpeakers() {
        speakersView.setVisibility(View.GONE);
    }

    @Override
    public void showSpeakers(Collection<SpeakerViewModel> speakers) {
        speakersAdapter.addAll(speakers);
        speakersAdapter.notifyDataSetChanged();
        speakersView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearSpeakers() {
        speakersAdapter.clear();
    }

    @Override
    public void openSpeakerDetails(int speakerId) {
        SpeakerDetailsActivity.open(getActivity(), speakerId);
    }

    @Override
    public void hideLoading() {
        loading.stop();
        loading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
        loading.start();
    }
}

