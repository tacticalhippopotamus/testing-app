package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;
import com.testing.objects.Button;

public class MainMenuScreen extends BaseScreen {
    protected Button playButton;

    public MainMenuScreen(Game game) {
        super(game);

        playButton = new Button(
                Gdx.app.getGraphics().getWidth() / 2f - 450,
                Gdx.app.getGraphics().getHeight() / 2f - 100,
                900, 200, "texture/main_menu_play_button");

        objects.add(playButton);

        background = new Texture("texture/main_menu_screen_bg.png");
    }

    @Override
    public boolean screenUpdate() {
        if (playButton.isReleased()) {
            game.setScreen(new MainGameScreen(game));
            return false;
        }

        return true;
    }
}
