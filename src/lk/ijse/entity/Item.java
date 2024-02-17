package lk.ijse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name ="item_code",nullable = false,length = 100)
    private int item_code;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_description",length = 100)
    private String description;
    @Column(name = "item_unit_price",length = 100)
    private double unit_price;
    @Column(name = "item_qty",length = 100)
    private int item_qty;
    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    //public Item(String item_code) {
     //   this.item_code = String.valueOf(Integer.parseInt(item_code));
   // }

    public Item(int item_code, String description, double unit_price, int item_qty) {

        this.item_code = item_code;
        this.description = description;
        this.unit_price = unit_price;
        this.item_qty = item_qty;
    }

    public Item(int item_code, String name, String description, double unit_price, int item_qty, List<OrderDetails> orderDetails) {
        this.item_code = item_code;
        this.name = name;
        this.description = description;
        this.unit_price = unit_price;
        this.item_qty = item_qty;
        this.orderDetails = orderDetails;
    }

    public Item(Integer item_code) {
        //this.item_code= String.valueOf(item_code);
        this.item_code = item_code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Item() {

    }

    public Item(int item_code ) {
        //this.item_code = item_code;
        this.item_code = item_code;
    }

    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_code='" + item_code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit_price=" + unit_price +
                ", item_qty=" + item_qty +
                '}';
    }
}
