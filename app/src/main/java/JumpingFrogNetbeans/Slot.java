package JumpingFrogNetbeans;

import processing.core.PApplet;
import processing.core.PImage;

public class Slot extends Processing {
  PImage Rock;

  private final int slotId;
  private final int positionX;
  private final int positionY;
  public Slot(PApplet p, int slotId) {
    super(p);
    this.slotId = slotId;
    this.positionX = (p.width - Config.totalSize + Config.slotWidth) / 2 + (Config.slotWidth + Config.slotGap) * slotId;
    this.positionY = p.height / 2 + 180;

  }

  public int getPositionX() {
    return positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public int getId() {
    return slotId;
  }


  public void setup(){
      
  }
  public void draw(){
    p.pushMatrix();
    p.translate(positionX, positionY);
//    p.fill(0);
//    p.stroke(0);
    Rock=p.loadImage("../assets/rock_3.png");
    p.image(Rock,-40,-30, 80,80);
//    p.rectMode(PApplet.CENTER);
//    p.rect(0,0,50,10);
    p.popMatrix();
  }
  
}

