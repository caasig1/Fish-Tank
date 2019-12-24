package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Pair;

class Human extends Creature{
    /**
     * Indicates whether this fish is moving right.
     */
    private boolean goingRight;
    /**
     * Second layer of Spongebob's face.
     */
    private String appearance1;
    /**
     * Third layer of Spongebob's face.
     */
    private String appearance2;
    /**
     * Bottom layer of Spongebob's face.
     */
    private String appearance3;

    /**
     * Who lives in a pineapple under the sea? SPONGEBOB SQUARE PANTS!!
     */
    Human(){
        super();
        appearance = "     ~~~~     ";
        appearance1 = "__|  ˚ _ ˚  |⅃";
        appearance2 = "     ~~~~     ";
        appearance3 = "        /  \\        ";
        paintText.setColor(Color.YELLOW);
        goingRight = false;
    }

    /**
     * Turns this fish around, causing it to reverse direction.
     */
    private void turnAround() {
        goingRight = !goingRight;
        if (appearance1.equals("  L|  ˚ _ ˚  |__") || appearance1.equals(" \\_|  D A B  |_>")){
            appearance1 = "__|  ˚ _ ˚  |⅃";
        } else {
            appearance1 = "  L|  ˚ _ ˚  |__";
        }
    }

    /**
     * Set this item's location.
     */
    @Override
    void setLocation(int vert, int horiz) {
        vertical = FishTankManager.getGridHeight() - 7;
        horizontal = FishTankManager.getGridWidth() - 5;
    }

    /**
     * Draws the given string in the given graphics context at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s      the string to draw.
     * @param vert      the x-coordinate of the string's cursor location.
     * @param horiz     the y-coordinate of the string's cursor location.
     */
    @Override
    void drawString(Canvas canvas, String s, int vert, int horiz) {
        canvas.drawText(s, horiz * FishTankView.charWidth, vert * FishTankView.charHeight, paintText);
        canvas.drawText(appearance1, horiz * FishTankView.charWidth, (vert+1) * FishTankView.charHeight, paintText);
        canvas.drawText(appearance2, horiz * FishTankView.charWidth, (vert+2) * FishTankView.charHeight, paintText);
        canvas.drawText(appearance3, horiz * FishTankView.charWidth, (vert+3) * FishTankView.charHeight, paintText);
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
            if (horizontal < FishTankManager.getGridWidth()-5) {
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
            eat();
        }
    }

    /**
     * Spongebob gets hungry so he needs to eat. When he eats, the other creatures disappear into
     * his belly and he gets so excited he DABS!!
     * I pretty much check each non Bubble/Human object (because cannibalism is bad) and if they
     * exist within his 'hitbox' or wherever he is printed (yes it took some tries to find his
     * dimensions) then they are EATEN!!
     */
    private void eat(){
        for (Creature creature : FishTankManager.grid){
            if (!(creature instanceof Human) && !(creature instanceof Bubble)) {
                Pair<Integer, Integer> coords = creature.getLocation();
                if (coords.first >= vertical && coords.first <= vertical + 4){ // he is 4 units tall
                    if (coords.second >= horizontal && coords.second <= horizontal + 5){ // 5 units wide
                        FishTankManager.grid.remove(creature);
                        if (appearance1.equals("  L|  ˚ _ ˚  |__")){
                            appearance1 = " \\_|  D A B  |_>";
                        } else {
                            appearance1 = "<_|  D A B  |_/";
                        }
                    }
                }
            }
        }
    }
}