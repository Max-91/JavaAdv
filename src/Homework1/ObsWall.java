package Homework1;

public class ObsWall implements Obstacle {
    private int obsHeight;

    public ObsWall(int obsHeight) {
        this.obsHeight = obsHeight;
    }

    public boolean work(RunJump rj) {
        return rj.Jump(obsHeight);
    }
}
