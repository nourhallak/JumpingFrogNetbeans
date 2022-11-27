package JumpingFrogNetbeans;

public class Solver {

    private int cycle;
    private int jumpInCycle;
    private final int totalCycles;
    private final int middleStep;
    private final int totalNumberOfJumps;

    Solver() {
        this.totalCycles = Config.numberOfFrogs + 1;
        this.middleStep = (totalCycles + 1) / 2;
        this.totalNumberOfJumps = Config.numberOfFrogs + (Config.numberOfFrogs * Config.numberOfFrogs) / 4;
        this.cycle = 1;
        this.jumpInCycle = 0;
    }

    public int getTotalNumberOfJumps() {
        return totalNumberOfJumps;
    }
    
    private int getNumberOfJumps(int cycle) {
        if (cycle == middleStep) {
            return cycle - 1;
        } else if (cycle < middleStep) {
            return cycle;
        } else {
            return totalCycles - cycle + 1;
        }
    }

    public int solve() {
        if (cycle >= totalCycles) {
            return -1;
        }

        int numberOfJumps = getNumberOfJumps(cycle);

        if (numberOfJumps == jumpInCycle) {
            cycle++;
            jumpInCycle = 0;
            numberOfJumps = getNumberOfJumps(cycle);
        }

        boolean left = cycle % 2 == 1;

        int toBeMoved;

        if (cycle <= middleStep) {
            if (left) {
                toBeMoved = (Config.numberOfFrogs / 2 - jumpInCycle - 1);
            } else {
                toBeMoved = (Config.numberOfFrogs / 2 + jumpInCycle);
            }
        } else {
            if (left) {
                toBeMoved = (numberOfJumps - jumpInCycle - 1);
            } else {
                toBeMoved = (Config.numberOfFrogs - (numberOfJumps - jumpInCycle));
            }
        }

        jumpInCycle++;

        return toBeMoved;

    }

}
