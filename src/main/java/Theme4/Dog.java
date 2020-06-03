package Theme4;

public class Dog extends Animal {

    public Dog(String name) {
        super("Dog " + name);
        runLimit = 500;
        jumpLimit = 0.5;
        swimLimit = 10;
    }

    public Dog(String name, int runLimit, double jumpLimit, int swimLimit) {
        super("Dog " + name);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }



    @Override
    public String toString() {
        return "Dog{" +
            ", name='" + name + '\'' +
            "runLimit=" + runLimit +
            ", swimLimit=" + swimLimit +
            ", jumpLimit=" + jumpLimit +
            '}';
    }
}
