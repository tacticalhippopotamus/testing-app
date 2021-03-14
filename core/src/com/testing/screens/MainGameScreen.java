package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.TextureObject;
import com.testing.objects.logic.GameLogic;

public class MainGameScreen extends BaseScreen {


    public MainGameScreen(TestingApp game, int level) {
        super(game);

        // TODO: this is not balanced at all and is only used to check if level selection affects the levels (it does)
        GameLogic gameLogic = new GameLogic((level / 2) + 3, (level / 4) + 2);
        objects.add(gameLogic);
        objects.addAll(gameLogic.getRects()); // this was not intentional

        background = new TextureObject("screen_bg/main_game_screen_bg2");
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
