package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Pair;

/**
 * A creature.
 */
abstract class Creature {

    /**
     * How this creature appears on the screen.
     */
    String appearance;

    /**
     * This creature's vertical coordinate.
     */
    int vertical;

    /**
     * This creature's horizontal coordinate.
     */
    int horizontal;

    Paint paintText = new Paint();

    /**
     * Constructs a new Creature.
     */
    Creature() {
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * Set this item's location.
     *
     * @param vert  the vertical coordinate.
     * @param horiz the horizontal coordinate.
     */
    void setLocation(int vert, int horiz) {
        if (vert > 0 && vert < FishTankManager.getGridHeight()) {
            vertical = vert;
        } else if (vert < 0) {
            vertical = 0;
        } else {
            vertical = FishTankManager.getGridHeight();
        }
        if (horiz > 0 && horiz < FishTankManager.getGridWidth()) {
            horizontal = horiz;
        } else if (horiz < 0) {
            horizontal = 0;
        } else {
            horizontal = FishTankManager.getGridWidth();
        }
    }

    /**
     * Draws the given string in the given graphics context at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s      the string to draw.
     * @param vert      the x-coordinate of the string's cursor location.
     * @param horiz     the y-coordinate of the string's cursor location.
     */
    void drawString(Canvas canvas, String s, int vert, int horiz) {
        canvas.drawText(s, horiz * FishTankView.charWidth, vert * FishTankView.charHeight, paintText);
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    void draw(Canvas canvas) {
        drawString(canvas, appearance, vertical, horizontal);
    }

    /**
     * Gives you the coordinates of the creature.
     *
     * @return a pair of integers, or coordinates
     */
    Pair<Integer, Integer> getLocation(){
        return new Pair<>(vertical, horizontal);
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    abstract void move();
}
