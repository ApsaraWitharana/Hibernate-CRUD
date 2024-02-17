package lk.ijse.entity.tm;

import javafx.scene.control.Button;


public class CustomerTM {

    private int id;

    private String name;

    private String address;

    private String contact;

    private double salary;

    private Button button;

    public CustomerTM() {
    }

    public CustomerTM(int id, String name, String address, String contact, double salary, Button button) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.salary = salary;
        this.button = button;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", salary=" + salary +
                ", button=" + button +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
