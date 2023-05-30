package ass.basic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bank {
    private String bankName;
    private String address;

    private Set<Employee> employees = new HashSet<>();

    public Bank(String bankName, String address) {
        setBankName(bankName);
        setAddress(address);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (bankName == null || bankName.isBlank()){
            throw new IllegalArgumentException("Can`t be null");
        }
        this.bankName = bankName;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        if (address == null || address.isBlank()){
            throw new IllegalArgumentException("Can`t be null");
        }
        this.address = address;
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Can`t be null");
        }
        if (employees.contains(employee)) {
            return;
        }
        employees.add(employee);
        employee.setBank(this);
    }

    public void removeEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be a null value");
        }
        if (!employees.contains(employee)) {
            return;
        }
        employees.remove(employee);
        employee.setBank(null);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                '}';
    }

}
