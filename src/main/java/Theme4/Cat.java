package Theme4;

/*
3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
 */

public class Cat extends Animal {

    private Bowl catBowl;               // миска для кота
    private boolean satiety = false;    // сытость
    private int appetite = 1;           // аппетит

    public Cat(String name) {
        super("Cat " + name);
        this.jumpLimit = 2;
        this.runLimit = 200;
        this.catBowl = new Bowl();
        this.appetite = 1;
    }

    // Конструктор для ДЗ, чтобы не заморачиваться с прыжками, лимитами и т.д,
    // а задавать только имя, миску и аппетит
    public Cat(String name, int appetite, Bowl bowl){
        super("Cat " + name);
        this.jumpLimit = 2;
        this.runLimit = 200;
        this.appetite = appetite;
        this.catBowl = bowl;
    }


    public Cat(String name, int runLimit, double jumpLimit, int swimLimit, int appetite, Bowl catBowl) {
        super("Cat " + name);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
        this.appetite = appetite;
        this.catBowl = catBowl;
    }

    /*
    Кормим котика. Если еды в миске достаточно, то устанвливаем поле
    сытость (satiety) = true и возвращаем значение. Если еды недостаточно, то кот не есть из миски и
    метод возвращает false
     */
    public boolean eating(){
        if (appetite <= catBowl.getFoodAmount()){
            catBowl.setFoodAmount(catBowl.getFoodAmount() - appetite);
            System.out.println("Котик " + name + " наелся ^_^");
            this.satiety = true;
        }
        else{
            System.out.println("Котику " + name + " не хватило еды(((");
        }
        return satiety;
    }

    public Bowl getCatBowl() {
        return catBowl;
    }

    public void setCatBowl(Bowl catBowl) {
        this.catBowl = catBowl;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    @Override
    public void swim(int distance) {
        if(swimLimit > 0)
            System.out.println("Animal " + name + " swims " + distance + " meters");
        else
            System.out.println("Cat " + name + " cant swimming");
    }
}
