package com.testing.oti;

import com.testing.GameScreen;

public interface IDrawable {
    /**
     * all initialisation of related items needs to happen in here
     */
    void initDrawable();
    /**
     * called every frame by the {@link GameScreen} containing this object
     */
    void updateDrawable();

    /**
     * all cleanup of drawing items needs to happen in here
     */
    void cleanDrawable();
}
