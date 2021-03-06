package com.testing.oti;

import com.testing.BaseScreen;

public interface OTITouchable {
    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    void updateTouchable();

    /**
     * called when the object is no longer needed
     */
    void disposeTouchable();
}
