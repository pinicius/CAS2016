package com.pinicius.android.cas2016.room.view.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karumi.rosie.renderer.RosieRenderer;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.room.view.presenter.RoomsPresenter;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomViewModel;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomRenderer extends RosieRenderer<RoomViewModel> {

    @Bind(R.id.name) TextView nameView;
    @Bind(R.id.capacity) TextView capacityView;

    private final RoomsPresenter presenter;

    RoomRenderer(RoomsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.item_room, parent, false);
    }

    @Override
    public void render() {
        super.render();
        RoomViewModel roomViewModel = getContent();
        nameView.setText(roomViewModel.getName());
        renderCapacityView(roomViewModel.getCapacity());
    }

    @OnClick(R.id.root_cardview) public void onCardViewClicked() {
        presenter.onCardViewClicked(getContent());
    }

    private void renderCapacityView(int capacity) {
        capacityView.setText(getRootView().getContext().getString(R.string.seats) +
                "\n" +
                String.valueOf(capacity));
    }
}
