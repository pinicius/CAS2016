package com.pinicius.android.cas2016.base.view.error;

import com.karumi.rosie.domain.usecase.error.ErrorFactory;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class CASErrorFactory extends ErrorFactory {

    @Inject
    public CASErrorFactory() {}

    @Override public Error create(Exception exception) {
        Throwable targetException = exception;
        if (exception instanceof InvocationTargetException) {
            targetException = ((InvocationTargetException) exception).getTargetException();
        }
        return new UnknownError();
    }
}
