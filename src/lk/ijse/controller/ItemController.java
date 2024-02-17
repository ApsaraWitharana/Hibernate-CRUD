package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.entity.Item;
import lk.ijse.repository.ItemRepository;
import lk.ijse.utile.AlertController;

import java.io.IOException;

public class ItemController {

    @FXML
    private AnchorPane ancPaneItem;


    @FXML
    private Button btnDelete;

    @FXML
    private ImageView btnHome;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<Item> tViewItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void initialize() {
        assert ancPaneItem != null : "fx:id=\"ancPaneCustomer\" was not injected: check your FXML file 'item.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'item.fxml'.";
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'item.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'item.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'item.fxml'.";
        assert txtDescription != null : "fx:id=\"txtDescription\" was not injected: check your FXML file 'item.fxml'.";
        assert txtItemCode != null : "fx:id=\"txtItemCode\" was not injected: check your FXML file 'item.fxml'.";
        assert txtQty != null : "fx:id=\"txtQty\" was not injected: check your FXML file 'item.fxml'.";
        assert txtUnitPrice != null : "fx:id=\"txtUnitPrice\" was not injected: check your FXML file 'item.fxml'.";

        Image image = new Image(getClass().getResourceAsStream("/lk/ijse/assets/icons8-home-64.png"));

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

       // btnHome.setGraphic(imageView);

        colCode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("item_qty"));

        setDataToTableView();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/lk/ijse/view/home.fxml"));
        ancPaneItem.getChildren().clear();
        ancPaneItem.getChildren().add(load);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();
        Item item = new Item();
        item.setItem_code(Integer.parseInt(txtItemCode.getText()));
        item.setDescription(txtDescription.getText());
        item.setUnit_price(Double.parseDouble(txtUnitPrice.getText()));
        item.setItem_qty(Integer.parseInt(txtQty.getText()));
        boolean saved = itemRepository.saveItem(item);
        if (saved){
            setDataToTableView();
            AlertController.confirmmessage("Process Completed ","Item details saved successfully");

        }else {
            AlertController.errormessage("Process Terminated ","Item details saving unsuccessful.\n"
                    +"Please resubmit the information");

        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();
        Item item = new Item();
        item.setItem_code(Integer.parseInt(txtItemCode.getText()));
        item.setDescription(txtDescription.getText());
        item.setUnit_price(Double.parseDouble(txtUnitPrice.getText()));
        item.setItem_qty(Integer.parseInt(txtQty.getText()));
        boolean update = itemRepository.updateItem(item);
        if (update){
            setDataToTableView();
            AlertController.confirmmessage("Process Completed ","Item details update successfully");

        }else {
            AlertController.errormessage("Process Terminated ","Item details updating unsuccessful.\n"
                    +"Please resubmit the information");

        }
    }

    @FXML
    void OnDeleteOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();
        Item item = itemRepository.getItem(txtItemCode.getText());
        itemRepository = new ItemRepository();
        boolean deleted = itemRepository.deleteItem(item);
        if (deleted){
            setDataToTableView();
            AlertController.confirmmessage("Process Complete","Item details deleted successfully");

        }else {
            AlertController.errormessage("Process Terminated","Item details deleting unsuccessful.\n"+"Please try again");

        }
    }

    private void setDataToTableView() {
        ObservableList<Item> itemList = new ItemRepository().getDetailsToTableView();
        tViewItem.setItems(itemList);
    }


    public void tblOnMouseClicked(MouseEvent mouseEvent) {
        TablePosition pos = tViewItem.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        // Get the data from the selected row
        ObservableList<TableColumn<Item, ?>> columns = tViewItem.getColumns();

        txtItemCode.setText(columns.get(0).getCellData(row).toString());
        txtDescription.setText(columns.get(1).getCellData(row).toString());
        txtQty.setText(columns.get(2).getCellData(row).toString());
        txtUnitPrice.setText(columns.get(3).getCellData(row).toString());
    }

}
