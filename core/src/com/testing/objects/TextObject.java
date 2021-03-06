package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.testing.BaseObject;
import com.testing.BaseScreen;
import com.testing.oti.OTIDrawable;

public class TextObject extends BaseObject implements OTIDrawable {
    protected BitmapFont font;
    protected GlyphLayout layout;

    protected String text;
    protected String fontPath;

    protected Rectangle bounds;

    public TextObject(float x, float y, float width, float height, String fontPath, String text) {
        bounds = new Rectangle(x, y, width, height);

        setText(text, fontPath);
    }

    /**
     * called every frame by the {@link BaseScreen} containing this object
     *
     * @param batch The {@link SpriteBatch} to use for rendering
     */
    @Override
    public void updateDrawable(SpriteBatch batch) {
        font.draw(batch, text, bounds.x + bounds.width/2 - layout.width/2, bounds.y +  layout.height/2 + bounds.height/2);
    }

    /**
     * called when the object is no longer needed
     */
    @Override
    public void disposeDrawable() {
        font.dispose();
    }

    public void setText(String newText) {
        text = newText;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (bounds.height);
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
        layout = new GlyphLayout();
        layout.setText(font, newText);

        // check if the text is too long and reduce the text height if it is
        if (layout.width > bounds.width){
            font.dispose();
            parameter.size = (int) (bounds.height * (bounds.width / layout.width));
            parameter.color = Color.WHITE;
            font = generator.generateFont(parameter);
            layout = new GlyphLayout();
            layout.setText(font, newText);
        }

        generator.dispose();
    }

    public void setText(String newTex, String newFontPath) {
        fontPath = newFontPath;
        setText(newTex);
    }
}
