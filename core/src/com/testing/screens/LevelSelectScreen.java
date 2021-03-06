package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;

public class LevelSelectScreen extends BaseScreen {
    /**
     * Initialises the screen with default, empty, values
     *
     * @param game a reference to the main game object
     */
    public LevelSelectScreen(Game game) {
        super(game);

        background = new Texture("texture/main_menu_screen_bg.png");
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
