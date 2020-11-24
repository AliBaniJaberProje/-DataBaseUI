package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class BufferStage {

@FXML
    Button save_button;
@FXML
    Button cancel;
   public  void buttonActions(ActionEvent event ) throws IOException
   {
       if( event.getSource()==save_button){

           ////
           Main.closeCreateBuffer();
       }

       if(event.getSource()==cancel)
       {
           Main.closeCreateBuffer();
       }
   }


}
