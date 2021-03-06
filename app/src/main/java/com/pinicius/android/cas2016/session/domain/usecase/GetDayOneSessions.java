package com.pinicius.android.cas2016.session.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.karumi.rosie.repository.policy.ReadPolicy;
import com.pinicius.android.cas2016.session.domain.model.Session;
import com.pinicius.android.cas2016.session.repository.DayOneSessionsRepository;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 28/11/16.
 */

public class GetDayOneSessions extends RosieUseCase {

    private final DayOneSessionsRepository repository;

    @Inject public GetDayOneSessions(DayOneSessionsRepository repository) {
        this.repository = repository;
    }

    public Collection<Session> getAllSessionsInCache() {
        Collection<Session> all;
        try {
            all = repository.getAll(ReadPolicy.CACHE_ONLY);
        } catch (Exception e) {
            all = new ArrayList<>();
        }

        if (all == null) {
            all = new ArrayList<>();
        }

        return all;
    }

    @UseCase public void getDayOneSessions() throws Exception {
        Collection<Session> sessions = repository.getAll();
        notifySuccess(sessions);
    }
}
