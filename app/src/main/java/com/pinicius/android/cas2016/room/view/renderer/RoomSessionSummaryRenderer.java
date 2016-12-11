package com.pinicius.android.cas2016.room.view.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karumi.rosie.renderer.RosieRenderer;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.room.view.presenter.RoomDetailsPresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 30/11/16.
 */

public class RoomSessionSummaryRenderer extends RosieRenderer<SessionSummaryViewModel> {
    @Bind(R.id.name) TextView nameView;

    private final RoomDetailsPresenter presenter;

    public RoomSessionSummaryRenderer(RoomDetailsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.item_session_summary, parent, false);
    }

    @Override
    public void render() {
        super.render();
        SessionSummaryViewModel sessionSummaryViewModel = getContent();
        nameView.setText(sessionSummaryViewModel.getName());
    }

    @OnClick(R.id.root_cardview) public void onSessionViewClicked() {
        presenter.onSessionClicked(getContent());
    }
}
