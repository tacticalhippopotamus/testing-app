package com.testing.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;

public class ImageButton extends Button implements OTIDrawable {
    protected TextureObject[] textures;

    /**
     * Constructor for the image button object
     * <p>
     * Textures for the button must be stored in the format:
     * - [base path]_inactive.png for the texture to show when the button is inactive
     * - [base path]_touched.png for the texture to show when the button is touched
     *
     * @param x               bottom left x coordinate of the button
     * @param y               bottom left y coordinate of the button
     * @param width           width of the button
     * @param height          height of the button
     * @param texturePathBase the base filename for all button textures, for example,
     *                        "texture/my_button" would be the base for
     *                        "texture/my_button_inactive.png" and "texture/my_button_touched.png"
     */
    public ImageButton(float x, float y, float width, float height, String texturePathBase) {
        super(x, y, width, height);

        textures = new TextureObject[2];
        textures[0] = new TextureObject(texturePathBase + "_inactive");
        textures[1] = new TextureObject(texturePathBase + "_touched");
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        if (state == ButtonState.TOUCHED || state == ButtonState.RELEASED)
            batch.draw(textures[1].getRegion(), bounds.getX(), bounds.getY(),
                    bounds.getWidth(), bounds.getHeight());
        else
            batch.draw(textures[0].getRegion(), bounds.getX(), bounds.getY(),
                    bounds.getWidth(), bounds.getHeight());
    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeDrawable() {
        for (TextureObject t : textures)
            t.dispose();
    }
}
