package JumpingFrogNetbeans;



import processing.core.PApplet;

public class Slots extends Processing {
  Slot[] slots;

  Slots(PApplet p) {
    super(p);
    this.slots = new Slot[Config.numberOfSlots];
    for (int i = 0; i < Config.numberOfSlots; i++) {
      slots[i] = new Slot(p, i);
    }
  }

  public void draw() {
    for (int i = 0; i < Config.numberOfSlots; i++) {
      slots[i].draw();
    }
  }

  public Slot getSlot(int id) {
    return slots[id];
  }
}
