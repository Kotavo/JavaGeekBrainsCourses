package Theme5;

import Theme4.Bowl;
import Theme4.Cat;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/*
6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;
7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
 */

public class Main {
    public static void main(String[] args) {
        Bowl ourBowl = new Bowl("KittyCat", 10,8);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsic", 1, ourBowl);
        cats[1] = new Cat("Tom", 2, ourBowl);
        cats[2] = new Cat("Kitty", 2, ourBowl);
        cats[3] = new Cat("Pie", 2, ourBowl);
        cats[4] = new Cat("Orange", 3, ourBowl);

        for (Cat cat : cats) {
            cat.eating();
            System.out.println("В миске осталось " + cat.getCatBowl().getFoodAmount() + " еды");
            if (!cat.isSatiety()) {
                break;
            }
        }
    }
}
