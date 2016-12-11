package com.pinicius.android.cas2016.room.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.karumi.rosie.view.Presenter;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.fragment.BaseFragment;
import com.pinicius.android.cas2016.room.view.activity.RoomDetailsActivity;
import com.pinicius.android.cas2016.room.view.presenter.RoomsPresenter;
import com.pinicius.android.cas2016.room.view.renderer.RoomRendererBuilder;
import com.pinicius.android.cas2016.room.view.renderer.RoomsAdapteeCollection;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomsFragment extends BaseFragment implements RoomsPresenter.View {
    public static final String TAG = RoomsFragment.class.getSimpleName();

    @Bind(R.id.loading) RotateLoading loadingView;
    @Bind(R.id.rv_rooms) RecyclerView roomsView;

    @Inject @Presenter RoomsPresenter presenter;

    private RVRendererAdapter<RoomViewModel> roomsAdapter;
    private RoomsAdapteeCollection roomsCollection;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rooms;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeSessionsView();
    }

    private void initializeSessionsView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        roomsView.setLayoutManager(layoutManager);
        roomsView.setHasFixedSize(true);
        initializeAdapter();
        roomsView.setAdapter(roomsAdapter);
    }

    private void initializeAdapter() {
        RendererBuilder<RoomViewModel> rendererBuilder = new RoomRendererBuilder(presenter);
        roomsCollection = new RoomsAdapteeCollection();
        roomsAdapter = new RVRendererAdapter<>(rendererBuilder, roomsCollection);
    }

    @Override
    public void hideRooms() {
        roomsView.setVisibility(View.GONE);
    }

    @Override
    public void showRooms(Collection<RoomViewModel> rooms) {
        roomsAdapter.addAll(rooms);
        roomsAdapter.notifyDataSetChanged();
        roomsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void openRoomDetails(int roomId) {
        RoomDetailsActivity.open(getActivity(), roomId);
    }

    @Override
    public void clearRooms() {
        roomsAdapter.clear();
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
