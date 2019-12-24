package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A bubble.
 */
class Bubble extends Creature {

    /**
     * Use for random movement left and right.
     */
    private double rng;

    /**
     * Creates a new bubble.
     */
    Bubble() {
        super();
        paintText.setColor(Color.LTGRAY);
        appearance = ".";
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    @Override
    void move() {
        rng = Math.random();
        if (rng < 0.33) {
            floating();
        } else if (rng < 0.66) {
            horizontal += 1;
            floating();
        } else {
            horizontal -= 1;
            floating();
        }
        if (vertical > FishTankManager.getGridHeight() || vertical < 0) {
            FishTankManager.grid.remove(this);
        }
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation, moving straight up.
     */
    private void floating() {
        vertical--;
        rng = Math.random();
        if (rng < 0.05) {
            if (appearance.equals(".")) appearance = "o";
            else if (appearance.equals("o")) appearance = "O";
        }
    }
}
