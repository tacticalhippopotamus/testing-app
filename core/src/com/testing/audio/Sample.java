package com.testing.audio;


/**
 * Stores all paths to sound effect files.
 * <p>
 *
 * Used to refer to specific sound effect.
 */
public enum Sample {
    WOOSH("sound/woosh.wav"),
    PLUCK("sound/pluck.wav")
    ;


    public final String path;
    Sample(String path) {
        this.path = path;
    }
}
