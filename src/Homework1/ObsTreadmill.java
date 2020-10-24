package Homework1;

public class ObsTreadmill implements Obstacle {
    private int obsLenght;

    public ObsTreadmill(int obsLenght) {
        this.obsLenght = obsLenght;
    }

    @Override
    public boolean work(RunJump rj) {
        return rj.Run(obsLenght);
    }
}
