package com.pinicius.android.cas2016.speaker.view.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karumi.rosie.renderer.RosieRenderer;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.speaker.view.presenter.SpeakersPresenter;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerRenderer extends RosieRenderer<SpeakerViewModel> {

    @Bind(R.id.avatar)
    ImageView avatarView;
    @Bind(R.id.name)
    TextView nameView;
    @Bind(R.id.country_city) TextView countryCityView;

    private final SpeakersPresenter presenter;

    SpeakerRenderer(SpeakersPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.item_speaker, parent, false);
    }

    @Override
    public void render() {
        super.render();
        SpeakerViewModel speakerViewModel = getContent();
        nameView.setText(speakerViewModel.getName());
        countryCityView.setText(speakerViewModel.getCity() + ", " + speakerViewModel.getCountry());
        Picasso.with(getRootView().getContext())
                .load(speakerViewModel.getImage())
                .fit()
                .centerCrop()
                .into(avatarView);
    }

    @OnClick(R.id.root_cardview) public void onSpeakerViewClicked() {
        presenter.onSpeakerViewClicked(getContent());
    }
}
