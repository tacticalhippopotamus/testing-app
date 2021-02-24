package com.testing.oti;

import com.testing.BaseScreen;

public interface OTIDrawable {
    /**
     * all initialisation of related items needs to happen in here
     */
    void initDrawable();
    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    void updateDrawable();

    /**
     * all cleanup of drawing items needs to happen in here
     */
    void cleanDrawable();
}
