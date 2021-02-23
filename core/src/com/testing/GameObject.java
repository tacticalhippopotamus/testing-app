package com.testing;

import com.testing.oti.IDrawable;
import com.testing.oti.ISavable;
import com.testing.oti.ITouchable;

/**
 * The core class for every element in the game.
 * <p>
 * Everything from buttons, to text fields, to whole game mechanics need to inherit from this
 * class. This is to make sure every object is able to be stored by a {@link GameScreen} and
 * make sure that every object is updated correctly.
 */
public abstract class GameObject {
    /**
     * Calls all init functions inherited from OTIs
     */
    public final void init() {
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).initDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).initSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).initTouchable();
    }

    /**
     * Calls all update functions inherited from OTIs
     */
    public final void update() {
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).updateDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).updateSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).updateTouchable();
    }

    /**
     * Calls all clean functions inherited from OTIs
     */
    public final void clean() {
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).cleanDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).cleanSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).cleanTouchable();
    }
}
