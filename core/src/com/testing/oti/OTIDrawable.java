package com.testing.oti;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.testing.BaseScreen;

public interface OTIDrawable {
    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    void updateDrawable(SpriteBatch batch);

    /**
     * called when the object is no longer needed
     */
    void disposeDrawable();
}
