package Theme4;

public abstract class Animal {
    protected String name;
    protected int runLimit = 0;
    protected double jumpLimit = 0;
    protected int swimLimit = 0;

    public Animal() {
        this.name = "noName";
    }

    public Animal(String name) {
        this.name = name;
    }

    public void run (int distance){
        if(runLimit > 0 && distance <= runLimit)
            System.out.println("Animal " + name + " runs " + distance + " meters");
        else
            System.out.println("Animal " + name + " could not run " + distance + " meters");
     }

     public void swim(int distance){
         if(swimLimit > 0 && distance <= swimLimit)
            System.out.println("Animal " + name + " swims " + distance + " meters");
         else
             System.out.println("Animal " + name + " could not swim " + distance + " meters");
     }

    public void jumpOver(double distance){
        if(jumpLimit > 0 && distance <= jumpLimit )
            System.out.println("Animal " + name + " jumps over " + distance + " meters");
        else
            System.out.println("Animal " + name + " could not jump over " + distance + " meters");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(double jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public int getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    @Override
    public String toString() {
        return "Animal{" +
            "name='" + name + '\'' +
            ", runLimit=" + runLimit +
            ", jumpLimit=" + jumpLimit +
            ", swimLimit=" + swimLimit +
            '}';
    }
}
