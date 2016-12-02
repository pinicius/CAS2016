package com.pinicius.android.cas2016.session.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.karumi.rosie.view.Presenter;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.fragment.BaseFragment;
import com.pinicius.android.cas2016.session.view.activity.SessionDetailsActivity;
import com.pinicius.android.cas2016.session.view.presenter.DayTwoSessionsPresenter;
import com.pinicius.android.cas2016.session.view.presenter.DaySessionsPresenter;
import com.pinicius.android.cas2016.session.view.renderer.SessionRendererBuilder;
import com.pinicius.android.cas2016.session.view.renderer.SessionsAdapteeCollection;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by pinicius on 28/11/16.
 */

public class DayTwoSessionsFragment extends BaseFragment implements DaySessionsPresenter.View {

    @Bind(R.id.rv_sessions) RecyclerView sessionsView;
    @Bind(R.id.loading) RotateLoading loadingView;

    @Inject @Presenter
    DayTwoSessionsPresenter presenter;

    private RVRendererAdapter<SessionViewModel> sessionsAdapter;
    private SessionsAdapteeCollection sessionsCollection;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeSessionsView();
    }

    private void initializeSessionsView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        sessionsView.setLayoutManager(layoutManager);
        sessionsView.setHasFixedSize(true);
        initializeAdapter();
        sessionsView.setAdapter(sessionsAdapter);
    }

    private void initializeAdapter() {
        RendererBuilder<SessionViewModel> rendererBuilder = new SessionRendererBuilder(presenter);
        sessionsCollection = new SessionsAdapteeCollection();
        sessionsAdapter = new RVRendererAdapter<>(rendererBuilder, sessionsCollection);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_day_schedule;
    }

    @Override
    public void hideSessions() {
        sessionsView.setVisibility(View.GONE);
    }

    @Override
    public void showSessions(Collection<SessionViewModel> sessions) {
        sessionsAdapter.addAll(sessions);
        sessionsAdapter.notifyDataSetChanged();
        sessionsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void openSessionDetails(int sessionId) {
        SessionDetailsActivity.open(getActivity(), sessionId);
    }

    @Override
    public void clearSessions() {
        sessionsAdapter.clear();
    }

    @Override
    public void hideLoading() {
        loadingView.stop();
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
        loadingView.start();
    }
}