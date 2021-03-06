package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;

public class PauseScreen extends BaseScreen {

    public PauseScreen(Game game) {
        super(game);

        background = new Texture("texture/pause_screen_bg.png");
    }
}
