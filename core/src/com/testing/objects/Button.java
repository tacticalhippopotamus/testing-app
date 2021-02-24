package com.testing.objects;

import com.testing.BaseObject;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;
import com.testing.oti.OTITouchable;

/**
 * Simple button example for OTI usage
 */
public class Button extends BaseObject implements OTITouchable, OTIDrawable {
    /**
     * all initialisation of related items needs to happen in here
     */
    @Override
    public void initDrawable() {

    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
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
     * called every frame by the {@link BaseScreen} containing this object
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
