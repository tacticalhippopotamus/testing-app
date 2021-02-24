package com.testing;

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
     * Calls all init functions inherited from OTIs
     */
    public final void init() {
        if (OTIDrawable.class.isAssignableFrom(this.getClass()))
            ((OTIDrawable) this).initDrawable();
        if (OTISavable.class.isAssignableFrom(this.getClass()))
            ((OTISavable) this).initSavable();
        if (OTITouchable.class.isAssignableFrom(this.getClass()))
            ((OTITouchable) this).initTouchable();
    }

    /**
     * Calls all update functions inherited from OTIs
     */
    public final void update() {
        if (OTIDrawable.class.isAssignableFrom(this.getClass()))
            ((OTIDrawable) this).updateDrawable();
        if (OTISavable.class.isAssignableFrom(this.getClass()))
            ((OTISavable) this).updateSavable();
        if (OTITouchable.class.isAssignableFrom(this.getClass()))
            ((OTITouchable) this).updateTouchable();
    }

    /**
     * Calls all clean functions inherited from OTIs
     */
    public final void clean() {
        if (OTIDrawable.class.isAssignableFrom(this.getClass()))
            ((OTIDrawable) this).cleanDrawable();
        if (OTISavable.class.isAssignableFrom(this.getClass()))
            ((OTISavable) this).cleanSavable();
        if (OTITouchable.class.isAssignableFrom(this.getClass()))
            ((OTITouchable) this).cleanTouchable();
    }
}
