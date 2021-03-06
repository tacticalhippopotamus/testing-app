package com.testing.oti;

import com.testing.BaseScreen;

public interface OTISavable {
    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    void updateSavable();

    /**
     * called when the object is no longer needed
     */
    void disposeSavable();
}
