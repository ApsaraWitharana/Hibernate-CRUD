package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;
    @FXML
    private AnchorPane ancPaneHome;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    void btnCustomerOnActiion(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/lk/ijse/view/customer.fxml"));
        ancPaneHome.getChildren().clear();
        ancPaneHome.getChildren().add(load);
    }

   
    public void initialize(URL url , ResourceBundle resourceBundle){
       timenow(lblDate,lblTime);

    }

    private void timenow(Label time,Label date) {
        Thread thread = new Thread(() ->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat sdf1 = new SimpleDateFormat("MMM, dd, yyy");
            while (true){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                String timenow1 = sdf1.format(new Date());

                Platform.runLater(() ->{
                    time.setText(timenow);
                    date.setText(timenow1);

                });
            }
        });
        thread.start();
    }


    public void btnItemOnAction(ActionEvent event) {
        
    }
}
