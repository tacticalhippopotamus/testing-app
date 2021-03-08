package com.testing.objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;

public class TextButton extends Button implements OTIDrawable {
    protected TextObject textObject;
    protected BitmapFont font;
    protected BitmapFont fontAlt;

    /**
     * Constructor for the text button object
     *
     * @param x       bottom left x coordinate of the button
     * @param y       bottom left y coordinate of the button
     * @param width   width of the button
     * @param height  height of the button
     * @param text    the text to show on the button
     * @param font    the font to use when the button is inactive
     * @param fontAlt the font to use when the button is touched
     */
    public TextButton(float x, float y, float width, float height, String text,
                      BitmapFont font, BitmapFont fontAlt) {
        super(x, y, width, height);

        textObject = new TextObject(x, y, width, height, font, text);

        this.font = font;
        this.fontAlt = fontAlt;
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        if (state == ButtonState.TOUCHED || state == ButtonState.RELEASED)
            textObject.setFont(fontAlt);
        else
            textObject.setFont(font);

        textObject.update(batch);
    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeDrawable() {
        textObject.dispose();
    }
}
