package com.pinicius.android.cas2016.session.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.DayOneSessionsRepository;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class GetSessionDetails extends RosieUseCase {
    private final DayOneSessionsRepository repository;

    @Inject GetSessionDetails(DayOneSessionsRepository repository) {
        this.repository = repository;
    }

    @UseCase
    public void getSessionDetails(int sessionId) throws Exception {
        Session session = repository.getByKey(sessionId);
        notifySuccess(session);
    }
}
