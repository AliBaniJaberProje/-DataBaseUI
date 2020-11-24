package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class AddMaterial {
@FXML
    Button save_button;
@FXML
 Button cansel;
public void buttonActions(ActionEvent event)throws IOException
{
    if(event.getSource()==save_button)
    {
    Main.closeAadMaterial();
   /* TextInputDialog dialog=new TextInputDialog(" المستودع الرئيسي");
    dialog.setTitle(" ادخل اسم المستودع ");
    dialog.setHeaderText(" الرجاء ادخال اسم المستودع لحفظ المواد ");
    Optional<String> result=dialog.showAndWait();
    if( result.isPresent())
    {
/////////////////////////////////////////////////////////////////////////////////////////////////////// data base code
    }*/
    }
    if(event.getSource()==cansel){

        Main.closeAadMaterial();
    }

}

}
