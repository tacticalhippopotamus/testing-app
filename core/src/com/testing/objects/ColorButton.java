package com.testing.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.testing.oti.OTIDrawable;

public class ColorButton extends Button implements OTIDrawable {

    // FIXME: This is a mess

    private final static ShapeRenderer renderer = new ShapeRenderer();
    static int blinkCount = 0; // this should have been static in this method
    private final Color originalColor;
    private Color color;
    private byte blink = BlinkState.NONE;

    /**
     * Constructor for the generic button object
     *
     * @param x      bottom left x coordinate of the button
     * @param y      bottom left y coordinate of the button
     * @param width  width of the button
     * @param height height of the button
     */
    public ColorButton(float x, float y, float width, float height, Color color) {
        super(x, y, width, height);
        this.color = color;
        originalColor = color.cpy();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void lighten() {
        color.add(Color.DARK_GRAY);
    }

    public void restoreColor() {
        // I think this is the cheapest copy of this object (without copying the reference)
        color.a = originalColor.a;
        color.r = originalColor.r;
        color.g = originalColor.g;
        color.b = originalColor.b;
    }

    public void blink(int frames) {
        blink = BlinkState.BLINK;
        BlinkState.count = frames;
    }

    @Override
    protected void objectUpdate() {
        if (blink == BlinkState.BLINK) {
            lighten();
            blink = BlinkState.JUST;
        } else if (blink == BlinkState.JUST) {
            if (blinkCount < BlinkState.count) {
                blinkCount++;
            } else {
                restoreColor();
                blink = BlinkState.NONE;
                blinkCount = 0;
            }
        }
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
//        renderer.dispose();
//        renderer is static, disposing of it would be bad
    }

    private static class BlinkState {
        public static final byte NONE = 0;
        public static final byte JUST = 1;
        public static final byte BLINK = 2;

        public static int count = 0;
    }
}
