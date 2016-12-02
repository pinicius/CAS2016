package com.pinicius.android.cas2016.session.view.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.session.view.presenter.DaySessionsPresenter;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionViewModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionRendererBuilder extends RendererBuilder<SessionViewModel> {
    private Map<Class, Class> renderingMapping = new HashMap<>();

    public SessionRendererBuilder(DaySessionsPresenter presenter) {
        List<Renderer<SessionViewModel>> prototypes = new LinkedList<>();
        prototypes.add(new SessionRenderer(presenter));
        renderingMapping.put(SessionViewModel.class, SessionRenderer.class);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(SessionViewModel content) {
        if(content != null) {
            return renderingMapping.get(content.getClass());
        }
        else
            return super.getPrototypeClass(content);
    }
}
