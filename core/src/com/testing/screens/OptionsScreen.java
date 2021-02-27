package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;

public class OptionsScreen extends BaseScreen {

    public OptionsScreen(Game game) {
        super(game);

        background = new Texture("texture/options_screen_bg.png");
    }
}
