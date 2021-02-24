package com.testing.audio;

/**
 * Stores all paths to music tracks files.
 * <p>
 * Used to refer to specific tracks
 */
public enum Track {
    /*
    Crediting thing:

    Wholesome by Kevin MacLeod
    Link: https://incompetech.filmmusic.io/song/5050-wholesome
    License: https://filmmusic.io/standard-license
     */
    THEME("sound/kevin_macleod_wholesome.ogg");

    public final String path;

    Track(String path) {
        this.path = path;
    }
}
