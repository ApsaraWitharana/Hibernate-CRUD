//package lk.ijse.controller;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//
//import lk.ijse.entity.Customer;
//import lk.ijse.entity.Order;
//import lk.ijse.repository.OrderRepository;
//import lk.ijse.utile.AlertController;
//
//import javax.security.auth.callback.Callback;
//import java.io.IOException;
//
//public class OrderController {
//
//    @FXML
//    private AnchorPane ancPaneOrder;
//
//    @FXML
//    private Button btnDelete;
//
//    @FXML
//    private ImageView btnHome;
//
//    @FXML
//    private Button btnSave;
//
//    @FXML
//    private Button btnUpdate;
//
//    @FXML
//    private TableColumn<Order, String> colCustId;
//
//    @FXML
//    private TableColumn<?, ?> colOdate;
//
//    @FXML
//    private TableColumn<?, ?> colOid;
//
//    @FXML
//    private DatePicker dpOrderDate;
//
//    @FXML
//    private TableView<Order> tViewOrder;
//
//    @FXML
//    private TextField txtCustomerId;
//
//    @FXML
//    private TextField txtOrderId;
//
//
//    @FXML
//    void initialize() {
//        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'orders.fxml'.";
//        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'orders.fxml'.";
//        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'orders.fxml'.";
//        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'orders.fxml'.";
//        assert dpOrderDate != null : "fx:id=\"dpOrderDate\" was not injected: check your FXML file 'orders.fxml'.";
//        assert txtCustomerId != null : "fx:id=\"txtCustId\" was not injected: check your FXML file 'orders.fxml'.";
//        assert txtOrderId != null : "fx:id=\"txtOrderId\" was not injected: check your FXML file 'orders.fxml'.";
//
//        Image image = new Image(getClass().getResourceAsStream("/lk/ijse/assets/icons8-home-64.png"));
//
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(50);
//        imageView.setFitHeight(50);
//        imageView.setPreserveRatio(true);
//
//        // btnHome.setGraphic(imageView);
//
//        colOid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colOdate.setCellValueFactory(new PropertyValueFactory<>("date"));
//        colOdate.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
////       colCustId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order,String>, ObservableValue<String>>() {
////           @Override
////           public ObservableValue<String> call(TableColumn.CellDataFeatures<?, ?> param) {
////               Order order = param.getValue();
////               String customerId = order.getCustomer().getId();
////               return new SimpleStringProperty(customerId);
////           }
////
////    });
////        tViewOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
////        tViewOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customer_id"));
////        tViewOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        setDataToTableView();
//
//
//    }
//
//    private void setDataToTableView() {
//        ObservableList<Order> orderList = new OrderRepository().getDetailsToTableView();
//        tViewOrder.setItems(orderList);
//    }
//
//    @FXML
//    void btnDeleteOnAction(ActionEvent event) {
//        OrderRepository orderRepository = new OrderRepository();
//        Order order = orderRepository.getOrder(txtOrderId.getText());
//        orderRepository = new OrderRepository();
//        boolean deleted = orderRepository.deleteOrder(order);
//        if (deleted) {
//            setDataToTableView();
//            AlertController.confirmmessage("Process Completed", "Order details deleted successfully");
//        } else {
//            AlertController.errormessage("Process Terminated", "Order details deleting unsuccessful.\n" +
//                    "Please try again");
//        }
//    }
//
//
//    @FXML
//    void btnHomeOnAction(MouseEvent event) throws IOException {
//        Parent load = FXMLLoader.load(getClass().getResource("/lk/ijse/view/home.fxml"));
//        ancPaneOrder.getChildren().clear();
//        ancPaneOrder.getChildren().add(load);
//    }
//
//    @FXML
//    void btnSaveOnAction(ActionEvent event) {
//
//        OrderRepository orderRepository = new OrderRepository();
//        Order order = new Order();
//        order.setId(txtOrderId.getText());
//        order.setDate(dpOrderDate.getValue());
//        Customer customer = new Customer();
//        customer.setId(txtCustomerId.getText());
//        order.setCustomer(customer);
//        boolean saved = orderRepository.saveOrder(order);
//        if (saved){
//            setDataToTableView();
//            AlertController.confirmmessage("Process Complete","Order details saved successfully");
//
//        }else {
//            AlertController.errormessage("Process Complete","Order details saving unsuccessful.\n"+"Please resubmit the information ");
//
//        }
//    }
//
//
//
//    @FXML
//    void btnUpdateOnAction(ActionEvent event) {
//        OrderRepository orderRepository = new OrderRepository();
//        Order order = new Order();
//        order.setId(txtOrderId.getText());
//        order.setDate(dpOrderDate.getValue());
//        Customer customer = new Customer();
//        customer.setId(txtCustomerId.getText());
//        order.setCustomer(customer);
//        boolean update = orderRepository.saveOrder(order);
//        if (update){
//            setDataToTableView();
//            AlertController.confirmmessage("Process Complete","Order details update successfully");
//
//        }else {
//            AlertController.errormessage("Process Complete","Order details updating unsuccessful.\n"+"Please resubmit the information ");
//
//        }
//    }
//
//
//}
