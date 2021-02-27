package com.testing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.testing.oti.OTIDrawable;
import com.testing.oti.OTISavable;
import com.testing.oti.OTITouchable;

/**
 * The core class for every element in the game.
 * <p>
 * Everything from buttons, to text fields, to whole game mechanics need to inherit from this
 * class. This is to make sure every object is able to be stored by a {@link BaseScreen} and
 * make sure that every object is updated correctly.
 */
public abstract class BaseObject {
    /**
     * Calls all update functions inherited from OTIs
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    public final void update(SpriteBatch batch) {
        // run any updates specific to the inherited class
        objectUpdate();

        // run all oti updates
        if (OTITouchable.class.isAssignableFrom(this.getClass()))
            ((OTITouchable) this).updateTouchable();
        if (OTIDrawable.class.isAssignableFrom(this.getClass()))
            ((OTIDrawable) this).updateDrawable(batch);
        if (OTISavable.class.isAssignableFrom(this.getClass()))
            ((OTISavable) this).updateSavable();
    }

    protected void objectUpdate(){}

    public final void dispose(){
        // run all oti updates
        if (OTITouchable.class.isAssignableFrom(this.getClass()))
            ((OTITouchable) this).disposeTouchable();
        if (OTIDrawable.class.isAssignableFrom(this.getClass()))
            ((OTIDrawable) this).disposeDrawable();
        if (OTISavable.class.isAssignableFrom(this.getClass()))
            ((OTISavable) this).disposeSavable();
    }

    protected void objectDispose(){}
}
