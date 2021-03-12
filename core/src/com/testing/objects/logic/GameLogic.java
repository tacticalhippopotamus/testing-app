package com.testing.objects.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.testing.BaseObject;
import com.testing.objects.RectangleButton;

import java.util.Arrays;
import java.util.List;

/**
 * Class containing main logic for the game.
 * <p>
 * when updated through {@link BaseObject#objectUpdate()}} the game is played.
 * {@link Sequence} and {@link GameLogic#rects} are updated in {@link com.testing.screens.MainGameScreen}
 */
public class GameLogic extends BaseObject {

    /**
     * List of buttons used to play the game.
     */
    private final RectangleButton[] rects;

    /**
     * {@link Sequence} object holding necessary data and some of the functionality
     */
    private final Sequence sequence;

    /**
     * How long the sequence of button presses is, not how big the grid it
     */
    private final int sequenceLength;

    private boolean success;

    /**
     * which iteration of the sequence is being played (not the current level)
     */
    private int round;

    /**
     * Constructor. Positions the buttons in a grid. Initializes the {@link Sequence}.
     * @param sequenceLength length of the sequence
     * @param gridSize length of one side of the grid (grid contains gridSize^2 buttons)
     */
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

    /**
     * Take different action depending what state the game is in.
     * <p>
     * PROMPT:
     *  phase of the game when the sequence is played
     *  squares are blinked in sequence (using {@link RectangleButton#blink(int frames)}
     * ANSWER:
     *  the user repeats back the sequence
     *  they enter it by pressing the buttons
     *  buttons blink when pressed
     *  input is recorded and stored by the sequence object
     * RESULT:
     *  this state can result from both success or failure
     *  in order to complete the level, the user has to succeed in all rounds
     *  {@link Sequence#isSuccess()} returns whether the user succeeded in the current round
     *  {@link GameLogic#success} holds information about success in all rounds
     *  from the result state, program goes to the next round and returns to IDLE
     *
     * @param roundLength how long is the currently shown sequence (not the total length of sequence)
     */
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

    /**
     * checking whether the user has not failed and the rounds have not ended
     */
    @Override
    protected void objectUpdate() {
        if (success && round < sequenceLength) {
            actOnState(round);
        } else {
            // TODO: do something with the value of success
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
