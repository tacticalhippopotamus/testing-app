package com.testing.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class SoundEngine {
    private static final SoundEngine single_instance = new SoundEngine();

    private final HashMap<Sample, Sound> samples = new HashMap<>();
    private Music music;

    private float trackVolume = 1.0f;
    private float sampleVolume = 1.0f;


    private SoundEngine() {
        System.out.println("Initializing SoundEngine");
        for (Sample s : Sample.values()) {
            samples.put(s, Gdx.audio.newSound(Gdx.files.internal(s.path)));
        }

    }

    public void play(Sample sample) {
        samples.get(sample).play(sampleVolume);
        System.out.println("Played " + sample.path);
    }

    public void play(Track track) {
        if(music != null){
            music.stop();
        }

        music = Gdx.audio.newMusic(Gdx.files.internal(track.path));
        music.setVolume(trackVolume);
        music.play();
        music.setLooping(true);
    }


    public void setSampleVolume(float volume){
        sampleVolume = volume;
    }


    public void setTrackVolume(float volume){
        trackVolume = volume;
        music.setVolume(volume);
    }

    public void pauseTrack(){
        music.pause();
    }

    public void unpauseTrack(){
        music.play();

    }


    public void dispose(Sample sample) {
        samples.get(sample).dispose();
    }

    public static SoundEngine getInstance() {
        return single_instance;
    }
}