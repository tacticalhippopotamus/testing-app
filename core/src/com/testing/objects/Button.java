package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.testing.BaseObject;
import com.testing.BaseScreen;
import com.testing.oti.OTITouchable;

/**
 * Simple button example for OTI usage
 */
public class Button extends BaseObject implements OTITouchable {
    protected Rectangle bounds;

    protected ButtonState state;

    /**
     * Constructor for the generic button object
     *
     * @param x      bottom left x coordinate of the button
     * @param y      bottom left y coordinate of the button
     * @param width  width of the button
     * @param height height of the button
     */
    public Button(float x, float y, float width, float height) {
        bounds = new Rectangle(x, y, width, height);

        state = ButtonState.INACTIVE;
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    @Override
    public void updateTouchable() {
        // the origin for rectangles is the bottom left corner, whereas the origin for the input
        // is the top left. thus, screenHeight - y must be used when a comparison between pointer
        if (Gdx.input.isTouched() && bounds.contains(
                Gdx.input.getX(), Gdx.app.getGraphics().getHeight() - Gdx.input.getY()))
            state = ButtonState.TOUCHED;
        else if (state.equals(ButtonState.TOUCHED))
            state = ButtonState.RELEASED;
        else
            state = ButtonState.INACTIVE;

    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeTouchable() {

    }

    /**
     * Query this object to see if it was just touched and released
     *
     * @return whether the button has just been released
     */
    public boolean isReleased() {
        return state.equals(ButtonState.RELEASED);
    }
}
