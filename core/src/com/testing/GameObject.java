package com.testing;

import com.testing.oti.IDrawable;
import com.testing.oti.ISavable;
import com.testing.oti.ITouchable;

public abstract class GameObject {
    public final void init(){
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).initDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).initSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).initTouchable();
    }

    public final void update() {
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).updateDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).updateSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).updateTouchable();
    }

    public final void clean(){
        if (IDrawable.class.isAssignableFrom(this.getClass()))
            ((IDrawable) this).cleanDrawable();
        if (ISavable.class.isAssignableFrom(this.getClass()))
            ((ISavable) this).cleanSavable();
        if (ITouchable.class.isAssignableFrom(this.getClass()))
            ((ITouchable) this).cleanTouchable();
    }
}
