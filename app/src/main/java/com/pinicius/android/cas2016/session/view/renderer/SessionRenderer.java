package com.pinicius.android.cas2016.session.view.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karumi.rosie.renderer.RosieRenderer;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.session.view.presenter.DaySessionsPresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionRenderer extends RosieRenderer<SessionViewModel> {

    @Bind(R.id.name) TextView name;
    @Bind(R.id.description) TextView description;
    @Bind(R.id.speakers) TextView speakers;
    @Bind(R.id.room) TextView room;
    @Bind(R.id.time) TextView time;

    private final DaySessionsPresenter presenter;

    SessionRenderer(DaySessionsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void render() {
        super.render();
        SessionViewModel sessionViewModel = getContent();
        name.setText(sessionViewModel.getName());
        description.setText(sessionViewModel.getDescription());

        String strSpeakers = "";
        for (SpeakerSummaryViewModel speakerSummaryViewModel : sessionViewModel.getSpeakers()) {
            if (strSpeakers.isEmpty()) {
                strSpeakers = strSpeakers.concat(speakerSummaryViewModel.getName());
            } else {
                strSpeakers = strSpeakers.concat(", " + speakerSummaryViewModel.getName());
            }
        }
        speakers.setText(strSpeakers);
        room.setText(sessionViewModel.getRoom().getName());
        renderSessionTimeRange(sessionViewModel);
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.item_session, parent, false);
    }

    private void renderSessionTimeRange(SessionViewModel session) {
        time.setText(session.getPrintableStartDateTime()
                + "\n"
                + "\n"
                + session.getPrintableEndDateTime());
    }

    @OnClick(R.id.root_cardview) public void onCardViewClicked() {
        presenter.onCardViewClicked(getContent());
    }
}
