package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.testing.BaseObject;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;
import com.testing.oti.OTITouchable;

/**
 * Simple button example for OTI usage
 */
public class Button extends BaseObject implements OTITouchable, OTIDrawable {
    protected Texture[] textures;
    protected int currentTexture;

    protected Sprite sprite;

    protected ButtonState state;

    /**
     * Constructor for the generic button object
     *
     * Textures for the button must be stored in the format:
     * - [base path]_inactive.png for the texture to show when the button is inactive
     * - [base path]_touched.png for the texture to show when the button is touched
     *
     * @param x bottom left x coordinate of the button
     * @param y bottom left y coordinate of the button
     * @param width width of the button
     * @param height height of the button
     * @param texturePathBase the base filename for all button textures, for example, "texture/my_button" would be the base for "texture/my_button_inactive.png" and "texture/my_button_touched.png"
     */
    public Button(float x, float y, float width, float height, String texturePathBase) {
        // todo convert this to a texture atlas once we know how they work
        textures = new Texture[2];
        textures[0] = new Texture(texturePathBase + "_inactive.png");
        textures[1] = new Texture(texturePathBase + "_touched.png");

        sprite = new Sprite(textures[0]);
        sprite.setSize(width, height);
        sprite.setPosition(x, y);

        currentTexture = 0;

        state = ButtonState.INACTIVE;
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        if (state.equals(ButtonState.TOUCHED) && currentTexture != 1) {
            sprite.setTexture(textures[1]);
            currentTexture = 1;
        } else if (state.equals(ButtonState.INACTIVE) && currentTexture != 0) {
            sprite.setTexture(textures[0]);
            currentTexture = 0;
        }

        sprite.draw(batch);
    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeDrawable() {
        textures[0].dispose();
        textures[1].dispose();
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     */
    @Override
    public void updateTouchable() {
        // the origin for sprites is the bottom left corner, whereas the origin for the input
        // is the top left. thus, screenHeight - y must be used when a comparison between pointer
        // and sprite is done.
        if (Gdx.input.isTouched() && sprite.getBoundingRectangle().contains(
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
