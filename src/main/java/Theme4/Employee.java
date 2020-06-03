package Theme4;

/*
1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 */


public class Employee {

    private String name;
    private int age;
    private String post;
    private String email;
    private String telephone;
    private double salary;

    /*
    Конструктор класса
     */
    public Employee(String name, int age, String post, String email, String telephone, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /*
    Переопределяем метод toString для вывода в консоль информации о сотруднике
     */
    @Override
    public String toString() {
        return "Employee{ " +
            "name='" + name + '\'' +
            ", age=" + age +
            ", post='" + post + '\'' +
            ", email='" + email + '\'' +
            ", telephone='" + telephone + '\'' +
            ", salary=" + salary +
            " }";
    }
}
