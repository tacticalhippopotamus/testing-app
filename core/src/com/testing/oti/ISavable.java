package com.testing.oti;

import com.testing.GameScreen;

public interface ISavable {
    /**
     * all initialisation of related items needs to happen in here
     */
    void initSavable();

    /**
     * called every frame by the {@link GameScreen} containing this object
     */
    void updateSavable();

    /**
     * all cleanup of drawing items needs to happen in here
     */
    void cleanSavable();
}
