package com.pinicius.android.cas2016.room.view.viewmodel;

import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;

import java.util.List;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomDetailsViewModel {
    private final int id;
    private final String name;
    private final int capacity;
    private List<SessionSummaryViewModel> sessions;

    public RoomDetailsViewModel(int id, String name, int capacity, List<SessionSummaryViewModel> sessions) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<SessionSummaryViewModel> getSessions() {
        return sessions;
    }
}
