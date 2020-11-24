package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
import java.sql.*;





import java.io.IOException;
import java.time.format.TextStyle;

//_______________________________________________________________________
public class Main extends Application
{
    static Stage CreateBuffer;
    public static boolean isSplashLoded = false;
    public static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception{

//sample

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

       primaryStage.setScene(scene);
        primaryStage.setWidth(1560);
        primaryStage.setHeight(840);
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
        stage = primaryStage;





    }
//_____________________________________
    static Stage addMaterial;
public static void showAadMaterial()throws IOException
{
    addMaterial = new Stage();
    Parent root = FXMLLoader.load(Main.class.getResource("Add_Material.fxml"));
    addMaterial.setTitle("Hello World");
    Scene scene = new Scene(root/*, 300, 275*/);
    scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    addMaterial.initModality(Modality.WINDOW_MODAL);


    addMaterial.setScene(scene);
    // primaryStage.setWidth(1240);
    // primaryStage.setHeight(820);
    addMaterial.setResizable(false);
    addMaterial.show();
}

    public static void closeAadMaterial()throws IOException
    {
        addMaterial.close();
    }

//______________________________________________________________________
    public static void main(String[] args)
    {
        launch(args);


    }
//________________________________________________________________________


 //______________________________________________________
static Stage addOrderStage;
    public static void showOrderStage() throws IOException
    {
        addOrderStage = new Stage();


        Parent root = FXMLLoader.load(Main.class.getResource("sa.fxml"));
        addOrderStage.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        addOrderStage.initModality(Modality.WINDOW_MODAL);


       addOrderStage.setScene(scene);
        // primaryStage.setWidth(1240);
        // primaryStage.setHeight(820);
        addOrderStage.setResizable(false);
        addOrderStage.show();

    }
//___________________________________________________________________________
    public static void closeOrderStage()throws IOException
    {
        addOrderStage.close();
    }
//____________________________________________________________________________
    static Stage addEmployeeStage;
    public static void showEmployeeStage() throws IOException
    {
        addEmployeeStage = new Stage();


        Parent root = FXMLLoader.load(Main.class.getResource("add_employee.fxml"));
        addEmployeeStage.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        addEmployeeStage.initModality(Modality.WINDOW_MODAL);


        addEmployeeStage.setScene(scene);
        // primaryStage.setWidth(1240);
        // primaryStage.setHeight(820);
        addEmployeeStage.setResizable(false);
        addEmployeeStage.show();

    }
//_____________________________________________________________________________
    public static void showCreateBuffer() throws IOException
    {
        CreateBuffer = new Stage();


        Parent root = FXMLLoader.load(Main.class.getResource("Buffer_Stage.fxml"));
        CreateBuffer.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        CreateBuffer.initModality(Modality.WINDOW_MODAL);


        CreateBuffer.setScene(scene);
        CreateBuffer.setResizable(false);
        CreateBuffer.show();
    }
//_____________________________________________________________________________
    public static void closeEmployeeStage()throws IOException
    {
        addEmployeeStage.close();
    }
//_____________________________________________________________________________
    public  static void closeCreateBuffer() throws IOException
    {
        CreateBuffer.close();
    }

    static Stage addBillStage;

    public static void showAddBill() throws IOException
    {
        addBillStage = new Stage();


        Parent root = FXMLLoader.load(Main.class.getResource("add_bill.fxml"));
        addBillStage.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        addBillStage.initModality(Modality.WINDOW_MODAL);


        addBillStage.setScene(scene);
        addBillStage.setResizable(false);
        addBillStage.show();
    }

    public static void closeAddBill()throws Exception
    {
        addBillStage.close();
    }

    static Stage printBillStage;

    public static void showPrintBillStage() throws IOException
    {
        printBillStage = new Stage();


        Parent root = FXMLLoader.load(Main.class.getResource("TwinBill.fxml"));
        printBillStage.setTitle("Hello World");
        Scene scene = new Scene(root/*, 300, 275*/);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        printBillStage.initModality(Modality.WINDOW_MODAL);


        printBillStage.setScene(scene);
       printBillStage.setResizable(false);
        printBillStage.show();
    }

    public static void closePrintBillStage()throws Exception
    {
        printBillStage.close();
    }
















}









