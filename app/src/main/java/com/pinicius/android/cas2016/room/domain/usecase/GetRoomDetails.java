package com.pinicius.android.cas2016.room.domain.usecase;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.repository.RoomsRepository;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class GetRoomDetails extends RosieUseCase {

    private final RoomsRepository repository;

    @Inject GetRoomDetails(RoomsRepository repository) {
        this.repository = repository;
    }

    @UseCase public void getRoomDetails(int roomId) throws Exception {
        Room room = repository.getByKey(roomId);
        notifySuccess(room);
    }
}
