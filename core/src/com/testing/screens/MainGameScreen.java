package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;
import com.testing.objects.Button;

public class MainGameScreen extends BaseScreen {

    public MainGameScreen(Game game) {
        super(game);

        background = new Texture("texture/main_game_screen_bg.png");
    }
}
