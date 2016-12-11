package com.pinicius.android.cas2016.speaker.view.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.speaker.view.presenter.SpeakersPresenter;
import com.pinicius.android.cas2016.speaker.view.viewmodel.SpeakerViewModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pinicius on 29/11/16.
 */

public class SpeakerRendererBuilder extends RendererBuilder<SpeakerViewModel> {
    private Map<Class, Class> renderingMapping = new HashMap<>();

    public SpeakerRendererBuilder(SpeakersPresenter presenter) {
        List<Renderer<SpeakerViewModel>> prototypes = new LinkedList<>();
        prototypes.add(new SpeakerRenderer(presenter));
        renderingMapping.put(SpeakerViewModel.class, SpeakerRenderer.class);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(SpeakerViewModel content) {
        if(content != null) {
            return renderingMapping.get(content.getClass());
        }
        else
            return super.getPrototypeClass(content);
    }
}
