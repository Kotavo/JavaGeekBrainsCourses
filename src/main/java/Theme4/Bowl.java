package Theme4;

/*
2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
 а также методами наполнения и получения информации о количестве еды;
 */

public class Bowl {
    private String foodName = "feed";   // тип еды
    private int volume = 1;             // объем миски
    private int foodAmount = 0;         // кол-во еды

    public Bowl() {
    }

    // В конструкторе проверяется корректность введенных данных,
    // Если задано отрицательное значение для объема, то по умолчанию объем становится равен 1
    // Если кол-во еды меньше 0, то считаем, что еды нет ( равна 0)
    // Если введенное кол-во еды больше объема, то пологаем, что кол-во еды становится равным объему

    public Bowl(String foodName, int volume, int foodAmount) {
        this.foodName = foodName;
        if (volume > 0) {
            this.volume = volume;
        }
        else{
            this.volume = 1;
        }
        if(foodAmount < 0){
            this.foodAmount = 0;
        }
        else {
            this.foodAmount = Math.min(foodAmount, volume);
        }
    }

    // Метод для добавления еды в миску
    public void addFood(int food) {
       this.foodAmount = Math.min(food, this.volume);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume > 0) {
            this.volume = volume;
        }
        else{
            this.volume = 1;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        if(foodAmount < 0){
            this.foodAmount = 0;
        }
        else {
            this.foodAmount = Math.min(foodAmount, volume);
        }
    }

    @Override
    public String toString() {
        return "Bowl{" +
            "foodName='" + foodName + '\'' +
            ", volume=" + volume +
            ", foodAmount=" + foodAmount +
            '}';
    }
}
