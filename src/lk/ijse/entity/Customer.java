package lk.ijse.entity;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id",nullable = false,length = 100)
    private String id;

    @Column(name = "customer_name",length = 100)
    private String name;
    @Column(name = "customer_address",length = 100)
    private String address;
    @Column(name = "customer_contact")
    private String contact;
    @Column(name = "customer_salary",length = 200)
    private double salary;

    public Customer() {

    }

    public Customer(String id, String name, String address, String contact, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.salary = salary;
    }

    public Customer(String id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Customer(int id) {
        this.id = String.valueOf(id);
    }

    public Customer(String value) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
