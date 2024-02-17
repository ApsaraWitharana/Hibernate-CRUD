package lk.ijse.entity;

import javax.persistence.*;

@Entity
@Table(name="order_datail")
public class OrderDetails {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "order_detail_id")
   private int orderDetailId;

   @Column(name = "qty")
   private int qty;

   @Column(name = "unit_price")
   private double unitPrice;

   @ManyToOne
   @JoinColumn(name = "item_code")
   private Item item;

   @ManyToOne
   @JoinColumn(name = "order_id")
   private Order orders;

   public int getQty() {
      return qty;
   }

   public void setQty(int qty) {
      this.qty = qty;
   }

   public double getUnitPrice() {
      return unitPrice;
   }

   public void setUnitPrice(double unitPrice) {
      this.unitPrice = unitPrice;
   }


   public Item getItem() {
      return item;
   }

   public void setItem(Item item) {
      this.item = item;
   }

   public Order getOrder() {
      return orders;
   }

   public void setOrder(Order order) {
      this.orders = order;
   }


   public OrderDetails(){}

   public OrderDetails(int qty, double unitPrice, Item item, Order order) {
      this.qty = qty;
      this.unitPrice = unitPrice;
      this.item = item;
      this.orders = order;
   }

   @Override
   public String toString() {
      return "OrderDetails{" +
              "qty=" + qty +
              ", unitPrice=" + unitPrice +
              ", item=" + item +
              ", order=" + orders +
              '}';
   }
}
