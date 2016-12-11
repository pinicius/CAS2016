package com.pinicius.android.cas2016.speaker.view.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;
import com.pinicius.android.cas2016.speaker.view.presenter.SpeakerDetailsPresenter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerSessionSummaryRendererBuilder extends RendererBuilder<SessionSummaryViewModel> {
    private Map<Class, Class> renderingMapping = new HashMap<>();

    public SpeakerSessionSummaryRendererBuilder(SpeakerDetailsPresenter presenter) {
        List<Renderer<SessionSummaryViewModel>> prototypes = new LinkedList<>();
        prototypes.add(new SpeakerSessionSummaryRenderer(presenter));
        renderingMapping.put(SessionSummaryViewModel.class, SpeakerSessionSummaryRenderer.class);
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
