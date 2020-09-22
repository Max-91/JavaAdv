package Homework1;

public class Cat implements RunJump {
    private int limRun;
    private int limJump;

    public Cat(int limRun, int limJump) {
        this.limRun = limRun;
        this.limJump = limJump;
    }

    @Override
    public boolean Run(int lenght) {
        if (lenght < limRun) {
            System.out.println("Кошка пробежала " + lenght + " м (предел " + limRun + " м)");
            return true;
        }
        System.out.println("Кошка не смогла пробежать " + lenght + " м (предел " + limRun + " м)");
        return false;
    }

    @Override
    public boolean Jump(int height) {
        if (height < limJump) {
            System.out.println("Кошка перепрыгнула " + height + " см (предел " + limRun + " см)");
            return true;
        }
        System.out.println("Кошка не смогла перепругнуть " + height + " см (предел " + limRun + " см)");
        return false;
    }
}
