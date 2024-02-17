package lk.ijse.entity.tm;

import javafx.scene.control.Button;

public class OrderTM {

    private int orderId;

    private Integer id;

    private Integer item_code;

    private double unitPrice;

    private int quantity;

    private double price;

    private Button button;

    public OrderTM() {
    }

    public OrderTM(int orderId, int custId, int item_code, double unitPrice, int quantity, double price, Button button) {
        this.orderId = orderId;
        this.id = Integer.valueOf(custId);
     //   this.id = String.valueOf(Integer.parseInt(custId));
        this.item_code = Integer.valueOf(item_code);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.price = price;
        this.button = button;
    }

    public OrderTM(int orderId, Integer value, Integer value1, double unitPrice, int quantity, double price, Button delete) {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return id;
    }

    public void setCustId(int custId) {
        this.id = custId;
    }

    public int getItemId() {
        return item_code;
    }

    public void setItemId(int item_code) {
        this.item_code = item_code;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "orderId=" + orderId +
                ", custId=" + id +
                ", itemId=" + item_code +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", price=" + price +
                ", button=" + button +
                '}';
    }
}
