package com.testing.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.testing.oti.OTIDrawable;

public class RectangleButton extends Button implements OTIDrawable {

    private final ShapeRenderer renderer;
    private Color color;
    private Color originalColor;
    private byte blink = BlinkState.NONE;

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

    public void restoreColor(){
        //FIXME: this is also bad, needless allocation
        color = originalColor.cpy();
    }

    public void blink(int frames){
        blink = BlinkState.BLINK;
        BlinkState.count = frames;
    }

    static int blinkCount = 0; // this should have been static in this method
    @Override
    protected void objectUpdate(){
        if(blink == BlinkState.BLINK){
            lighten();
            blink = BlinkState.JUST;
        } else if(blink == BlinkState.JUST){
            if(blinkCount < BlinkState.count){
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
        renderer.dispose();
    }

    private static class BlinkState{
        public static final byte NONE = 0;
        public static final byte JUST = 1;
        public static final byte BLINK = 2;

        public static int count = 0;
    }
}
