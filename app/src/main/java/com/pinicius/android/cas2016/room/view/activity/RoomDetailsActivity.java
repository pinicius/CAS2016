package com.pinicius.android.cas2016.room.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.karumi.rosie.view.Presenter;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.activity.BaseActivity;
import com.pinicius.android.cas2016.room.RoomModule;
import com.pinicius.android.cas2016.room.view.presenter.RoomDetailsPresenter;
import com.pinicius.android.cas2016.room.view.renderer.RoomSessionSummaryRendererBuilder;
import com.pinicius.android.cas2016.room.view.renderer.RoomSessionsAdapteeCollection;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomDetailsViewModel;
import com.pinicius.android.cas2016.session.view.activity.SessionDetailsActivity;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomDetailsActivity extends BaseActivity implements RoomDetailsPresenter.View{
    private static final String ROOM_ID_EXTRA = "RoomDetailsActivity.RoomId";
    private static final String EMPTY_STRING = "";

    @Bind(R.id.appbar) Toolbar toolbarView;
    @Bind(R.id.ll_room_details) LinearLayout roomDetailsView;
    @Bind(R.id.loading) RotateLoading loadingView;
    @Bind(R.id.rv_sessions) RecyclerView sessionsView;

    private int roomId;

    @Override protected List<Object> getActivityScopeModules() {
        return Arrays.asList((Object) RoomModule.class);
    }

    @Inject @Presenter RoomDetailsPresenter presenter;

    private RVRendererAdapter<SessionSummaryViewModel> sessionsAdapter;
    private RoomSessionsAdapteeCollection roomSessionsCollection;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureAppBar();
        configureRoomSessionsView();
    }

    private void configureAppBar() {
        setSupportActionBar(toolbarView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(EMPTY_STRING);
    }

    private void configureRoomSessionsView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        sessionsView.setLayoutManager(layoutManager);
        sessionsView.setHasFixedSize(true);
        initializeAdapter();
        sessionsView.setAdapter(sessionsAdapter);
    }

    private void initializeAdapter() {
        RendererBuilder<SessionSummaryViewModel> rendererBuilder = new RoomSessionSummaryRendererBuilder(presenter);
        roomSessionsCollection = new RoomSessionsAdapteeCollection();
        sessionsAdapter = new RVRendererAdapter<>(rendererBuilder, roomSessionsCollection);
    }

    @Override
    protected void onPreparePresenter() {
        super.onPreparePresenter();
        roomId = getIntent().getExtras().getInt(ROOM_ID_EXTRA);
        presenter.setRoomId(roomId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void open(Context context, int roomId) {
        Intent intent = new Intent(context, RoomDetailsActivity.class);
        intent.putExtra(ROOM_ID_EXTRA, roomId);
        context.startActivity(intent);
    }

    @Override
    public void hideRoomDetails() {
        roomDetailsView.setVisibility(View.GONE);
    }

    @Override
    public void showRoomDetails(RoomDetailsViewModel room) {
        roomDetailsView.setVisibility(View.VISIBLE);
        toolbarView.setTitle(room.getName());
        toolbarView.setSubtitle("Capacity: " + room.getCapacity());

        sessionsAdapter.addAll(room.getSessions());
        sessionsAdapter.notifyDataSetChanged();
        //sessionsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void openSessionDetails(int sessionId) {
        SessionDetailsActivity.open(this, sessionId);
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
