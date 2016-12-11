package com.pinicius.android.cas2016.room.view.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.pinicius.android.cas2016.room.view.presenter.RoomsPresenter;
import com.pinicius.android.cas2016.room.view.viewmodel.RoomViewModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pinicius on 29/11/16.
 */

public class RoomRendererBuilder extends RendererBuilder<RoomViewModel> {
    private Map<Class, Class> renderingMapping = new HashMap<>();

    public RoomRendererBuilder(RoomsPresenter presenter) {
        List<Renderer<RoomViewModel>> prototypes = new LinkedList<>();
        prototypes.add(new RoomRenderer(presenter));
        renderingMapping.put(RoomViewModel.class, RoomRenderer.class);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(RoomViewModel content) {
        if(content != null) {
            return renderingMapping.get(content.getClass());
        }
        else
            return super.getPrototypeClass(content);
    }
}
