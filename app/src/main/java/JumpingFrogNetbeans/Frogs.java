package JumpingFrogNetbeans;



import processing.core.PApplet;

public class Frogs extends Processing {
  Frog[] frogs;

  Frogs(PApplet p, Slots slots) {
    super(p);
    this.frogs = new Frog[Config.numberOfFrogs];
    for (int i = 0; i < Config.numberOfFrogs; i++) {
      if (i < Config.numberOfFrogs / 2) {
        frogs[i] = new Frog(p, i, true, slots.getSlot(i));
      } else {
        frogs[i] = new Frog(p, i, false, slots.getSlot(Config.numberOfSlots - Config.numberOfFrogs + i));
      }
    }

  }

  public void draw() {
    for (int i = 0; i < Config.numberOfFrogs; i++) {
      frogs[i].draw();
    }
  }

  public Frog getFrogFromPosition(int mouseX, int mouseY) {
    for (int i = 0; i < Config.numberOfFrogs; i++) {
      Frog frog = frogs[i];
      int frogX = frog.getPositionX();
      int frogY = frog.getPositionY();

      if (mouseX >= frogX - (Config.frogWidth / 2) && mouseX <= frogX + (Config.frogWidth / 2) && mouseY >= frogY - (Config.frogHeight / 2) && mouseY <= frogY + (Config.frogHeight / 2)) {
        return frog;
      }

    }
    return null;
  }
  
  public Frog getFrog(int id) {
      return frogs[id];
  }

  public Frog getFrogOnSlot(int slotId) {
    for (int i = 0; i < Config.numberOfFrogs; i++) {
      Frog frog = frogs[i];
      if (frog.getSlot().getId() == slotId)
        return frog;
    }
    return null;
  }

  public boolean isDone() {
    boolean isDone = true;
    for (int i = 0;  i < Config.numberOfFrogs; i++) {
      if (i < Config.numberOfFrogs / 2) {
        isDone = isDone && frogs[i].getSlot().getId() == Config.numberOfSlots - (Config.numberOfFrogs/2) + i;
      } else {
        isDone = isDone && frogs[i].getSlot().getId() == i - (Config.numberOfSlots - (Config.numberOfFrogs/2)) + 1;
      }
    }
    return isDone;
  }
}
