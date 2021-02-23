package com.testing.audio;


public enum Sample {
    WOOSH("sound/woosh.wav"),
    PLUCK("sound/pluck.wav")
    ;


    public final String path;
    Sample(String path) {
        this.path = path;
        System.out.println("Loaded " + this.name());
    }
}
