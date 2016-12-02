package com.pinicius.android.cas2016.room.view.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.domain.usecase.error.OnErrorCallback;
import com.pinicius.android.cas2016.base.view.presenter.BasePresenter;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.room.domain.usecase.GetRoomDetails;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomDetailsViewModel;
import com.pinicius.android.cas2016.room.view.viewmodel.mapper.RoomToRoomDetailsViewModelMapper;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;

import javax.inject.Inject;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomDetailsPresenter extends BasePresenter<RoomDetailsPresenter.View> {

    private int roomId;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    private final GetRoomDetails getRoomDetails;
    private final RoomToRoomDetailsViewModelMapper mapper;

    @Inject public RoomDetailsPresenter(UseCaseHandler useCaseHandler, GetRoomDetails getRoomDetails,
                                RoomToRoomDetailsViewModelMapper mapper) {
        super(useCaseHandler);
        this.getRoomDetails = getRoomDetails;
        this.mapper = mapper;
    }

    @Override
    public void update() {
        super.update();

        getView().hideRoomDetails();
        getView().showLoading();

        loadRoomDetails();
    }

    private void loadRoomDetails() {
        createUseCaseCall(getRoomDetails)
                .args(roomId)
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onRoomDetailsLoaded(Room room) {
                        showRoomDetails(room);
                    }
                })
                .onError(new OnErrorCallback() {
                    @Override
                    public boolean onError(Error error) {
                        return false;
                    }
                })
                .execute();
    }

    private void showRoomDetails(Room room) {
        getView().hideLoading();
        RoomDetailsViewModel roomDetailsViewModel = mapper.map(room);
        getView().showRoomDetails(roomDetailsViewModel);
    }

    public void onSessionClicked(SessionSummaryViewModel session) {
        getView().openSessionDetails(session.getId());
    }

    public interface View extends BasePresenter.View {
        void hideRoomDetails();

        void showRoomDetails(RoomDetailsViewModel room);

        void openSessionDetails(int sessionId);
    }
}
