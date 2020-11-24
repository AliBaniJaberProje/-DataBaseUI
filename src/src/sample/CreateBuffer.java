package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class CreateBuffer {

    @FXML
    Button saved;
    @FXML
    Button cancel;

    public void buttonActions(ActionEvent event) throws IOException {
        if( event.getSource()==saved)
        {
             Main.closeCreateBuffer();
        }


    }

}
