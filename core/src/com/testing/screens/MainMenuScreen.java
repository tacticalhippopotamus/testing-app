package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.testing.BaseScreen;
import com.testing.FontManager;
import com.testing.TestingApp;
import com.testing.objects.Button;
import com.testing.objects.ImageButton;
import com.testing.objects.TextButton;
import com.testing.objects.TextureObject;

public class MainMenuScreen extends BaseScreen {
    protected Button playButton;
    protected Button settingsButton;

    public MainMenuScreen(TestingApp game) {
        super(game);

        playButton = new TextButton(
                Gdx.app.getGraphics().getWidth() / 2f - 450,
                Gdx.app.getGraphics().getHeight() / 2f - 200,
                Math.min(900, Gdx.app.getGraphics().getWidth()-20),
                400, "start",
                FontManager.font256, FontManager.font256Alt);

        settingsButton = new ImageButton(
                Gdx.app.getGraphics().getWidth() - 200, 0,
                200, 200, "buttons/main_menu_settings_button");

        objects.add(playButton);
        objects.add(settingsButton);

        background = new TextureObject("screen_bg/main_menu_screen_bg");
    }

    @Override
    public boolean screenUpdate() {
        if (playButton.isReleased()) {
            game.setScreen(new LevelSelectScreen(game));
            this.dispose();
            return false;
        }

        if (settingsButton.isReleased()) {
            game.setScreen(new OptionsScreen(game));
            this.dispose();
            return false;
        }

        return true;
    }
}
