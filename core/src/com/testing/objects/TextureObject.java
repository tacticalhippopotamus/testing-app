package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.testing.BaseObject;
import com.testing.oti.OTITexture;


/**
 * Class to manage textures.
 * <p>
 * Textures are stores in the texture atlas "pack.atlas". Within the atlas they are stored in pages.
 * Each directory in assets/texture is a page. Pages have a maximum size of 2048x2048.
 * The individual textures are accessed (as either {@link TextureRegion} or {@link Sprite})
 * by providing the path to the texture. However the "texture" directory has to be omitted from the path,
 * as well as the file extension.
 * <p>
 * E.g. The texture "assets/texture/example/test.png" will be referred to as "example/test"
 */
public class TextureObject extends BaseObject implements OTITexture {

    private final static FileHandle pathToAtlas = Gdx.files.internal("pack/pack.atlas");

    /**
     * The texture atlas, storing all the pages whose regions are used as textures.
     * It is static as the same one is used for all textures.
     */
    private static TextureAtlas atlas;

    /**
     * The name of the specific region
     */
    private final String path;

    /**
     * The {@link TextureAtlas#findRegion(String)} function returns a {@link TextureAtlas.AtlasRegion},
     * It is the texture region with some extra information regarding the atlas.
     */
    private TextureAtlas.AtlasRegion region;

    private Sprite sprite;

    /**
     * Name of the TextureRegion is recorded. If the atlas had not been constructed yet, it is now constructed.
     *
     * @param path name of the TextureRegion
     */
    public TextureObject(String path) {
        this.path = path;
        atlas = getAtlas();
    }

    /**
     * Checks if the atlas had been initialized. Initializes it if it has not been initialized.
     * Performance penalty of this "if" statement is practically non existent.
     *
     * @return either the newly initialized atlas, or the previously initialized atlas.
     */
    private static TextureAtlas getAtlas() {
        if (atlas == null) {
            atlas = new TextureAtlas(pathToAtlas);
        }
        return atlas;
    }

    /**
     * If the {@link TextureRegion}has been requested, but not yet found, it is found, recorded and returned.
     *
     * @return newly found or previously recorded region
     */
    public TextureRegion getRegion() {
        if (region == null) {
            region = atlas.findRegion(path);
        }
        return region;
    }

    /**
     * If the {@link Sprite} has been requested, but not yet found, it is found, recorded and returned.
     *
     * @return newly found or previously recorded sprite
     */
    public Sprite getSprite() {
        if (sprite == null) {
            sprite = atlas.createSprite(path);
        }
        return sprite;
    }

    /**
     * Disposes of all pages. No textures or sprites will be available after this function is called.
     * <p>
     * NOTE: Only call this function when you are certain no more textures from the current atlas
     * will be needed.
     */
    @Override
    public void disposeTexture() {
        /* FIXME: See https://github.com/tacticalhippopotamus/testing-app/issues/24 */
//        atlas.dispose();
    }

}
