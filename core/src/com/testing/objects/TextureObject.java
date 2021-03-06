package com.testing.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.testing.BaseObject;
import com.testing.oti.OTITexture;


public class TextureObject extends BaseObject implements OTITexture {
    private final static FileHandle pathToAtlas = Gdx.files.internal("pack/pack.atlas");
    private final static TextureAtlas atlas = new TextureAtlas(pathToAtlas);
    private TextureAtlas.AtlasRegion region;

    TextureObject(String path) {
        region = atlas.findRegion(path);
    }

    @Override
    public void disposeTexture() {
        atlas.dispose();
    }

    public TextureRegion getRegion() {
        return region;
    }
}
