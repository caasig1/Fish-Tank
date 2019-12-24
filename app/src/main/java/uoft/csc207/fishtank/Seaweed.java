package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;

class Seaweed extends Creature {


    /**
     * The number of weed segments.
     */
    private int length;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    private boolean leanRight;

    /**
     * Creates a new seaweed Length segments tall.
     *
     * @param Length the number of segments this seaweed is tall.
     */
    Seaweed(int Length) {
        super();
        this.length = Length;
        paintText.setColor(Color.GREEN);
    }


    /**
     * Draws this fish tank item.  Looks lovely waving in the current, doesn't
     * it?
     *
     * @param canvas the graphics context in which to draw this item.
     */
    @Override
    void draw(Canvas canvas) {

        // WWhich way does the first segment lean?
        boolean lR = leanRight;

        for (int i = 0; i < length; i++) {// Draw a "/" seaweed segment: even numbered and leaning to the right.
            if (i % 2 == 0) {
                if (lR) {
                    drawString(canvas, "/", -i + vertical, (horizontal));
                } else {
                    drawString(canvas, "\\", -i + vertical, (horizontal));
                }
            } else {
                if (lR) {
                    drawString(canvas, "\\", -i + vertical, (horizontal));
                } else {
                    drawString(canvas, "/", -i + vertical, (horizontal));
                }
            }
        }
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    @Override
    void move() {
        leanRight = !leanRight;
    }

}