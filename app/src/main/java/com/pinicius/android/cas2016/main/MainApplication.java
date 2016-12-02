package com.pinicius.android.cas2016.main;

import com.karumi.rosie.application.RosieApplication;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by pinicius on 28/11/16.
 */

public class MainApplication extends RosieApplication {
    private ObjectGraph fakeObjectGraph;

    @Override protected List<Object> getApplicationModules() {
        return Arrays.asList((Object) new ApplicationModule());
    }

    public void replaceGraph(ObjectGraph objectGraph) {
        this.fakeObjectGraph = objectGraph;
    }

    @Override public ObjectGraph plusGraph(List<Object> activityScopeModules) {
        ObjectGraph newObjectGraph;
        if (fakeObjectGraph == null) {
            newObjectGraph = super.plusGraph(activityScopeModules);
        } else {
            newObjectGraph = fakeObjectGraph.plus(activityScopeModules.toArray());
        }
        return newObjectGraph;
    }

    public void resetFakeGraph() {
        fakeObjectGraph = null;
    }
}
