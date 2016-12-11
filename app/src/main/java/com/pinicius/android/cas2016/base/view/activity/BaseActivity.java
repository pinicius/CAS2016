package com.pinicius.android.cas2016.base.view.activity;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.karumi.rosie.view.RosieAppCompatActivity;
import com.pinicius.android.cas2016.R;

/**
 * Created by pinicius on 28/11/16.
 */

public abstract class BaseActivity extends RosieAppCompatActivity {

    @Override protected abstract int getLayoutId();

    public void showGenericError() {
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, getString(R.string.generic_error), Snackbar.LENGTH_SHORT).show();
    }

    public void showConnectionError() {
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, getString(R.string.connection_error), Snackbar.LENGTH_SHORT).show();
    }
}
