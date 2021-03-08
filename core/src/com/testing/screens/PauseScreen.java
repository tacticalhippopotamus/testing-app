package com.testing.screens;

import com.testing.BaseScreen;
import com.testing.TestingApp;
import com.testing.objects.TextureObject;

public class PauseScreen extends BaseScreen {

    public PauseScreen(TestingApp game) {
        super(game);

        background = new TextureObject("screen_bg/pause_screen_bg");
    }
}
