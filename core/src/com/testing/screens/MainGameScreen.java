package com.testing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.RectangleButton;
import com.testing.objects.TextureObject;
import com.testing.objects.logic.Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainGameScreen extends BaseScreen {

    private final RectangleButton[] rects;
    private final Sequence sequence;
    private final List<Integer> inputSequence;

    public MainGameScreen(TestingApp game) {
        super(game);

        byte gridSize = 2;


        background = new TextureObject("screen_bg/main_game_screen_bg2");

        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int gridOffsetX = screenWidth / 5;
        int buttonWithGap = (gridOffsetX * 3) / gridSize;
        int gridOffsetY = (screenHeight - (buttonWithGap * gridSize)) / 2;
        int gap = buttonWithGap / 10;
        rects = new RectangleButton[gridSize * gridSize];
        sequence = new Sequence(3, gridSize);
        inputSequence = new ArrayList<>();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                rects[i * gridSize + j] = new RectangleButton(gridOffsetX, gridOffsetY, buttonWithGap - gap, buttonWithGap - gap,
                        new Color((float) i / gridSize, (float) j / gridSize, 0.7f, 1f));
                gridOffsetX += buttonWithGap;
            }
            gridOffsetY += buttonWithGap;
            gridOffsetX = screenWidth / 5;
        }
        objects.addAll(Arrays.asList(rects));
        objects.add(sequence);
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
        if (sequence.isDone()) {
            for (int i = 0; i < rects.length; i++) {
                if (rects[i].isReleased()) {
                    rects[i].blink(5);
                    inputSequence.add(i);
                }
            }
            System.out.println(inputSequence);
        }

        if (sequence.isReady() && !sequence.isDone()) {
            rects[sequence.yield()].blink(5);
        }

        return true;
    }
}
