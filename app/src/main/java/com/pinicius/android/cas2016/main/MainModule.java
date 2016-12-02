package com.pinicius.android.cas2016.main;

import com.pinicius.android.cas2016.main.view.activity.MainActivity;
import com.pinicius.android.cas2016.room.view.fragment.RoomsFragment;
import com.pinicius.android.cas2016.session.view.fragment.DayOneSessionsFragment;
import com.pinicius.android.cas2016.session.view.fragment.DayTwoSessionsFragment;
import com.pinicius.android.cas2016.session.view.fragment.SessionsFragment;
import com.pinicius.android.cas2016.speaker.view.fragment.SpeakersFragment;

import dagger.Module;

/**
 * Created by pinicius on 28/11/16.
 */

@Module(library = true,
        complete = false,
        injects = {
                MainActivity.class, SessionsFragment.class,
                DayOneSessionsFragment.class, DayTwoSessionsFragment.class,
                SpeakersFragment.class, RoomsFragment.class
        })public class MainModule {
}
