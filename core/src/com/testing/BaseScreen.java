package com.testing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
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

    protected SpriteBatch batch;

    protected Texture background;

    protected Game game;

    public BaseScreen(Game game) {
        objects = new ArrayList<>();
        batch = new SpriteBatch();
        background = null;
        this.game = game;
    }

    /**
     * Calls {@link BaseObject#update()} on all contained {@link BaseObject}
     */
    public final void update() {
        if (!screenUpdate()) return;

        ScreenUtils.clear(0, 0, 0, 1);

        batch.begin();

        if (background != null)
            batch.draw(background, 0, 0, Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());

        for (BaseObject object : objects)
            object.update(batch);

        batch.end();
    }

    protected boolean screenUpdate() {
        return true;
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
        update();
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
        background.dispose();
        batch.dispose();
        for(BaseObject o : objects)
            o.dispose();
    }
}
