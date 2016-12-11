package com.pinicius.android.cas2016.speaker.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.rosie.view.Presenter;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.activity.BaseActivity;
import com.pinicius.android.cas2016.session.view.activity.SessionDetailsActivity;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;
import com.pinicius.android.cas2016.speaker.SpeakerModule;
import com.pinicius.android.cas2016.speaker.view.presenter.SpeakerDetailsPresenter;
import com.pinicius.android.cas2016.speaker.view.renderer.SpeakerSessionSummaryRendererBuilder;
import com.pinicius.android.cas2016.speaker.view.renderer.SpeakerSessionsAdapteeCollection;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerDetailsActivity extends BaseActivity implements SpeakerDetailsPresenter.View {
    private static final String SPEAKER_ID_EXTRA = "SpeakerDetailsActivity.SpeakerId";
    private static final String EMPTY_STRING = "";

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.avatar) ImageView avatarView;
    @Bind(R.id.ll_details) LinearLayout detailsContainerView;
    @Bind(R.id.biography) TextView biographyView;
    @Bind(R.id.country_city) TextView countryCityView;
    @Bind(R.id.website) ImageView websiteView;
    @Bind(R.id.twitter_profile) ImageView twitterProfileView;
    @Bind(R.id.linkedin_profile) ImageView linkedinProfileView;
    @Bind(R.id.rv_speaker_sessions) RecyclerView speakerSessionsView;

    @OnClick(R.id.website) public void onWebSiteClicked() {
        presenter.onWebsiteClicked();
    }

    @OnClick(R.id.twitter_profile) public void onTwitterProfileClicked() {
        presenter.onTwitterProfileClicked();
    }

    @OnClick(R.id.linkedin_profile) public void onLinkedinProfileClicked() {
        presenter.onLinkedinProfileClicked();
    }

    @Inject @Presenter SpeakerDetailsPresenter presenter;

    private RVRendererAdapter<SessionSummaryViewModel> sessionsAdapter;
    private SpeakerSessionsAdapteeCollection speakerSessionsCollection;

    @Override protected List<Object> getActivityScopeModules() {
        return Arrays.asList((Object) SpeakerModule.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_speaker_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureAppBar();
        configureSpeakerSessionsView();
    }

    private void configureAppBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(EMPTY_STRING);
    }

    private void configureSpeakerSessionsView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        speakerSessionsView.setLayoutManager(layoutManager);
        speakerSessionsView.setHasFixedSize(true);
        initializeAdapter();
        speakerSessionsView.setAdapter(sessionsAdapter);
    }

    private void initializeAdapter() {
        RendererBuilder<SessionSummaryViewModel> rendererBuilder = new SpeakerSessionSummaryRendererBuilder(presenter);
        speakerSessionsCollection = new SpeakerSessionsAdapteeCollection();
        sessionsAdapter = new RVRendererAdapter<>(rendererBuilder, speakerSessionsCollection);
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

    @Override
    protected void onPreparePresenter() {
        super.onPreparePresenter();
        int speakerId = getIntent().getExtras().getInt(SPEAKER_ID_EXTRA);
        presenter.setSpeakerId(speakerId);
    }

    public static void open(Context context, int speakerId) {
        Intent intent = new Intent(context, SpeakerDetailsActivity.class);
        intent.putExtra(SPEAKER_ID_EXTRA, speakerId);
        context.startActivity(intent);
    }

    @Override
    public void hideSpeakerDetails() {
        toolbar.setTitle(EMPTY_STRING);
        detailsContainerView.setVisibility(View.GONE);
    }

    @Override
    public void showSpeakerDetails(SpeakerViewModel speaker) {
        detailsContainerView.setVisibility(View.VISIBLE);
        Picasso.with(this)
                .load(speaker.getImage())
                .fit()
                .centerCrop()
                .into(avatarView);
        toolbar.setTitle(speaker.getName());
        countryCityView.setText(speaker.getCity() + ", " + speaker.getCountry());
        biographyView.setText(speaker.getBiography());

        loadSpeakerSessions(speaker.getSessions());
    }

    private void loadSpeakerSessions(Collection<SessionSummaryViewModel> sessionSummaries) {
        sessionsAdapter.clear();
        sessionsAdapter.addAll(sessionSummaries);
        sessionsAdapter.notifyDataSetChanged();
    }

    @Override
    public void openTwitterProfile(String profileUrl) {
        openUrlInBrowser(profileUrl);
    }

    private void openUrlInBrowser(String url) {
        if(url == null) {
            Toast.makeText(this, R.string.no_info, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }

    @Override
    public void openLinkedinProfile(String profileUrl) {
        openUrlInBrowser(profileUrl);
    }

    @Override
    public void openWebsite(String profileUrl) {
        openUrlInBrowser(profileUrl);
    }

    @Override
    public void openSessionDetails(int sessionId) {
        SessionDetailsActivity.open(this, sessionId);
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showLoading() {
    }
}
