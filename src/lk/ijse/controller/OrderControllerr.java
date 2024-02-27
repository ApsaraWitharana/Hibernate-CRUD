package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.Order;
import lk.ijse.entity.tm.CustomerTM;
import lk.ijse.entity.tm.OrderTM;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.OrderRepository1;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class OrderControllerr implements Initializable {

    @FXML
    private TableColumn<?, ?> ColAction;

    @FXML
    private TableColumn<?, ?> ColCustId;

    @FXML
    private TableColumn<?, ?> ColItemId;

    @FXML
    private TableColumn<?, ?> ColOrderId;

    @FXML
    private TableColumn<?, ?> ColPrice;

    @FXML
    private TableColumn<?, ?> ColQty;

    @FXML
    private TableColumn<?, ?> ColUnitP;

    @FXML
    private ComboBox<Integer> cmbCust;

    @FXML
    private ComboBox<Integer> cmbItem;

    @FXML
    private Label lblOrder;

    @FXML
    private Label lblPrice;

    @FXML
    private TableView<OrderTM> tbl;

    @FXML
    private TextField txtPrice;

    @FXML
    private AnchorPane ancPaneOrder;

    @FXML
    private TextField txtQty;
    @FXML
    private Label lblDate;
    @FXML
    private ImageView btnHome;

    OrderRepository1 orderRepository;
    ItemRepository itemRepository;
    CustomerRepository customerRepository;

    private ObservableList<OrderTM> obList = FXCollections.observableArrayList();

    @FXML
    void btnHomeOnAction(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/lk/ijse/view/home.fxml"));
        ancPaneOrder.getChildren().clear();
        ancPaneOrder.getChildren().add(load);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setOrderId();
       // setItemList();
       //setCusIdList();
       setCellValueFactory();
       lblDate.setText(LocalDate.now().toString());
    }


    private void setCellValueFactory() {
        ColOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        ColCustId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        ColItemId.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        ColUnitP.setCellValueFactory(new PropertyValueFactory<>("item_unit_price"));
        ColQty.setCellValueFactory(new PropertyValueFactory<>("item_qty"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ColAction.setCellValueFactory(new PropertyValueFactory<>("button"));

    }

    private void setCusIdList() {

        customerRepository = new CustomerRepository();
        List<Integer> itemList = customerRepository.getCustIDList();
        ObservableList<Integer> dataList = FXCollections.observableArrayList();

        for (Integer ids : itemList) {
            dataList.add(Integer.valueOf((ids)));
        }
        cmbCust.setItems(dataList);

//try {
//    ArrayList<CustomerTM> allCustomers = customerRepository.getCustIDList();
//for (CustomerTM c : allCustomers){
//    cmbCust.getItems().add(c.getId());
//}
//
//} catch (Exception e) {
//    new Alert(Alert.AlertType.ERROR,"Failed to load customer ids").show();
//}
    }

    private void setItemList() {
        itemRepository = new ItemRepository();
        List<Integer> itemList = itemRepository.getItemList();
        ObservableList<Integer> dataList = FXCollections.observableArrayList();

        for (Integer ids : itemList) {
            dataList.add(Integer.valueOf(ids));
           // dataList.add(Integer.valueOf(String.valueOf(ids)));
        }
        cmbItem.setItems(dataList);
    }

    private void setOrderId() {

        orderRepository = new OrderRepository1();
        int orderId = orderRepository.getOrderId();
        if( orderId==0) {
            lblOrder.setText(String.valueOf(1));
        } else {
            lblOrder.setText(String.valueOf(orderId + 1));
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearData();
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

        Customer customer = new Customer( cmbItem.getValue());
        Item item = new Item( cmbItem.getValue());
        Order order = new Order(Integer.parseInt(lblOrder.getText()));

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Button delete = new Button("Delete");
        delete.setCursor(Cursor.HAND);
        setDeleteBtnOnAction(delete);

        OrderTM orderTM = new OrderTM(Integer.parseInt(lblOrder.getText()), cmbItem.getValue(),  cmbItem.getValue(),
                Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), Double.parseDouble(lblPrice.getText()), delete);
        obList.add(orderTM);
        tbl.setItems(obList);
        clearData();
    }

    private void clearData() {
        cmbItem.getValue();
       // cmbItem.setValue(Integer.valueOf(String.valueOf("")));
        //cmbItem.setValue(Integer.valueOf(String.valueOf(Integer.valueOf(String.valueOf("")))));
        txtPrice.clear();
        txtQty.clear();
        lblPrice.setText("");
    }

    private void setDeleteBtnOnAction(Button deleteButton) {

        deleteButton.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to delete?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                int selectedIndex = tbl.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    tbl.getItems().remove(selectedIndex);
                }
            }
        });
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        OrderTM selectedData = (OrderTM) tbl.getSelectionModel().getSelectedItem();
        System.out.println(selectedData);
        selectedData.setOrderId(Integer.parseInt(lblOrder.getText()));
        selectedData.setCustId(Integer.parseInt(String.valueOf((Integer) cmbCust.getValue())));
        selectedData.setItemId(Integer.parseInt(String.valueOf((Integer) cmbItem.getValue())));
        selectedData.setUnitPrice(Double.parseDouble(txtPrice.getText()));
        selectedData.setQuantity(Integer.parseInt(txtQty.getText()));
        selectedData.setPrice(Double.parseDouble(lblPrice.getText()));
        tbl.refresh();
    }

    @FXML
    void priceOnAction(KeyEvent event) {
        double total = Double.parseDouble(txtPrice.getText()) * Integer.parseInt(txtQty.getText());
        lblPrice.setText(String.valueOf(total));
    }

    @FXML
    void tblOnAction(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            Integer custID = (Integer) ColOrderId.getCellData(tbl.getSelectionModel().getSelectedIndex());

            if(custID!=null){
                OrderTM orderTM = (OrderTM) tbl.getSelectionModel().getSelectedItem();
                lblOrder.setText(String.valueOf(orderTM.getOrderId()));
                cmbCust.setValue(Integer.valueOf(String.valueOf(orderTM.getCustId())));
                cmbItem.setValue(Integer.valueOf(String.valueOf(orderTM.getItemId())));
                txtPrice.setText(String.valueOf(orderTM.getUnitPrice()));
                txtQty.setText(String.valueOf(orderTM.getQuantity()));
                lblPrice.setText(String.valueOf(orderTM.getPrice()));
            }
        }
    }

}
