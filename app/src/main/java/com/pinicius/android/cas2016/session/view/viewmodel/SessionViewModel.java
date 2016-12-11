package com.pinicius.android.cas2016.session.view.viewmodel;

import com.pinicius.android.cas2016.room.view.viewmodel.RoomSummaryViewModel;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerSummaryViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionViewModel {

    private static String INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm";
    private static String OUTPUT_DATE_FORMAT = "HH:mm (dd-MM-yy)";

    private final int id;
    private final String name;
    private final String description;
    private final int duration;
    private final String startTime;
    private final String endTime;
    private final RoomSummaryViewModel room;
    private final List<SpeakerSummaryViewModel> speakers;

    public SessionViewModel(int id, String name,
                            String description, int duration,
                            String startTime, String endTime,
                            RoomSummaryViewModel room, List<SpeakerSummaryViewModel> speakers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.speakers = speakers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<SpeakerSummaryViewModel> getSpeakers() {
        return speakers;
    }

    public int getDuration() {
        return duration;
    }

    public RoomSummaryViewModel getRoom() {
        return room;
    }

    public String getPrintableStartDateTime() {
        SimpleDateFormat dateFormatInput = new SimpleDateFormat(INPUT_DATE_FORMAT);
        SimpleDateFormat dateFormatOutput = new SimpleDateFormat(OUTPUT_DATE_FORMAT);
        String result;
        try {
            Date date = dateFormatInput.parse(startTime);
            result = dateFormatOutput.format(date);
        } catch (ParseException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }

    public String getPrintableEndDateTime() {
        SimpleDateFormat dateFormatInput = new SimpleDateFormat(INPUT_DATE_FORMAT);
        SimpleDateFormat dateFormatOutput = new SimpleDateFormat(OUTPUT_DATE_FORMAT);
        String result;
        try {
            Date date = dateFormatInput.parse(endTime);
            result = dateFormatOutput.format(date);
        } catch (ParseException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }
}

