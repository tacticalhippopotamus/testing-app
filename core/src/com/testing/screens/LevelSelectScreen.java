package com.testing.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.testing.BaseScreen;
import com.testing.FontManager;
import com.testing.TestingApp;
import com.testing.objects.TextButton;

public class LevelSelectScreen extends BaseScreen {
    protected TextButton[] textButtons;

    /**
     * Initialises the screen with default, empty, values
     *
     * @param game a reference to the main game object
     */
    public LevelSelectScreen(TestingApp game) {
        super(game);

        background = new Texture("texture/level_select_screen_bg.png");

        textButtons = new TextButton[26];

        // todo make this less of a mess
        // place all buttons (layout in texture/level_select_screen_bg_layout.png)
        float buttonWidth = 0.156f * Gdx.graphics.getWidth();
        float buttonHeight = 0.0875f * Gdx.graphics.getHeight();
        float xOffset = 0.102f * Gdx.graphics.getWidth();
        float yOffset = 0.249f * Gdx.graphics.getHeight();
        float xGap = 0.005f * Gdx.graphics.getWidth();
        float yGap = 0.017f * Gdx.graphics.getHeight();

        for (int i = 0; i < 25; i++) {
            float yOddYOffset = 0.0365f * Gdx.graphics.getHeight() + buttonHeight / 8;

            if ((i / 5) % 2 == 0) {
                if (i % 2 == 0)
                    yOddYOffset = 0f;
            } else {
                if (i % 2 == 1)
                    yOddYOffset = 0f;
            }

            textButtons[i] = new TextButton(
                    xOffset + (i % 5) * (xGap + buttonWidth),
                    Gdx.graphics.getHeight() - (yOffset + buttonHeight +
                            (i / 5) * (yGap + buttonHeight)) + buttonHeight / 4 - yOddYOffset,
                    buttonWidth,
                    buttonHeight / 2,
                    String.valueOf((char) (((int) 'a') + i)),
                    FontManager.font72, FontManager.font72Alt);
            objects.add(textButtons[i]);
        }

        // place z, he's special and needs placing on his own 😠
        textButtons[25] = new TextButton(
                0.426f * Gdx.graphics.getWidth(),
                0.145f * Gdx.graphics.getHeight() + buttonHeight / 4,
                buttonWidth, buttonHeight / 2, "z",
                FontManager.font72, FontManager.font72Alt);
        objects.add(textButtons[25]);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.BACK))
            game.setScreen(new MainMenuScreen(game));

        super.render(delta);
    }

    /**
     * Custom update method to be overwritten. Is called before anything else in the render loop
     *
     * @return return false if the screen is being switched this frame.
     */
    @Override
    protected boolean screenUpdate() {
        for (int i = 0; i < 26; i++)
            if (textButtons[i].isReleased()) {
                // todo make the index of the button effect the type of main game created
                //  ie. make it more difficult for higher indexes
                game.setScreen(new MainGameScreen(game));
                this.dispose();
                return false;
            }

        return true;
    }
}
