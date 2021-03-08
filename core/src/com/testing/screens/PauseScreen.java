package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;
import com.testing.TestingApp;

public class PauseScreen extends BaseScreen {

    public PauseScreen(TestingApp game) {
        super(game);

        background = new Texture("texture/screen_bg/pause_screen_bg.png");
    }
}
