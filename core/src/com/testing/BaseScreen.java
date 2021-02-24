package com.testing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.List;

public abstract class BaseScreen implements Screen {
    /**
     * Every {@link BaseObject} the screen contains must be in this list
     * <p>
     * The screen automatically calls {@link BaseObject#init()}, {@link BaseObject#update()}
     * and {@link BaseObject#clean()} on all contained objects when appropriate. This ensures
     * all objects are initialised, updated and disposed of when expected. It also ensures all
     * type functionality inherited from OTIs are called.
     * <p>
     * The only things that should not be stored in here are flags, counters and other atomic
     * attributes.
     */
    protected List<BaseObject> objects;

    /**
     * Calls {@link BaseObject#init()} on all contained {@link BaseObject}
     */
    public final void init() {
        for (BaseObject object : objects)
            object.init();
    }

    /**
     * Calls {@link BaseObject#update()} on all contained {@link BaseObject}
     */
    public final void update() {
        for (BaseObject object : objects)
            object.update();
    }

    /**
     * Calls {@link BaseObject#clean()} on all contained {@link BaseObject}
     */
    public final void clean() {
        for (BaseObject object : objects)
            object.clean();
    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

    }

    /**
     * @param width  width
     * @param height height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }
}
