package com.pinicius.android.cas2016.speaker.view.custom;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.session.view.presenter.SessionDetailsPresenter;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakerRoundedView extends TextView {

    private final SessionDetailsPresenter presenter;

    public SpeakerRoundedView(Context context, final SpeakerSummaryViewModel speaker, final SessionDetailsPresenter presenter) {
        super(context);
        this.presenter = presenter;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(16.0f);
        }

        setPadding(16, 8, 16, 8);
        setLines(1);
        setText(speaker.getName());
        setBackground(getResources().getDrawable(R.drawable.speaker_rounded_background));
        setTextColor(ContextCompat.getColor(context, android.R.color.white));
        setTextSize(18.0f);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSpeakerClicked(speaker);
            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams margins = ViewGroup.MarginLayoutParams.class.cast(getLayoutParams());
        int margin = 16;
        margins.topMargin = margin;
        margins.bottomMargin = margin;
        margins.leftMargin = margin;
        margins.rightMargin = margin;
        setLayoutParams(margins);
    }
}