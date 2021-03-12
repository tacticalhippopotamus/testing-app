package com.testing.objects.logic;

import com.testing.BaseObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence extends BaseObject {
    private final static Random rng = new Random();

    private final List<Integer> sequence;
    private final int length;
    private final int delayFrames;
    private int current = -1;
    private int delayCount = 0;


    private boolean success = true;


    private GameState state;

    public Sequence(int sequenceLength, int gridSize, int delayFrames) {
        this.length = sequenceLength;
        this.delayFrames = delayFrames;

        state = GameState.IDLE;
        sequence = new ArrayList<>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++) {
            // NOTE: can be ThreadLocalRandom.current().nextInt(min, max); in java 7,
            // but that requires higher API level then what we're compiling with
            sequence.add(rng.nextInt(gridSize * gridSize));
        }
    }

    public Sequence(int length, int gridSize) {
        this(length, gridSize, 30);
    }

    public int yield() {
        current++;
        if (current < length) {
            return sequence.get(current);
        }
        state = GameState.ANSWER;
        current = -1;
        return -1;
    }


    public void input(int i) {
        current++;
        if (current < length) {
            success = sequence.get(current) == i;
            if (!success || current == length - 1) {
                state = GameState.RESULT;
            }
            return;
        }
        state = GameState.RESULT;
    }

    private void delayCounter() {
        if (state == GameState.IDLE || state == GameState.PROMPT) {
            delayCount++;
            if (delayCount < delayFrames) {
                state = GameState.IDLE;
                return;
            }

            state = GameState.PROMPT;
            delayCount = 0;
        }
    }

    public GameState getState() {
        return state;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    protected void objectUpdate() {
        delayCounter();
    }

}
