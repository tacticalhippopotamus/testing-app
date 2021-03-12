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

    public GameLogic(int sequenceLength, int gridSize) {


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


    @Override
    protected void objectUpdate() {
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
    }


    public List<RectangleButton> getRects() {
        return Arrays.asList(rects);
    }

    public Sequence getSequence() {
        return sequence;
    }
}
