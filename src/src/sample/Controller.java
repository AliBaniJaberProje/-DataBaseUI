package sample;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.concurrent.Task;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
import javafx.application.Platform;
//import org.controlsfx.control.textfield.AutoCompletionBinding;

//import org.controlsfx.control.textfield.TextFields;


public class Controller implements Initializable {
    @FXML
    private PasswordField pass;
    @FXML
    private TextField user;
    @FXML
    private Button login;
    @FXML
    ProgressIndicator pro;
    @FXML
    AnchorPane main_anchor;
    @FXML
    ImageView twins_icon;
    DropShadow shadow = new DropShadow();
    public void action(ActionEvent event) throws IOException {
      login.setEffect(shadow);
      pro.setVisible(true);
      // LoginTask بعدها سيتم إنشاء كائن م
      // ن الكلاس
      LoginTask task = new LoginTask();
      // task بالكائن progressIndicator بعدها سيتم ربط أداء الكائن
      pro.progressProperty().bind(task.progressProperty());
      // خاص Thread بداخل LoginTask الموجودة في الكلاس call() في الأخير سيتم تنفيذ المهمة المعرفة بداخل الدالة
      new Thread(task).start();
       pro.progressProperty().addListener((obs, oldValue, newValue) -> {
            // Done تحته بدل النص Login Succefully هنا قلنا أنه في حال أصبحت قيمته تساوي 1 - أي في حال إكتمل - سيتم وضع النص
            if (newValue.doubleValue() >= 1.0&&user.getText().equals("user")&&pass.getText().equals("admin")) {

                try {
                    Parent sroot = FXMLLoader.load(getClass().getResource("Second.fxml"));
                    Scene tab = new Scene(sroot);
                    tab.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(tab);
                    window.setHeight(950);

                    window.show();
                }
                catch (IOException ecp){
                    ecp.printStackTrace();
                    System.out.println("ali ");
                    //(ecp).getMessage();
                }



                }

        });
     /*
        if(user.getText().equals("user")&&pass.getText().equals("admin")) {
            Parent sroot = FXMLLoader.load(getClass().getResource("Second.fxml"));
            Scene tab = new Scene(sroot);
            tab.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tab);
            window.setHeight(950);

            window.show();

        }
        else if(user.getText().equals("user")&&!(pass.getText().equals("admin")))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Wrong!");
            alert.setContentText("Your Password is incorrect");
            alert.showAndWait();
        }
        else if(!(user.getText().equals("user"))&&pass.getText().equals("admin"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Wrong!");
            alert.setContentText("Your Username is incorrect");
            alert.showAndWait();
        }
        else if(user.getText().isEmpty()||pass.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong!");
            alert.setContentText("Please Fill the required Field");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Wrong!");
            alert.setContentText("Your Username and Password is incorrect");
            alert.showAndWait();
        }

      */
     }

    public void KeyAction(KeyEvent event) throws IOException
    {
        //login.setEffect(shadow);

        int x = event.getCode().getCode();
       // System.out.println(x);
        //** 10 is "ENTER" key code
        if(x==10) {


            if (user.getText().equals("user") && pass.getText().equals("admin")) {
                Parent sroot = FXMLLoader.load(getClass().getResource("Second.fxml"));
                Scene tab = new Scene(sroot);
                tab.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tab);

                window.show();


            } else if (user.getText().equals("user") && !(pass.getText().equals("admin"))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Wrong!");
                alert.setContentText("Your Password is incorrect");
                alert.showAndWait();
            } else if (!(user.getText().equals("user")) && pass.getText().equals("admin")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Wrong!");
                alert.setContentText("Your Username is incorrect");
                alert.showAndWait();
            } else if (user.getText().isEmpty() || pass.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Wrong!");
                alert.setContentText("Please Fill the required Field");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Wrong!");
                alert.setContentText("Your Username and Password is incorrect");
                alert.showAndWait();
            }

        }


    }

    public void splash()throws IOException
    {
        Main.isSplashLoded=true;
        AnchorPane pane = FXMLLoader.load(getClass().getResource("splash.FXML"));
        main_anchor.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1) , pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(4.8) , pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.setOnFinished((e)->{
            fadeOut.play();
        });

        fadeOut.setOnFinished((e)->{

            try {
                AnchorPane parentContent = FXMLLoader.load(getClass().getResource("sample.FXML"));
                main_anchor.getChildren().setAll(parentContent);

            }
            catch (IOException ex)
            {


            }

        });

        fadeIn.play();
    }
    @FXML
    ImageView close_icon;
    public void closeing(MouseEvent event)
    {
        Main.stage.close();
    }

    @Override
    public void initialize(URL location , ResourceBundle resources){
        try
        {
            if(Main.isSplashLoded==false)
                splash();
        }
        catch (IOException exp)
        {

        }

        // ArrayList<String> array = new ArrayList<>();
        //array.add("Abdallah");
        //array.add("Basel");

        //TextFields.bindAutoCompletion(user , array);



      /*  TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(106);
        transition.setToY(14);
        transition.setNode(twins_icon);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();*/








    }


}