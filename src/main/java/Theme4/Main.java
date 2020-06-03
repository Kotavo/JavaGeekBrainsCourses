package Theme4;

public class Main {
    public static void main(String[] args) {

        /*
        4. Создать массив из 5 сотрудников
        С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
         */
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Bob Dilan", 50, "manager", "Bob@mail.com", "254151511", 12515.12);
        employees[1] = new Employee("Tom Wayne", 20, "printer", "tom@mail.com","3215151",11525);
        employees[2] = new Employee("Jack Jackovich", 41, "manager", "Jack@mail.com", "1541511", 12515);
        employees[3] = new Employee("Brain Johnson", 30, "no matter", "Brain@mail.com","141414141", 1002);
        employees[4] = new Employee("Rick Sanchez", 60, "Boss","Rick@mail.com","14515151",55555);

        for (Employee emp: employees)
        {
            if(emp.getAge() > 40)
                System.out.println(emp.toString());
        }

        System.out.println();

        /*
        Блок с проверкой 6-9 заданий. Создадим объекты типа cat и dog и вызовем основные методы
         */

        Animal cat1 = new Cat("Barsik");
        Animal dog1 = new Dog("Bobbi");
        Animal dogWithLimit = new Dog("sharik",1000,4,100); // Песёль для которого заданы ограничения

        cat1.run(100);
        cat1.run(300);
        cat1.swim(10);
        cat1.jumpOver(1.5);
        cat1.jumpOver(4);

        System.out.println();

        dog1.run(600);
        dog1.swim(20);
        dog1.jumpOver(3);

        System.out.println();

        dogWithLimit.run(600);
        dogWithLimit.swim(20);
        dogWithLimit.jumpOver(3);

    }
}
