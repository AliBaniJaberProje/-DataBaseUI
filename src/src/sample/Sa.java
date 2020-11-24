package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Sa implements Initializable {



     @FXML
     Button save_button;
     @FXML
     Button cancel_button;

    public void add_description_of_order(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order_description.fxml"));
       Stage newstage =new Stage();
        newstage.setTitle("order description ");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        newstage.setScene(scene);
        newstage.show();

    }



    public void add_description_of_Customer() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order_description.fxml"));
        Stage newstage =new Stage();
        newstage.setTitle("Customer description");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        newstage.setScene(scene);
        newstage.show();

    }

    public void saveOrder(ActionEvent event) throws IOException
    {
        Main.closeOrderStage();






    }

    public void cancelOrder(ActionEvent event)throws IOException
    {
        Main.closeOrderStage();

    }

    @Override
    public void initialize(URL location , ResourceBundle resources)
    {


    }

}
