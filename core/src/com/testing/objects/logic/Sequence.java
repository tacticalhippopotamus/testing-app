package com.testing.objects.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Data and basic functionality for {@link GameLogic}
 */
public class Sequence {
    private final static Random rng = new Random();

    /**
     * full length sequence of buttons.
     */
    private final List<Integer> sequence;


    /**
     * Current length of displayed sequence
     */
    private int length = 1;

    /**
     * Current position in the sequence
     */
    private int current = -1;


    private boolean success = true;

    private GameState state;

    /**
     * Full constructor. populates the sequence with random numbers (numbers can repeat).
     * numbers correspond to position in a grid
     *
     * @param sequenceLength how long the sequence is
     * @param gridSize       how long the side of the grid it
     */
    public Sequence(int sequenceLength, int gridSize) {
        state = GameState.IDLE;
        sequence = new ArrayList<>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++) {
            // NOTE: can be ThreadLocalRandom.current().nextInt(min, max); in java 7,
            // but that requires higher API level then what we're compiling with
            sequence.add(rng.nextInt(gridSize * gridSize));
        }
    }

    /**
     * Returns the next number from the sequence until {@link Sequence#length} numbers have been returned
     *
     * @return number from the sequence. -1 if no more numbers will be returned.
     */
    public int yield() {
        current++;
        if (current < length) {
            return sequence.get(current);
        }
        state = GameState.ANSWER;
        current = -1;
        return -1;
    }


    /**
     * takes the input from the user (the buttons user has pressed)
     * and compares them to the corresponding values in the sequence.
     * <p>
     * if the user fails or the sequence ends, game goes to the next state
     *
     * @param i user input
     */
    public void input(int i) {
        current++;
        if (current < length) {
            success = sequence.get(current) == i;
            if (!success || current == length - 1) {
                goToResults();
            }
            return;
        }
        goToResults();
    }

    public void goToResults() {
        state = GameState.RESULT;
        current = -1;

    }


    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
