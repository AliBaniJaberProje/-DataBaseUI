package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addBillController implements Initializable {

    @FXML
    Button save_bill;
    @FXML
    Button cancel_bill;


   public void buttonActions(ActionEvent event) throws Exception
   {
       if (event.getSource()==save_bill)
       {
           Main.closeAddBill();
       }
       if(event.getSource()==cancel_bill)
       {
           Main.closeAddBill();
       }
   }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
