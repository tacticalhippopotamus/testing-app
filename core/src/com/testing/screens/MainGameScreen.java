package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.TextureObject;

public class MainGameScreen extends BaseScreen {

    public MainGameScreen(TestingApp game) {
        super(game);

        background = new TextureObject("screen_bg/main_game_screen_bg");
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
