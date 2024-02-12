package lk.ijse.utile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class AppIntializer extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        URL resource = AppIntializer.class.getResource("/lk/ijse/view/home.fxml");
        Parent load = FXMLLoader.load(resource);
        stage.setScene(new Scene(load));
        stage.setTitle("CRUD Management");
        stage.getIcons().add(new Image("lk/ijse/assets/icons8-home-64.png"));
        stage.centerOnScreen();
        stage.show();
    }


}