package com.pinicius.android.cas2016.tag.view.custom;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinicius.android.cas2016.R;

/**
 * Created by pinicius on 28/11/16.
 */

public class TagRoundedView extends TextView {

    public TagRoundedView(Context context, String tagName) {
        super(context);
        setPadding(16, 8, 16, 8);
        setLines(1);
        setText(tagName);
        setBackground(getResources().getDrawable(R.drawable.tag_rounded_background));
        setTextColor(ContextCompat.getColor(context, android.R.color.white));
        setTextSize(18.0f);
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
