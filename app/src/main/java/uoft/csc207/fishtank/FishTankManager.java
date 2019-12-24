package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;

class FishTankManager {

    /**
     * A list of Creatures in the fish tank.
     */
    static ArrayList<Creature> grid;

    /**
     * The width of the canvas screen according to character size.
     */
    private static int gridWidth;

    /**
     * The height of the canvas screen according to character size.
     */
    private static int gridHeight;


    /**
     * Return the width of the canvas.
     *
     * @return the width of the canvas.
     */
    static int getGridWidth() {
        return gridWidth;
    }

    /**
     * Return the height of the canvas.
     *
     * @return the height of the canvas.
     */
    static int getGridHeight() {
        return gridHeight;
    }

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        grid = new ArrayList<>();
    }

    /**
     * Draws the creatures onto the canvas representing the fish tank.
     *
     * @param canvas the canvas on which to draw this item.
     */
    void draw(Canvas canvas) {
        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).draw(canvas);
        }
    }

    /**
     * Updates the positions of each creature by calling its move function.
     */
    void update() {
        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).move();
        }
    }

    /**
     * Adds a fish which is either hungry or normal into the fish tank.
     *
     * @param hungry whether the fish is hungry or not.
     * @param vertical the vertical location of the fish in the fish tank.
     * @param horizontal the horizontal location of the fish in the fish tank.
     */
    private void addFish(boolean hungry, int vertical, int horizontal) {
        if (hungry) {
            HungryFish hFish = new HungryFish();
            hFish.setLocation(vertical, horizontal);
            grid.add(hFish);
        } else {
            Fish fish = new Fish();
            fish.setLocation(vertical, horizontal);
            grid.add(fish);
        }
    }

    /**
     * Adds a seaweed of varying lengths into the fish tank.
     *
     * @param length the length of the seaweed.
     * @param vert the vertical location of the seaweed in the fish tank.
     * @param horiz the horizontal location of the seaweed in the fish tank.
     */
    private void addSeaweed(int length, int vert, int horiz) {
        Seaweed seaweed = new Seaweed(length);
        seaweed.setLocation(vert, horiz);
        grid.add(seaweed);
    }

    /**
     * Creates many items/creatures in the tank.
     *
     * If more are created, their location needs to be set and added to the list of creatures.
     */
    void createTankItems() {
        addFish(false, getGridHeight() - 7, getGridWidth() - 5);
        addFish(false, 10, 22);
        addFish(false, getGridHeight() - 5, 14);
        addFish(false, 15, 28);
        addFish(false, 35, 36);
        addFish(false, 16, 5);
        addFish(false, 16, 12);
        addFish(true, 38, 18);
        addFish(false, 23, 18);
        addFish(true, getGridHeight() - 9, 12);
        addFish(true, 10, 20);
        addSeaweed(9, 33, 4);
        addSeaweed(6, 24, 13);
        addSeaweed(12, 42, 15);
        addSeaweed(5, 22, 22);
        Human hu = new Human();
        hu.setLocation(0, 0);
        grid.add(hu);
    }
}
