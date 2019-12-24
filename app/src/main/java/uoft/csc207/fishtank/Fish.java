package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A fish.
 */
class Fish extends Creature {

    /**
     * Indicates whether this fish is moving right.
     */
    private boolean goingRight;

    /**
     * Constructs a new fish.
     */
    Fish() {
        super();
        appearance = "><>";
        paintText.setColor(Color.CYAN);
        goingRight = true;
    }

    /**
     * Causes this fish to blow a bubble.
     */
    private void blowBubble() {
        Bubble b = new Bubble();
        b.setLocation(vertical, horizontal);
        FishTankManager.grid.add(b);
    }

    /**
     * Turns this fish around, causing it to reverse direction.
     */
    private void turnAround() {
        goingRight = !goingRight;
        StringBuilder reverse = new StringBuilder();
        for (int i = appearance.length() - 1; i >= 0; i--) {
            switch (appearance.charAt(i)) {
                case '>':
                    reverse.append('<');
                    break;
                case '<':
                    reverse.append('>');
                    break;
                default:
                    reverse.append(appearance.charAt(i));
                    break;
            }
        } appearance = reverse.toString();
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    @Override
    void move() {

        double rng = Math.random();
        if (rng < 0.1) {
            turnAround();
        }
        if (goingRight) {
            if (horizontal < FishTankManager.getGridWidth() - Math.abs(appearance.length()-4)) {
                horizontal += 1;
            } else {
                turnAround();
            }
        } else {
            if (horizontal > 0) {
                horizontal -= 1;
            } else {
                turnAround();
            }
        }
        rng = Math.random();
        if (rng < 0.1) {
            blowBubble();
        }
        rng = Math.random();
        if (rng < 0.1) {
            if (vertical < FishTankManager.getGridHeight()-4) {
                vertical += 1;
            }
        } else if (rng < 0.2) {
            if (vertical > 1) {
                vertical -= 1;
            }
        }
    }
}
