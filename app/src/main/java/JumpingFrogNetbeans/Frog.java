package JumpingFrogNetbeans;



import processing.core.PApplet;
import processing.core.PImage;

public class Frog extends Processing {
  PImage Frog;

  private Slot slot;
  private final int id;
  private final boolean left;

  public Frog(PApplet p, int id, boolean left, Slot slot) {
    super(p);
    this.slot = slot;
    this.id = id;
    this.left = left;
  }

  public void draw() {
    p.pushMatrix();
    p.translate(slot.getPositionX(), getPositionY());
    if (left) {
        Frog=p.loadImage("../assets/Frog_1.png");
        p.image(Frog,-35,-40, 70,70);
        
    p.fill(255,0,0);
//      p.fill(229, 57, 53);
//      p.stroke(229, 57, 53);
    } else {
        Frog=p.loadImage("../assets/Frog_2.png");
        p.image(Frog,-35,-40, 70,70);

    p.fill(0,0,255);        
//      p.fill(33, 150, 243);   
//      p.stroke(33, 150, 243);
    }
    p.stroke(0,0);
    p.ellipseMode(p.CENTER);
    p.ellipse(0, 0, 20, 20);
//    p.fill(255);
//    p.textAlign(p.CENTER, p.CENTER);
//    p.textSize(20);
//    p.text(id, 0, 0);
//   
//    p.stroke(255, 0, 0);
//    p.rectMode(p.CENTER);
//    p.noFill();
//    p.rect(0, 0, Config.frogWidth, Config.frogHeight);
    p.popMatrix();
  }

  public void move(Slot slot) {
    this.slot = slot;
  }

  public int getPositionX() {
    return slot.getPositionX();
  }

  public int getPositionY() {
    return slot.getPositionY() - Config.frogHeight / 2;
  }

  public Slot getSlot() {
    return slot;
  }

  public boolean getLeft() {
    return left;
  }
}

