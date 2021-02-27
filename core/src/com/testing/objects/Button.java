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

    @Override
    public void disposeTouchable() {

    }

    public boolean isReleased() {
        return state.equals(ButtonState.RELEASED);
    }
}
