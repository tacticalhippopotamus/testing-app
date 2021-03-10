package com.testing.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.testing.oti.OTIDrawable;

public class RectangleButton extends Button implements OTIDrawable {

    private final ShapeRenderer renderer;
    private Color color;

    /**
     * Constructor for the generic button object
     *
     * @param x      bottom left x coordinate of the button
     * @param y      bottom left y coordinate of the button
     * @param width  width of the button
     * @param height height of the button
     */
    public RectangleButton(float x, float y, float width, float height, Color color) {
        super(x, y, width, height);
        // FIXME: this is extremely very bad, have one renderer for every button
        renderer = new ShapeRenderer();
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void lighten() {
        float res;
        color.r = (res = color.r + 0.1F) < 1 ? res: 1f;
        color.g = (res = color.g + 0.1F) < 1 ? res: 1f;
        color.b = (res = color.b + 0.1F) < 1 ? res: 1f;
    }

    @Override
    public void updateDrawable(SpriteBatch batch) {
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        renderer.end();
        batch.begin();
    }

    @Override
    public void disposeDrawable() {
        renderer.dispose();
    }
}
