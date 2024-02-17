package lk.ijse.entity.tm;

import javafx.scene.control.Button;

public class ItemTM {
    private int item_code;

    private String name;

    private String description;

    private String item_qty;

    private Button button;

    public ItemTM() {
    }

    public ItemTM(int item_code, String name, String description, String qtyOnHand, Button button) {
        this.item_code = item_code;
        this.name = name;
        this.description = description;
        this.item_qty = qtyOnHand;
        this.button = button;
    }

    public int getId() {

        return item_code;
    }

    public void setId(int id) {
        this.item_code = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQtyOnHand() {
        return item_qty;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.item_qty = qtyOnHand;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "id=" + item_code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand='" + item_qty + '\'' +
                ", button=" + button +
                '}';
    }
}
