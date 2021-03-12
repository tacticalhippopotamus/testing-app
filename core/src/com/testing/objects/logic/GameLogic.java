package com.testing.objects.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.testing.BaseObject;
import com.testing.objects.RectangleButton;

import java.util.Arrays;
import java.util.List;

public class GameLogic extends BaseObject {

    private final RectangleButton[] rects;
    private final Sequence sequence;
    private final int sequenceLength;

    private boolean success;
    private int round;

    public GameLogic(int sequenceLength, int gridSize) {
        this.sequenceLength = sequenceLength;

        success = true;
        round = 0;

        //TODO: better way to position buttons
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int gridOffsetX = screenWidth / 5;
        int buttonWithGap = (gridOffsetX * 3) / gridSize;
        int gridOffsetY = (screenHeight - (buttonWithGap * gridSize)) / 2;
        int gap = buttonWithGap / 10;
        rects = new RectangleButton[gridSize * gridSize];
        sequence = new Sequence(sequenceLength, gridSize);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // TODO: better colors
                rects[i * gridSize + j] = new RectangleButton(gridOffsetX, gridOffsetY, buttonWithGap - gap, buttonWithGap - gap,
                        new Color((float) i / gridSize, 0.7f, (float) j / gridSize, 1f));
                gridOffsetX += buttonWithGap;
            }
            gridOffsetY += buttonWithGap;
            gridOffsetX = screenWidth / 5;
        }

    }

    private void actOnState(int roundLength) {
        sequence.setLength(roundLength + 1);
        switch (sequence.getState()) {
            case IDLE:
                break;
            case PROMPT:
                int yield;
                if ((yield = sequence.yield()) >= 0) {
                    rects[yield].blink(5);
                }
                break;
            case ANSWER:
                for (int i = 0; i < rects.length; i++) {
                    if (rects[i].isReleased()) {
                        rects[i].blink(5);
                        sequence.input(i);
                    }
                }
                break;
            case RESULT:
                success = sequence.isSuccess() && success;
                round++;
                sequence.setState(GameState.IDLE);
                break;
        }

    }

    @Override
    protected void objectUpdate() {
        if (success && round < sequenceLength) {
            actOnState(round);
        } else {
            System.out.println(success ? "success" : "no");
        }
    }


    public List<RectangleButton> getRects() {
        return Arrays.asList(rects);
    }

    public Sequence getSequence() {
        return sequence;
    }
}
