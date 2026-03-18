import java.math.BigDecimal;

public class Person {
    // Private fields (encapsulation)
    private String name;
    private int age;
    private String city;
    private BigDecimal salary;


    // Parameterized constructor
    public Person(String name, int age, String city, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    // SETTERS (with validation)
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        }
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        }
    }

    @Override
    public String toString() {
        return "{name='" + name + "', age=" + age + ", city='" + city + "',salary = " + salary+"' }";
    }
}
