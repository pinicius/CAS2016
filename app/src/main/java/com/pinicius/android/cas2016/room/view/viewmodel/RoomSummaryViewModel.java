package com.pinicius.android.cas2016.room.view.viewmodel;

/**
 * Created by pinicius on 28/11/16.
 */

public class RoomSummaryViewModel {
    private final int id;
    private final String name;
    private final int capacity;

    public RoomSummaryViewModel(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
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
}
