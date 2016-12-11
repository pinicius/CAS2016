package com.pinicius.android.cas2016.room.view.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.room.view.presenter.RoomDetailsPresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;
import com.pinicius.android.cas2016.speaker.view.renderer.SpeakerSessionSummaryRenderer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pinicius on 30/11/16.
 */

public class RoomSessionSummaryRendererBuilder extends RendererBuilder<SessionSummaryViewModel> {
    private Map<Class, Class> renderingMapping = new HashMap<>();

    public RoomSessionSummaryRendererBuilder(RoomDetailsPresenter presenter) {
        List<Renderer<SessionSummaryViewModel>> prototypes = new LinkedList<>();
        prototypes.add(new RoomSessionSummaryRenderer(presenter));
        renderingMapping.put(SessionSummaryViewModel.class, RoomSessionSummaryRenderer.class);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(SessionSummaryViewModel content) {
        if(content != null) {
            return renderingMapping.get(content.getClass());
        } else
            return super.getPrototypeClass(content);
    }
}
