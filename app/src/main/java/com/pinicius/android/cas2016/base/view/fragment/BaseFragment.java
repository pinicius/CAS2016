package com.pinicius.android.cas2016.base.view.fragment;

import android.support.design.widget.Snackbar;

import com.karumi.rosie.view.RosieSupportFragment;
import com.pinicius.android.cas2016.R;

/**
 * Created by pinicius on 28/11/16.
 */

public abstract class BaseFragment extends RosieSupportFragment {
    public void showGenericError() {
        Snackbar.make(getView(), getString(R.string.generic_error), Snackbar.LENGTH_SHORT).show();
    }

    public void showConnectionError() {
        Snackbar.make(getView(), getString(R.string.connection_error), Snackbar.LENGTH_SHORT).show();
    }
}
