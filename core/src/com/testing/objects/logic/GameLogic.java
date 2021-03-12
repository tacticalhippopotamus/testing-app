package com.testing.objects.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.testing.BaseObject;
import com.testing.objects.RectangleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLogic extends BaseObject {

    private final RectangleButton[] rects;
    private final Sequence sequence;
    private final List<Integer> inputSequence;

    private GameState state;

    public GameLogic(int sequenceLength, int gridSize) {

        state = GameState.PROMPT;

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

    }

    void stateCheck() {

        if (!sequence.isDone()) {
            if (sequence.isReady()) {
                state = GameState.PROMPT;
            } else {
                state = GameState.IDLE;
            }
            return;
        }

        if (sequence.isDone()) {
            state = GameState.ANSWER;
            return;
        }
    }


    @Override
    protected void objectUpdate() {
        stateCheck();
        switch (state) {
            case IDLE:
                break;
            case PROMPT:
                rects[sequence.yield()].blink(5);
                break;
            case ANSWER:
                for (int i = 0; i < rects.length; i++) {
                    if (rects[i].isReleased()) {
                        rects[i].blink(5);
                        inputSequence.add(i);
                    }
                }
                System.out.println(inputSequence);
                break;
            case RESULT:
                break;
        }

    }


    public List<RectangleButton> getRects() {
        return Arrays.asList(rects);
    }

    public Sequence getSequence() {
        return sequence;
    }
}
