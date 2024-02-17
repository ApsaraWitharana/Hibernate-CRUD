package lk.ijse.repository;

import javafx.scene.control.Alert;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class OrderRepository1 {

    private Session session;

    public OrderRepository1() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveOrder(Order order){
        Transaction transaction = session.beginTransaction();
        try {
            int orderId = (int) session.save(order);
            transaction.commit();
            return orderId;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return -1;
        }finally {
            session.close();
        }
    }

    public boolean updateOrder(Order detail){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(detail);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean deleteOrder(Order order){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(order);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    public Order getOrder(int id){
        Transaction transaction = session.beginTransaction();
        Order order = null;
        try {
            order = session.get(Order.class, id);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }finally {
            session.close();
        }

        return order;
    }

    public List<Order> getAllOrder(){
        Transaction transaction = session.beginTransaction();
        List<Order> orderList = null;

        try {
            orderList = session.createSQLQuery("SELECT * FROM orders").addEntity(Order.class).list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }
        return orderList;
    }

    public int getOrderId(){
        Transaction transaction = session.beginTransaction();
        List<Integer> id = null;

        try {
            id = session.createSQLQuery("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1").list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }

        if(!id.isEmpty())
            return id.get(0);
        else
            return 0;
    }




}
