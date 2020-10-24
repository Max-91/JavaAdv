package Homework1;

public class Man implements RunJump {
    private int limRun;
    private int limJump;

    public Man(int limRun, int limJump) {
        this.limRun = limRun;
        this.limJump = limJump;
    }

    @Override
    public boolean Run(int lenght) {
        if (lenght < limRun) {
            System.out.println("Человек пробежал " + lenght + " м (предел " + limRun + " м)");
            return true;
        }
        System.out.println("Человек не смог пробежать " + lenght + " м (предел " + limRun + " м)");
        return false;
    }

    @Override
    public boolean Jump(int height) {
        if (height < limJump) {
            System.out.println("Человек перепрыгнул " + height + " см (предел " + limRun + " см)");
            return true;
        }
        System.out.println("Человек не смог перепругнуть " + height + " см (предел " + limRun + " см)");
        return false;
    }
}
