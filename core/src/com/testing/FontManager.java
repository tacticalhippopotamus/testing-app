package com.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontManager {
    public static BitmapFont fontTest;

    public static BitmapFont font72;
    public static BitmapFont font72Alt;

    public static BitmapFont font256;
    public static BitmapFont font256Alt;

    public static void generateFonts() {
        FreeTypeFontGenerator generator =
                new FreeTypeFontGenerator(Gdx.files.internal("font/OfficeCodePro-Light.otf"));

        fontTest = generateGenericFont(generator,
                72, 0x00ff00ff, 0xffff00ff, 4f);

        font72 = generateGenericFont(generator, 72, 0xf600ffff, 0x303030ff, 3f);
        font72Alt = generateGenericFont(generator, 72, 0x900098ff, 0x303030ff, 3f);

        font256 = generateGenericFont(generator, 256, 0xf600ffff, 0x303030ff, 3f);
        font256Alt = generateGenericFont(generator, 256, 0x900098ff, 0x303030ff, 3f);

        generator.dispose();
    }

    public static void disposeFonts() {
        fontTest.dispose();
    }

    /**
     * Generates a font with the given parameters
     *
     * @param generator    the generator to use (this contains the font file path)
     * @param size         the height in pixels for the font
     * @param colour       the main colour of the font in rgba8888 hex format
     * @param borderColour the border colour of the font in rgba8888 hex format
     * @param borderWidth  the width of the border for the font
     * @return the generated font
     */
    public static BitmapFont generateGenericFont(FreeTypeFontGenerator generator, int size,
                                                 int colour,int borderColour, float borderWidth) {
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = size;
        fontParameters.color = new Color(colour);
        fontParameters.borderColor = new Color(borderColour);
        fontParameters.borderWidth = borderWidth;
        return generator.generateFont(fontParameters);
    }

}
