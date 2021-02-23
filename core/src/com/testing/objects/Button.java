package com.testing.objects;

import com.testing.GameObject;
import com.testing.GameScreen;
import com.testing.oti.IDrawable;
import com.testing.oti.ITouchable;

/**
 * Simple button example for OTI usage
 */
public class Button extends GameObject implements ITouchable, IDrawable {
    /**
     * all initialisation of related items needs to happen in here
     */
    @Override
    public void initDrawable() {

    }

    /**
     * called every frame by the {@link GameScreen} containing this object
     */
    @Override
    public void updateDrawable() {

    }

    /**
     * all cleanup of drawing items needs to happen in here
     */
    @Override
    public void cleanDrawable() {

    }

    /**
     * all initialisation of related items needs to happen in here
     */
    @Override
    public void initTouchable() {

    }

    /**
     * called every frame by the {@link GameScreen} containing this object
     */
    @Override
    public void updateTouchable() {

    }

    /**
     * all cleanup of drawing items needs to happen in here
     */
    @Override
    public void cleanTouchable() {

    }
}
