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
    @Override
    public void create() {
        // enable the debug log output
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // enable catching of the android back key
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        // populate global fonts
        FontManager.generateFonts();

        //this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        FontManager.disposeFonts();
    }
}
