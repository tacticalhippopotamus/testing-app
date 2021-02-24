package com.testing.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

/**
 * Main class to manage all sound.
 * <p>
 * This is a singleton class. The intended method to use it is to get a reference to the instance,
 * then call all methods on that reference. Initialization will happen when the instance is obtained
 * for the first time.
 * <p>
 * Stores both sound effects and music. Can play, stop (music only) and change volume.
 * Relies on {@link Sample} and {@link Track} enums to supply the paths to the sound files.
 */
public class SoundEngine {
    private static final SoundEngine instance = new SoundEngine();

    /**
     * Stores {@link Sample}s and the {@link Sound} objects corresponding to them
     */
    private final HashMap<Sample, Sound> samples = new HashMap<>();

    /**
     * Stores the currently playing track
     */
    private Music music;


    private float trackVolume = 1.0f;
    private float sampleVolume = 1.0f;


    /**
     * Initializes {@link Sound}s.
     * <p>
     * For every {@link Sample} a {@link Sound} is initialized from the {@link Sample#path} field.
     * This happens the first time {@link SoundEngine#getInstance()} is called.
     */
    private SoundEngine() {
        for (Sample s : Sample.values()) {
            samples.put(s, Gdx.audio.newSound(Gdx.files.internal(s.path)));
        }

    }

    public static SoundEngine getInstance() {
        return instance;
    }

    public void play(Sample sample) {
        samples.get(sample).play(sampleVolume);
    }

    /**
     * Plays a sound track
     * <p>
     * If a {@link Music} has already been created, it is stopped and disposed of.
     * The new {@link Music} is loaded from the {@link Track}, its volume and looping state are set,
     * then it is played.
     *
     * @param track Track to be played
     */
    public void play(Track track) {
        if (music != null) {
            music.stop();
            music.dispose();
        }

        music = Gdx.audio.newMusic(Gdx.files.internal(track.path));
        music.setVolume(trackVolume);
        music.play();
        music.setLooping(true);
    }

    /**
     * Sets the volume for all samples.
     * <p>
     * SIDE EFFECT: value of the field {@link SoundEngine#sampleVolume} is changed in order to affect the volume of
     * the next {@link Sound } to be played.
     *
     * @param volume new volume of {@link Sound}s
     */
    public void setSampleVolume(float volume) {
        sampleVolume = volume;
    }

    /**
     * Sets the volume for the currently playing {@link Music}, and all future {@link Music}s.
     * <p>
     * SIDE EFFECT: value of the field {@link SoundEngine#trackVolume} is changed in order to affect the volume of
     * the next {@link Music } to be played.
     *
     * @param volume new volume for the current {@link Music}, and for all future {@link Music}s.
     */
    public void setTrackVolume(float volume) {
        trackVolume = volume;
        music.setVolume(volume);
    }

    public void pauseTrack() {
        music.pause();
    }

    public void unpauseTrack() {
        music.play();
    }

    public void dispose(Sample sample) {
        samples.get(sample).dispose();
    }
}