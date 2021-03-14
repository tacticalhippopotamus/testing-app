package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.TextureObject;

public class OptionsScreen extends BaseScreen {

    public OptionsScreen(TestingApp game) {
        super(game);

        background = new TextureObject("screen_bg/options_screen_bg");
    }

    /**
     * Custom update method to be overwritten. Is called before anything else in the render loop
     *
     * @return return false if the screen is being switched this frame.
     */
    @Override
    protected boolean screenUpdate() {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(new MainMenuScreen(game));
            return false;
        }

        return true;
    }
}
