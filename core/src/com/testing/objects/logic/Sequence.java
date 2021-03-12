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
    private boolean ready = false;
    private int delayCount = 0;


    private boolean done = false;

    public Sequence(int length, byte gridSize, int delayFrames) {
        this.length = length;
        this.delayFrames = delayFrames;
        sequence = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            // NOTE: can be ThreadLocalRandom.current().nextInt(min, max); in java 7,
            // but that requires higher API level then what we're compiling with
            sequence.add(rng.nextInt(gridSize * gridSize));
        }
    }

    public Sequence(int length, byte gridSize) {
        this(length, gridSize, 30);
    }

    public int yield() {
        current++;
        if (current < length) {
            return sequence.get(current);
        }
        done = true;
        return 0;
    }

    public List<Integer> getSequence() {
        return sequence;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    protected void objectUpdate() {
        delayCount++;
        if (delayCount < delayFrames) {
            ready = false;
            return;
        }
        ready = true;
        delayCount = 0;
    }

}
