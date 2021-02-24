package com.testing.oti;

import com.testing.BaseScreen;

public interface OTITouchable {
    /**
     * all initialisation of related items needs to happen in here
     */
    void initTouchable();

    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    void updateTouchable();

    /**
     * all cleanup of drawing items needs to happen in here
     */
    void cleanTouchable();
}
