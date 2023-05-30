package ass.basic;

public class Employee {
    private String name;
    private String surname;
    private int age;

    private Bank bank;

    public Employee(String name, String surname, int age) {
        setAge(age);
        setName(name);
        setSurname(surname);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        if (this.bank == null && bank == null) {
            return;
        }
        if (this.bank == bank) {
            return;
        }
        if (this.bank == null && bank != null) {
            this.bank = bank;
            this.bank.addEmployee(this);
        }
        if (this.bank != null && bank == null) {
            if (this.bank.getEmployees().contains(this)) {
                this.bank.removeEmployee(this);
            }
            this.bank = null;
        }
        if (this.bank != null && bank != null) {
            if (this.bank.getEmployees().contains(this)) {
                this.bank.removeEmployee(this);
            }
            this.bank = bank;
            this.bank.addEmployee(this);
        }
    }

    public void removeBank() {
        if (this.bank == null) {
            return;
        }
        if (this.bank.getEmployees().contains(this)) {
            this.bank.removeEmployee(this);
        }
        this.bank = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Cant be null");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null|| surname.isBlank()) {
            throw new IllegalArgumentException("Cant be null");
        }
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("It is not possible");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", bank=" + bank +
                '}';
    }

}
