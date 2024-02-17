//package lk.ijse.repository;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.Alert;
//import lk.ijse.config.SessionFactoryConfig;
//import lk.ijse.entity.Order;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class OrderRepository {
//    private final Session session;
//
//    public OrderRepository() {
//       session = SessionFactoryConfig.getInstance().getSession();
//
//    }
//
//    public Order getOrder(String id){
//        try {
//            Order order = session.get(Order.class,id);
//            session.close();
//            return  order;
//        }catch (Exception e){
//            System.out.println(e);
//            session.close();
//            throw e;
//        }
//    }
//
//    public boolean saveOrder(Order order){
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.save(order);
//            transaction.commit();
//            session.close();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            System.out.println(e);
//            System.out.println("Order saving process failed");
//            return false;
//        }
//    }
//
//    public boolean deleteOrder(Order order){
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.delete(order);
//            transaction.commit();
//            session.close();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            System.out.println(e);
//            System.out.println("Order delete process failed");
//            return false;
//        }
//    }
//
//    public boolean updateOrder(Order order){
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.update(order);
//            transaction.commit();
//            session.close();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            System.out.println(e);
//            System.out.println("Order update process failed");
//            return false;
//        }
//    }
//
//    public ObservableList<Order> getDetailsToTableView(){
//        Transaction transaction = session.beginTransaction();
//        List<Order> dataList = session.createQuery("FROM  Order" ,Order.class).list();
//        transaction.commit();
//        session.close();
//        ObservableList<Order> observableList = FXCollections.observableArrayList(dataList);
//        return observableList;
//    }
//
//    public int getOrderId() {
//        Transaction transaction = session.beginTransaction();
//        List<Integer> id = null;
//
//        try {
//            id = session.createSQLQuery("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1").list();
//            transaction.commit();
//
//        }catch (Exception e){
//            transaction.rollback();
//            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
//
//        }finally {
//            session.close();
//        }
//
//        if(!id.isEmpty())
//            return id.get(0);
//        else
//            return 0;
//    }
//
//
//}
