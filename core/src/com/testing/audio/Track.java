package com.testing.audio;

public enum Track {
    /*
    Crediting thing:

    Wholesome by Kevin MacLeod
    Link: https://incompetech.filmmusic.io/song/5050-wholesome
    License: https://filmmusic.io/standard-license
     */

    THEME("sound/kevin_macleod_wholesome.ogg");

    public final String path;
    Track(String path){
        this.path = path;
        System.out.println("Loaded " + this.name());
    }
}
