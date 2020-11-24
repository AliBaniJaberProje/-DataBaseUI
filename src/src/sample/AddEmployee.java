package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class AddEmployee implements Initializable {


    @FXML
    Button add;
    @FXML
    Button cancel;

    @FXML
    TextField name;
    @FXML
    TextField sex;
    @FXML
    TextField ID;
    @FXML
    ComboBox job_type;
    @FXML
    TextField email;
    @FXML
    DatePicker SD;
    @FXML
    TextField salary;
    @FXML
    TextField NOC;
    @FXML
    TextField addresess;
    @FXML
    ComboBox AL_AG;

    //SecondController obj=new SecondController();



 //   ObservableList<EmployeeAddToTable> to_add = FXCollections.observableArrayList();


    public void buttonActions(ActionEvent event)throws IOException
    {
        if(event.getSource()==add)
        {
            Main.showEmployeeStage();
        }
        else if(event.getSource()==cancel)
        {
            Main.closeEmployeeStage();
        }


    }



    public void mousePressed(MouseEvent event)
    {
        if(event.getSource()==add)
        {
           // add.setStyle("-fx-background-color: rgb(0,83,255)");
        }
        if(event.getSource()==cancel)
        {
            //cancel.setStyle("-fx-background-color: rgb(0,83,255)");
        }


    }

    public void mouseReleased(MouseEvent event)
    {
        if(event.getSource()==add)
        {
         //   add.setStyle("-fx-background-color: blue");
        }
        if(event.getSource()==cancel)
        {
            //cancel.setStyle("-fx-background-color: blue");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        job_type.getItems().addAll(" A ","B","C");
        AL_AG.getItems().addAll(" متزوج ","اعزب ","مطلق");


    }
}
