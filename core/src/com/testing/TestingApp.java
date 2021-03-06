package com.testing;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.testing.screens.MainMenuScreen;

public class TestingApp extends Game {
    public BitmapFont font72;
    public BitmapFont font72Alt;

    public BitmapFont font256;
    public BitmapFont font256Alt;

    @Override
    public void create() {
        // enable the debug log output
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // enable catching of the android back key
        Gdx.input.setCatchKey(Input.Keys.BACK, true);

        generateFonts();

        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }

    protected void generateFonts(){

        FreeTypeFontGenerator generator =
                new FreeTypeFontGenerator(Gdx.files.internal("font/OfficeCodePro-Light.otf"));

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters72 =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters72.size = 72;
        fontParameters72.color = new Color(0xf600ffff);
        fontParameters72.borderColor = new Color(0x303030ff);
        fontParameters72.borderWidth = 3f;
        font72 = generator.generateFont(fontParameters72);

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters72Alt =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters72Alt.size = 72;
        fontParameters72Alt.color = new Color(0xf600ffff);
        fontParameters72Alt.borderColor = new Color(0x303030ff);
        fontParameters72Alt.borderWidth = 3f;
        font72Alt = generator.generateFont(fontParameters72Alt);

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters256 =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters256.size = 72;
        fontParameters256.color = new Color(0xf600ffff);
        fontParameters256.borderColor = new Color(0x303030ff);
        fontParameters256.borderWidth = 3f;
        font256 = generator.generateFont(fontParameters256);

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters256Alt =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters256Alt.size = 72;
        fontParameters256Alt.color = new Color(0xf600ffff);
        fontParameters256Alt.borderColor = new Color(0x303030ff);
        fontParameters256Alt.borderWidth = 3f;
        font256Alt = generator.generateFont(fontParameters256Alt);

        generator.dispose();
    }
}
