package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;
import com.testing.TestingApp;

public class OptionsScreen extends BaseScreen {

    public OptionsScreen(TestingApp game) {
        super(game);

        background = new Texture("texture/screen_bg/options_screen_bg.png");
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.BACK))
            game.setScreen(new MainMenuScreen(game));

        super.render(delta);
    }
}
