package com.testing.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class SoundEngine {
    private static final SoundEngine single_instance = new SoundEngine();

    private final HashMap<Sample, Sound> samples = new HashMap<>();

    private SoundEngine() {
        System.out.println("Initializing SoundEngine");
        for (Sample s : Sample.values()) {
            samples.put(s, Gdx.audio.newSound(Gdx.files.internal(s.path)));
        }

    }

    public void play(Sample sample) {
        samples.get(sample).play();
        System.out.println("Played " + sample.path);
    }



    public void dispose(Sample sample) {
        samples.get(sample).dispose();
    }

    public static SoundEngine getInstance() {
        return single_instance;
    }
}