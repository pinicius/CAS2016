package com.pinicius.android.cas2016.room.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.domain.usecase.GetRooms;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomViewModel;
import com.pinicius.android.cas2016.room.view.viewmodel.mapper.RoomToRoomViewModelMapper;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomsPresenter extends BasePresenter<RoomsPresenter.View> {
    private static final int ALL_ROOMS_COUNT = 7;

    private final GetRooms getRooms;
    private final RoomToRoomViewModelMapper roomMapper;


    @Inject RoomsPresenter(UseCaseHandler useCaseHandler, GetRooms getRooms,
                                  RoomToRoomViewModelMapper roomMapper) {
        super(useCaseHandler);
        this.getRooms = getRooms;
        this.roomMapper = roomMapper;
    }

    @Override
    public void update() {
        super.update();

        getView().clearRooms();
        getView().hideRooms();
        getView().showLoading();

        Collection<Room> roomsInCache = getRooms.getAllRoomsInCache();
        if(roomsInCache.size() < ALL_ROOMS_COUNT) {
            loadSessions();
        } else {
            showRooms(roomsInCache);
        }
    }

    private void loadSessions() {
        createUseCaseCall(getRooms)
                .args()
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onRoomsLoaded(Collection<Room> rooms) {
                        showRooms(rooms);
                    }
                }).onError(new OnErrorCallback() {
            @Override
            public boolean onError(Error error) {
                return false;
            }
        }).execute();
    }

    private void showRooms(Collection<Room> rooms) {
        List<RoomViewModel> roomViewModels = roomMapper.map(rooms);
        getView().showRooms(roomViewModels);
        getView().hideLoading();
    }

    public void onCardViewClicked(RoomViewModel roomViewModel) {
        getView().openRoomDetails(roomViewModel.getId());
    }

    public interface View extends BasePresenter.View {
        void hideRooms();

        void showRooms(Collection<RoomViewModel> rooms);

        void openRoomDetails(int roomId);

        void clearRooms();
    }
}
