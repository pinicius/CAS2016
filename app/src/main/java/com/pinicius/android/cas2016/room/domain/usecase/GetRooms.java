package com.pinicius.android.cas2016.room.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.karumi.rosie.repository.policy.ReadPolicy;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.repository.RoomsRepository;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class GetRooms extends RosieUseCase {

    private final RoomsRepository repository;

    @Inject public GetRooms(RoomsRepository repository) {
        this.repository = repository;
    }

    public Collection<Room> getAllRoomsInCache() {
        Collection<Room> all;
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

    @UseCase
    public void getRooms() throws Exception {
        Collection<Room> rooms = repository.getAll();
        notifySuccess(rooms);
    }
}
