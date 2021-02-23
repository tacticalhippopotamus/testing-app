package com.testing.oti;

import com.testing.GameScreen;

public interface ITouchable {
    /**
     * all initialisation of related items needs to happen in here
     */
    void initTouchable();

    /**
     * called every frame by the {@link GameScreen} containing this object
     */
    void updateTouchable();

    /**
     * all cleanup of drawing items needs to happen in here
     */
    void cleanTouchable();
}
