package com.pinicius.android.cas2016.base.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.karumi.rosie.view.loading.RosiePresenterWithLoading;
import com.pinicius.android.cas2016.base.view.error.ConnectionError;

/**
 * Created by pinicius on 28/11/16.
 */

public class BasePresenter<T extends BasePresenter.View> extends RosiePresenterWithLoading<T> {

    public BasePresenter(UseCaseHandler useCaseHandler) {
        super(useCaseHandler);
        registerOnErrorCallback(onErrorCallback);
    }

    private final OnErrorCallback onErrorCallback = new OnErrorCallback() {
        @Override
        public boolean onError(Error error) {
            if (error instanceof ConnectionError) {
                getView().showConnectionError();
            } else {
                getView().showGenericError();
            }
            return true;
        }
    };

    public interface View extends RosiePresenterWithLoading.View {
        void showGenericError();

        void showConnectionError();
    }
}
