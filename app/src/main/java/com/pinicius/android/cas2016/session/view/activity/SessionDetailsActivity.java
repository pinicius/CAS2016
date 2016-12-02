package com.pinicius.android.cas2016.session.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karumi.rosie.view.Presenter;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.activity.BaseActivity;
import com.pinicius.android.cas2016.room.view.activity.RoomDetailsActivity;
import com.pinicius.android.cas2016.session.SessionModule;
import com.pinicius.android.cas2016.session.view.presenter.SessionDetailsPresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionDetailsViewModel;
import com.pinicius.android.cas2016.speaker.view.activity.SpeakerDetailsActivity;
import com.pinicius.android.cas2016.speaker.view.custom.SpeakerRoundedView;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;
import com.pinicius.android.cas2016.tag.view.custom.TagRoundedView;
import com.pinicius.android.cas2016.tag.view.viewmodel.TagViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionDetailsActivity extends BaseActivity implements SessionDetailsPresenter.View {
    private static final String SESSION_ID_EXTRA = "SessionDetailsActivity.SessionId";

    @Bind(R.id.appbar_view) Toolbar toolbar;
    @Bind(R.id.fl_session_details) FrameLayout sessionDetailsView;
    @Bind(R.id.description_view) TextView descriptionView;
    @Bind(R.id.room_view) TextView rooomView;
    @Bind(R.id.speakers) LinearLayout speakersView;
    @Bind(R.id.tags) LinearLayout tagsView;
    @Bind(R.id.loading) RotateLoading loading;

    @OnClick(R.id.room_view) public void onRoomViewClicked() {
        presenter.onRoomViewClicked();
    }

    @Inject @Presenter SessionDetailsPresenter presenter;

    private int sessionId;

    @Override protected List<Object> getActivityScopeModules() {
        return Arrays.asList((Object) SessionModule.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_session_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPreparePresenter() {
        super.onPreparePresenter();
        sessionId = getIntent().getExtras().getInt(SESSION_ID_EXTRA);
        presenter.setSessionId(sessionId);
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

    public static void open(Context context, int sessionId) {
        Intent intent = new Intent(context, SessionDetailsActivity.class);
        intent.putExtra(SESSION_ID_EXTRA, sessionId);
        context.startActivity(intent);
    }

    @Override
    public void hideSessionDetails() {
        sessionDetailsView.setVisibility(View.GONE);
    }

    @Override
    public void showSessionDetails(SessionDetailsViewModel session) {
        sessionDetailsView.setVisibility(View.VISIBLE);
        toolbar.setTitle(session.getName());
        toolbar.setSubtitle(session.getPrintableStartDateTime() + " - " + session.getPrintableEndDateTime());
        descriptionView.setText(session.getDescription());
        rooomView.setText(session.getRoom().getName());

        speakersView.removeAllViews();
        for (SpeakerSummaryViewModel speaker : session.getSpeakers()) {
            SpeakerRoundedView speakerRoundedView = new SpeakerRoundedView(this, speaker, presenter);
            speakersView.addView(speakerRoundedView);
        }

        tagsView.removeAllViews();
        for (TagViewModel tag : session.getTags()) {
            TagRoundedView tagRoundedView = new TagRoundedView(this, tag.getName());
            tagsView.addView(tagRoundedView);
        }
        tagsView.addView(new SpaceView(this));
    }

    @Override
    public void openSpeakerDetails(int speakerId) {
        SpeakerDetailsActivity.open(this, speakerId);
    }

    @Override
    public void openRoomDetails(int roomId) {
        RoomDetailsActivity.open(this, roomId);
    }

    class SpaceView extends TextView {

        public SpaceView(Context context) {
            super(context);
            setText("             ");
        }
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

