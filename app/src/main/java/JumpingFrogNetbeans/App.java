package JumpingFrogNetbeans;

import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {

    Slots slots;
    Frogs frogs;
    PImage backgroundImage;
    Solver solver;

    public static void main(String[] args) {
        PApplet.main("JumpingFrogNetbeans.App");
    }

    @Override
    public void settings() {
        size(Config.width, Config.height);
        pixelDensity(2);
    }

    public void reset() {
        slots = new Slots(this);
        frogs = new Frogs(this, slots);
        solver = new Solver();
    }

    @Override
    public void setup() {
        backgroundImage = loadImage("../assets/Background.png");
        reset();
    }

    @Override
    public void draw() {
        image(backgroundImage, 0, 0, Config.width, Config.height + (0 * Config.height / Config.width));

        //Drawing Reset Button
        fill(212, 225, 87);
        stroke(205, 220, 57);
        rectMode(CENTER);
        rect(60, 40, 80, 40);
        fill(255);
        textAlign(CENTER, CENTER);
        textSize(20);
        stroke(255);
        text("Reset", 60, 40);

        //Drawing Solve By Steps Button
        fill(212, 225, 87);
        stroke(205, 220, 57);
        rectMode(CENTER);
        rect(960, 40, 200, 40);
        fill(255);
        textAlign(CENTER, CENTER);
        textSize(20);
        stroke(255);
        text("Solve By Steps", 960, 40);

        //Draw Frogs and Rocks
        slots.draw();
        frogs.draw();

        //Check if the game is over
        if (frogs.isDone()) {
            stroke(255);
            fill(0);
            textSize(50);
            textAlign(CENTER, CENTER);
            text("Congrats!", Config.width / 2 - 20, 50);
        }
    }

    @Override
    public void mousePressed() {
        Frog frog = frogs.getFrogFromPosition(mouseX, mouseY);

        //check if the no frog was clicked
        if (frog == null) {
            //Check if Reset button is pressed
            if (mouseX >= 20 && mouseX <= 100 && mouseY >= 20 && mouseY <= 60) {
                //call reset function
                System.out.println("Reset");
                reset();
            }

            if (mouseX >= 860 && mouseX <= 1040 && mouseY >= 20 && mouseY <= 60 && !frogs.isDone()) {
                //call reset function
                int frogId = solver.solve();
                if (frogId != -1) {
                    frog = frogs.getFrog(frogId);
                }
            }
        }

        if (frog == null) {
            return;
        }

        //setting the direction of depending on its initial position
        int direction = frog.getLeft() ? +1 : -1;
        int slotId = frog.getSlot().getId();

        //checking if the rock beside the frog is empty (one step is possible)
        Frog neighbor1 = frogs.getFrogOnSlot(slotId + direction);
        if (neighbor1 == null) {
            if (slots.isValidSlotId(slotId + direction)) {
                frog.move(slots.getSlot(slotId + direction));
            }
            return;
        }

        //checking if the second rock beside the frog is empty (2 steps are possible)
        Frog neighbor2 = frogs.getFrogOnSlot(slotId + 2 * direction);
        if (neighbor2 == null) {
            if (slots.isValidSlotId(slotId + direction)) {
                frog.move(slots.getSlot(slotId + 2 * direction));
            }
            return;
        }

    }

}
