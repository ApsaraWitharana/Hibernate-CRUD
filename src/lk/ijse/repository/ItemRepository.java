package lk.ijse.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemRepository {

    private final Session session;

    public ItemRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public Item getItem(String code){
        try {
            Item item = session.get(Item.class,code);
            session.close();
            return item;
        }catch (Exception e){
            System.out.println(e);
            session.close();
            throw e;
        }
    }

    public boolean saveItem (Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.save(item);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            System.out.println("item saving process failed");
            return false;
        }

    }

    public boolean updateItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            System.out.println(e);
            System.out.println("item update process failed");
            return false;
        }
    }

    public boolean deleteItem(Item item){
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(item);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            System.out.println(e);
            System.out.println("item deleting process failed");
            return false;
        }
    }
    public ObservableList<Item> getDetailsToTableView(){
        Transaction transaction = session.beginTransaction();

        List<Item> dataList = session.createQuery("FROM Item",Item.class).list();
        transaction.commit();
        session.close();

        ObservableList<Item> observableList = FXCollections.observableArrayList(dataList);
        return observableList;
    }

    public List<Integer> getItemList() {
        Transaction transaction = session.beginTransaction();
        List<Integer> id = null;

        try {
            id = session.createSQLQuery("SELECT item_code FROM item ").list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }

        return id;
    }


}
