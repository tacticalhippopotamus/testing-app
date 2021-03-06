package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.testing.BaseObject;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;

public class TextObject extends BaseObject implements OTIDrawable {
    protected BitmapFont font;
    protected GlyphLayout layout;
    protected String text;
    protected String fontPath;
    protected Rectangle bounds;
    protected float fontScale;
    protected boolean isGivenExternalFont;
    FreeTypeFontGenerator.FreeTypeFontParameter fontParameters;

    /**
     * Constructor for the text object with font parameters
     *
     * @param x              the bottom left x coordinate of the object
     * @param y              the bottom left y coordinate of the object
     * @param width          the width of the object
     * @param height         the height of the object
     * @param fontPath       the path to the font to use
     * @param text           the text to display
     * @param fontParameters {@see FreeTypeFontGenerator.FreeTypeFontParameter}
     */
    public TextObject(float x, float y, float width, float height, String fontPath, String text,
                      FreeTypeFontGenerator.FreeTypeFontParameter fontParameters) {
        this.bounds = new Rectangle(x, y, width, height);
        this.fontPath = fontPath;
        this.text = text;
        this.fontParameters = fontParameters;
        this.fontScale = 1f;

        isGivenExternalFont = false;

        scaleFont();
        regenFont();
    }

    /**
     * Constructor for the text object with default font parameters
     *
     * @param x        the bottom left x coordinate of the object
     * @param y        the bottom left y coordinate of the object
     * @param width    the width of the object
     * @param height   the height of the object
     * @param fontPath the path to the font to use
     * @param text     the text to display
     */
    public TextObject(float x, float y, float width, float height, String fontPath, String text) {
        this(x, y, width, height, fontPath, text,
                new FreeTypeFontGenerator.FreeTypeFontParameter());
    }

    public TextObject(float x, float y, float width, float height, BitmapFont font, String text) {
        this.bounds = new Rectangle(x, y, width, height);
        this.text = text;
        this.fontScale = 1f;
        this.font = font;

        isGivenExternalFont = true;

        scaleFont();
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        float oldScale = font.getScaleX();
        font.getData().setScale(fontScale);
        font.draw(batch, text,
                bounds.x + bounds.width / 2 - (layout.width * fontScale) / 2,
                bounds.y + (layout.height * fontScale) / 2 + bounds.height / 2);
        font.getData().setScale(oldScale);
    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeDrawable() {
        if (!isGivenExternalFont) font.dispose();
    }

    /**
     * regenerate the font and scaling attributes
     */
    protected void regenFont() {
        //todo find a way to improve font quality
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        fontParameters.size = 72;//(int) (bounds.height);
        font = generator.generateFont(fontParameters);
        generator.dispose();

        // todo find a way to reimplement this
        // REMOVED DUE TO BEING TOO SLOW
        // check if the text is too long and reduce the text height if it is
        //if (layout.width > bounds.width) {
        //    font.dispose();
        //    parameters.size = (int) (bounds.height * (bounds.width / layout.width));
        //    font = generator.generateFont(parameters);
        //    layout = new GlyphLayout();
        //    layout.setText(font, text);
        //}
    }

    protected void scaleFont() {
        layout = new GlyphLayout();
        layout.setText(font, text);
        // scale the font to fill the area
        fontScale = Math.min(bounds.width / layout.width, bounds.height / layout.height);
    }

    /**
     * set the display text
     *
     * @param newText new text
     */
    public void setText(String newText) {
        text = newText;
        if (!isGivenExternalFont)
            regenFont();
        scaleFont();
    }

    /**
     * set the display font
     *
     * @param newFontPath new font path
     */
    public void setFont(String newFontPath) {
        fontPath = newFontPath;
        if (!isGivenExternalFont)
            regenFont();
        scaleFont();
    }

    /**
     * set the display font
     *
     * @param newFont new font
     */
    public void setFont(BitmapFont newFont) {
        font = newFont;
        scaleFont();
    }

    /**
     * set the font parameters
     *
     * @param newParameters new font parameters
     */
    public void setFontParameters(FreeTypeFontGenerator.FreeTypeFontParameter newParameters) {
        fontParameters = newParameters;
        if (!isGivenExternalFont)
            regenFont();
        scaleFont();
    }
}
