package com.testing.objects;

public class TextButton extends Button{
    /**
     * Constructor for the generic button object
     * <p>
     * Textures for the button must be stored in the format:
     * - [base path]_inactive.png for the texture to show when the button is inactive
     * - [base path]_touched.png for the texture to show when the button is touched
     *
     * @param x               bottom left x coordinate of the button
     * @param y               bottom left y coordinate of the button
     * @param width           width of the button
     * @param height          height of the button
     * @param texturePathBase the base filename for all button textures, for example, "texture/my_button" would be the base for "texture/my_button_inactive.png" and "texture/my_button_touched.png"
     */
    public TextButton(float x, float y, float width, float height, String texturePathBase) {
        super(x, y, width, height, texturePathBase);
    }
}
