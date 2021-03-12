package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.TextureObject;
import com.testing.objects.logic.GameLogic;

public class MainGameScreen extends BaseScreen {

    private final GameLogic gameLogic;


    public MainGameScreen(TestingApp game) {
        super(game);

        gameLogic = new GameLogic(4, 3);
        objects.add(gameLogic);
        objects.addAll(gameLogic.getRects()); // this was not intentional
        objects.add(gameLogic.getSequence());


        background = new TextureObject("screen_bg/main_game_screen_bg2");
        objects.add(background); // Should this be here?
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
