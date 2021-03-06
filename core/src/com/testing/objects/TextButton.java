package com.testing.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;

public class TextButton extends Button implements OTIDrawable {
    protected TextObject textObject;

    /**
     * Constructor for the text button object
     *
     * @param x      bottom left x coordinate of the button
     * @param y      bottom left y coordinate of the button
     * @param width  width of the button
     * @param height height of the button
     * @param text   the text to show on the button
     */
    public TextButton(float x, float y, float width, float height, String text) {
        super(x, y, width, height);

        //todo make a way to customise things like font and parameters
        FreeTypeFontGenerator.FreeTypeFontParameter parameters =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.color = new Color(0xf600ffff);
        parameters.borderColor = new Color(0x303030ff);
        parameters.borderWidth = 3f;

        textObject = new TextObject(x, y, width, height, "font/OfficeCodePro-Light.otf",
                text, parameters);
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        //todo there is probably a faster way of doing this that isn't just making a new font
        if (state == ButtonState.TOUCHED) {
            FreeTypeFontGenerator.FreeTypeFontParameter parameters =
                    new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameters.color = new Color(0x900098ff);
            parameters.borderColor = new Color(0x303030ff);
            parameters.borderWidth = 3f;

            textObject.setFontParameters(parameters);
        }

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
