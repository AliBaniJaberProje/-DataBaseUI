package sample;
import java.sql.*;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.TableColumn.CellEditEvent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceDialog;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import  javafx.stage.*;
import javafx.scene.paint.Color;
import javafx.concurrent.Task;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
//import org.controlsfx.control.Notifications;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
// import org.controlsfx.control.Notifications;



public class SecondController  implements Initializable {
    boolean var = false;
    boolean main = false;
    boolean orders = false;
    boolean employee = false;
    boolean buffer = false;
    boolean factory = false;
    boolean bill = false;
    boolean Production = false;
    boolean exit = false;



    @FXML
    Button find_Employee;

    @FXML
    AnchorPane carPane;
    //Notifications x = Notifications.create();
    ObservableList<ManufactorSupplies> toAddManu = FXCollections.observableArrayList();

    @FXML
    TextField day;
    @FXML
    TextField mont;
    @FXML
    TextField yer;


    public  void emptyandsearchOrderInall()
    {

        AllOrders.clear();
        orders_table2.setItems(AllOrders);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
           // AllOrders.clear();

            ResultSet rs = stmt.executeQuery("select * from PLACE_ORDER_ALI where NAME_CUSTMER LIKE '%"+day.getText()+"%'");
            ORDER EE;
            while (rs.next()) {
                int e1= rs.getInt(1) ;
                String e2=rs.getString(2);
                double e3=rs.getDouble(3);
                double e4=rs.getDouble(4);
                String e5=rs.getString(5);//
                int e6=rs.getInt(6);
                int e7=rs.getInt(7);
                String e8=rs.getString(8);//
                String e9=rs.getString(9);
                //System.out.println(" love ");
                double e10=rs.getDouble(10);
                EE = new ORDER(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,e8,e9 ) ;
                // ORDERSS.add(EE);
                AllOrders.add(EE);
                // Manefactor mm=new Manefactor(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,""+e8 );
                // maefactor.add(mm);
                //  System.out.println( s1+s2+s3);
                orders_table2.setItems(AllOrders);



            }
            //  employeess.clear();
            // orders_table.setItems(ORDERSS);
            //orders_table1.setItems(ORDERSS);
            //manufactorTable.setItems(ORDERSS);
            //employeess.clear();



//step5 close the connection object
            con.close();

        }
        catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }






    }



    @FXML
    TableView<Employee> employee_table;
    @FXML
    Button exit_button;
    @FXML
    Button main_button;
    @FXML
    ImageView HALICOPTER;
    @FXML
    Button orders_button;
    @FXML
    Button employee_button;
    @FXML
    Button buffer_button;
    @FXML
    Button factory_button;
    @FXML
    Button bill_button;
    @FXML
    ProgressIndicator pro;
    @FXML
    ImageView account_icon;
    @FXML
    ImageView message_icon;
    @FXML
    Button Draw_Order;
    @FXML
    Button manuAddButton1;
    @FXML
    ImageView notification_icon;
    @FXML
    ImageView back_icon;
    @FXML
    ImageView header_icon;
    @FXML
    Label header_label;
    //@FXML
    // AnchorPane order_pane;
    @FXML
    AnchorPane employee_pane;
    @FXML
    Button add_employee;
    // Button edit_employee
    @FXML
    TableView<ORDER> orders_table;
    @FXML
    AnchorPane MAIN_PANE;
    @FXML
    TableView<ORDER> orders_table1;
    @FXML
    TableView<ORDER> orders_table2;
    @FXML
    AnchorPane orders_pane;
    @FXML
    Button addOrder;
    @FXML
    AnchorPane buffer_Pane;

    @FXML
    Button Production_costs;
    @FXML
    AnchorPane Costs_Pane;

    @FXML
    AnchorPane factory_pane;
    @FXML
    AnchorPane bill_pane;
    @FXML
    Button add_bill;
    @FXML
    Button show_bill;
    @FXML
    Button print_bill;
    @FXML
    WebView web_page;
    @FXML
    AnchorPane web_pane;
    //@FXML
    //WebView Acount_pane;
    //@FXML
    // AnchorPane Acount;
    @FXML
    ImageView setting_icon;
    @FXML
    TextField T1_O;
    @FXML
    TextField T2_O;
    @FXML
    TextField T3_O;
    @FXML
    TextField T4_O;
    @FXML
    ComboBox T5_O;
    @FXML
    TextField T6_O;
    @FXML
    TextField T7_O;
    @FXML
    TextField T8_O;
    @FXML
    TableColumn N_O, ID_O, WH_O, Z_O, T_O, NC_O, PHC_O, IDC_O;
    @FXML
    ComboBox manuTypeCombo;
    @FXML
    ComboBox manuSizeCombo;
    @FXML
    TextField manuQuantityText;
    @FXML
    TextField manuMeterPriceText;
    @FXML
    Button manuAddButton;
    @FXML
    TableView<ManufactorSupplies> manufactorTable;
    @FXML
    TableColumn<ManufactorSupplies , String> manuTypeCol;
    @FXML
    TableColumn<ManufactorSupplies , String> manuSizeCol;
    @FXML
    TableColumn<ManufactorSupplies , Integer> manuQuantityCol;
    @FXML
    TableColumn<ManufactorSupplies , Double> manuMeterPriceCol;
    @FXML
    AnchorPane manufactorsPane;

    @FXML
    TableColumn<Car , String> carNoCol;
    @FXML
    TableColumn<Car , String>driverNameCol;
    @FXML
    TableColumn<Car , String>carPriceCol;
    @FXML
    TableColumn<Car , String>purchaseDateCol;
    @FXML
    TextField carNoText;
    @FXML
    ComboBox driverNameCombo;
    @FXML
    TextField carTypeText;
    @FXML
    TextField carPriceText;
    @FXML
    DatePicker carDatePick;
    @FXML
    Button addCarButton;
    @FXML TableView<Car> carTable;
    @FXML
    ProgressIndicator logout_indicator;
    @FXML
    Text loggingout_text;

    @FXML
    TableColumn N_O1, ID_O1, WH_O1, Z_O1, T_O1, NC_O1, PHC_O1, IDC_O1;
    @FXML
    Button manufactorsButton;
    @FXML
    ImageView carIcon;
    @FXML
    TableColumn<ORDER , String> orderdeliveryDateCol ;
    @FXML
    TableColumn orderdeliveryDateCol1;
    @FXML
    TableColumn orderDateCol12;
    @FXML
    TableColumn idM;
    @FXML
    TableColumn N_O2;
    @FXML
    TableColumn ID_O2;
    @FXML
    TableColumn WH_O2;
    @FXML
    TableColumn Z_O2;
    @FXML
    TableColumn T_O2;
    @FXML
    TableColumn NC_O2;
    @FXML
    TableColumn IDC_O2 ;
    @FXML
    TableColumn PHC_O2 ;
    @FXML
    Button addCarButton1;











    @FXML
    TableColumn orderDateCol1;
    @FXML
    DatePicker orderDeliveryDatePicker;
    @FXML
    TableColumn<ORDER , String> orderDateCol;
    @FXML
    TableColumn OrderDateCol;
    //  @FXML
    //  TableColumn name;
    ObservableList<EmployeeAddToTable> to_add = FXCollections.observableArrayList();
//____________________________________________________
  /*  public  TableView refarans_of_employee_table()
    {
        return employee_table;
    }
    */

    //_______________________________________
//___________________________________________________________________________________________________________________
    DropShadow shadow = new DropShadow();




    public void mousePressed(MouseEvent event) {

        if (event.getSource() == main_button) {
            main_button.setEffect(shadow);
        }
        if (event.getSource() == orders_button) {
            orders_button.setEffect(shadow);
        }
        if (event.getSource() == employee_button) {
            employee_button.setEffect(shadow);
        }
        if (event.getSource() == buffer_button) {
            buffer_button.setEffect(shadow);
        }
        if (event.getSource() == factory_button) {
            factory_button.setEffect(shadow);
        }
        if (event.getSource() == bill_button) {
            bill_button.setEffect(shadow);
        }
        if (event.getSource() == Production_costs) {
            Production_costs.setEffect(shadow);
        }
        if (event.getSource() == exit_button) {
            exit_button.setEffect(shadow);
        }
        if (event.getSource() == account_icon) {
            account_icon.setEffect(shadow);
        }
        if (event.getSource() == message_icon) {
            message_icon.setEffect(shadow);
        }
        if (event.getSource() == notification_icon) {
            notification_icon.setEffect(shadow);
        }
        if (event.getSource() == back_icon) {
            back_icon.setEffect(shadow);
        }
        if (event.getSource() == setting_icon) {
            setting_icon.setEffect(shadow);
        }


    }

    //___________________________________________________________________________________________________________________
    public void mouseReleased(MouseEvent event) {

        if (event.getSource() == main_button) {
            main_button.setEffect(null);

            // Notifications c=Notifications.create().title("Ali").text(" Ali").graphic(null).position(Pos.BOTTOM_RIGHT).darkStyle().hideAfter(Duration.INDEFINITE);


            //   c.showWarning();

        }
        if (event.getSource() == orders_button) {
            orders_button.setEffect(null);
        }
        if (event.getSource() == employee_button) {
            employee_button.setEffect(null);
        }
        if (event.getSource() == buffer_button) {
            buffer_button.setEffect(null);
        }
        if (event.getSource() == factory_button) {
            factory_button.setEffect(null);
        }
        if (event.getSource() == bill_button) {
            bill_button.setEffect(null);
        }
        if (event.getSource() == Production_costs) {
            Production_costs.setEffect(null);
        }
        if (event.getSource() == exit_button) {
            exit_button.setEffect(null);
        }
        if (event.getSource() == account_icon) {
            account_icon.setEffect(null);
        }

        if (event.getSource() == message_icon) {
            message_icon.setEffect(null);
        }
        if (event.getSource() == notification_icon) {
            notification_icon.setEffect(null);
        }
        if (event.getSource() == back_icon) {
            back_icon.setEffect(null);
        }
        if (event.getSource() == setting_icon) {
            setting_icon.setEffect(null);
        }


    }
///////////////////////////////
    /////////////////
    ////////////////////

    @FXML
    TableColumn <Employee,String> nameColumn_E;
    @FXML
    TableColumn <Employee,String> sexColumn_E;
    @FXML
    TableColumn <Employee,Integer> IDColumn_E;
    @FXML
    TableColumn <Employee,String> jop_typeColumn_E;
    @FXML
    TableColumn<Employee,String>  EmailColumn_E;
    @FXML
    TableColumn<Employee,String>  start_dateColumn_E;
    @FXML
    TableColumn <Employee,Double> salaryColumn_E;
    @FXML
    TableColumn <Employee,String> addressColumn_E;
    @FXML
    TableColumn<Employee,String>  martial_stateColumn_E;
    @FXML
    TableColumn <Employee,Integer> number_chColumn_E;
    @FXML
    TableColumn<Car , String>carTypeCol;
    ObservableList<Car> data = FXCollections.observableArrayList();
    @FXML
    TextField id_e_text;
    @FXML
    TextField NAME_E_TEXT;
    @FXML
    ComboBox SEX_E_TEXT;
    GregorianCalendar calendar = new GregorianCalendar();

    @FXML
    TextField SALARY_E_TEXT;
    @FXML
    TextField EMAIL_E_TEXT;
    @FXML
    TextField ADDRESS_E_TEXT;
    @FXML
    TextField NO_CH_E_TEXT;
    @FXML
    ComboBox martialState_e;
    @FXML
    ComboBox job_type;
    @FXML
    DatePicker start_e;
    @FXML
    Button animationButton;
    @FXML
            TextField textfindEmployee;
    ObservableList<Employee> TO_add_employee = FXCollections.observableArrayList();

    @FXML
    Button deletOrder;
    @FXML
    Button addOrder2;

   void retreavCar()
   {
       ObservableList<Car> to_addcar = FXCollections.observableArrayList();


       to_addcar.clear();
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select * from  CAR");

           while (rs.next()) {
               int x1= rs.getInt(1) ;
               double x2=rs.getDouble(2);
               String x3=rs.getString(3);
               String x4=rs.getString(4);
               String x5=rs.getString(5);

              // Car vv= ;

               to_addcar.add(new Car(""+x1,x4,x2,x3,x5));


           }
           carTable.setItems(to_addcar);
           con.close();

       }
       catch (SQLException ex) {
           System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeee");
       } catch (ClassNotFoundException ex) {
           System.out.println("Ameer");
       }



   }


    //___________________________________________________________________________________________________________________
//**This function Handles Button on Action Occured

   @FXML
   Button find_Employee11;
   @FXML
   Button deletEmployee;
  public  void   todeletcars( String idor){

      int delet_E;
      try {
          delet_E = Integer.parseInt(idor);

      } catch (Exception e) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("عملية ادخال خاطئة");
          alert.setHeaderText("اعد ادخال  بشكل صحيح ");
          // alert.setContentText("Ooops, there was an error!");

          alert.showAndWait();
          return;
      }


      int result = 0;
      try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con = DriverManager.getConnection(
                  "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
          Statement stmt = con.createStatement();

          PreparedStatement st = con.prepareStatement("DELETE  from  CAR where  VEHICLE_ID= " + Integer.parseInt(idor));


          int a = st.executeUpdate();
          if (a > 0) {
              System.out.println(" don ");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle(" حذف وبيع  السيارة ");
              alert.setHeaderText("  تم حذف السارة و بيعها بنجاح ");
              alert.setContentText("  ");
              alert.showAndWait();
              addAllorderinfineshed();
          }
          else {
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle(" حذف و بيع سيارة ");
              alert.setHeaderText("  لا يوجد سيارة بنفس رقم الرقم المدخل ");
              alert.setContentText(" ");
              alert.showAndWait();

          }
      } catch (SQLIntegrityConstraintViolationException x) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("ادخال خاطئة");
          alert.setHeaderText("  رقم ال  موجود بالفعل ");
          // alert.setContentText("Ooops, there was an error!");
          // alert.showAndWait();

      } catch (Exception e) {
          System.out.println("exeption ");
          System.out.println(e);
      }


  }

    public void buttonActions(ActionEvent event)  throws IOException {

        if( event.getSource()==addCarButton1)
        {
            TextInputDialog dialog = new TextInputDialog("walter");
            dialog.setTitle("  بيع و حدف  سيارة  ");
            dialog.setHeaderText("   ادخل رقم السيارة التي تريد بيعها  ");
            dialog.setContentText(" ");
            Optional<String> idor = dialog.showAndWait();
            if (idor.isPresent()) {
                todeletcars(idor.get());
                retreavCar();

            }


        }










        if( event.getSource()==manuAddButton1)
        {
            TextInputDialog dialog = new TextInputDialog("walter");
            dialog.setTitle("  حذف صنف  ");
            dialog.setHeaderText("   ادخل رقم الصنف الذي تريد حذفه  ");
            dialog.setContentText(" ");
            Optional<String> idor = dialog.showAndWait();
            if (idor.isPresent()) {
                todeletsanf(idor.get());
                retrevBufer();

            }

        }



        if(event.getSource()==addOrder2){
            orders_table1.setItems(ORDERSS);
           // orders_table.setItems(ee);
            orders_pane.setVisible(false);
            factory_pane.setVisible(true);
            MAIN_PANE.setVisible(false);


        }




        if(event.getSource()==deletOrder){
            TextInputDialog dialog = new TextInputDialog("walter");
            dialog.setTitle("  حذف طلب  ");
            dialog.setHeaderText("   ادخل رقم الطلب الذي تريد حذفه  ");
            dialog.setContentText(" ");
            Optional<String> idor = dialog.showAndWait();
            if (idor.isPresent()) {
                todeletOrder( idor.get());

            }






        }








        if( event.getSource() ==deletEmployee)
        {
            TextInputDialog idd = new TextInputDialog();
            idd.setTitle("  حذف موظف   ");
            idd.setHeaderText(" ادخال رقم الموظف(ID ) ");
            idd.setContentText(" ادخال (ID)  ");
            Optional<String> id = idd.showAndWait();
            if( id.isPresent()) {
                System.out.println(id.get());

            }
            int delet_E;
            try {
                delet_E = Integer.parseInt(id.get());

            }
            catch ( Exception e ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("عملية ادخال خاطئة");
                alert.setHeaderText("اعد ادخال  بشكل صحيح ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                return;
            }



          int result=  MYSQL.deletEmployee(delet_E );
            retrieveEmployee();
            if( result ==  2){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                addemployeedrivar();

                alert.setTitle(" حذف الموظف ");
                alert.setHeaderText("  تم عملية الحذف بنجاح ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                addemployeedrivar();


            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("  الموظفين ");
                addemployeedrivar();

                alert.setHeaderText(" لا يوجد موظف بنفس id المدخل  ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();


            }

            addemployeedrivar();

        }


       if( event.getSource()==find_Employee){
           toEmtyEmployeeTable();

       }
       if( event.getSource()==find_Employee11){

           int find=0;

           TextInputDialog dialog = new TextInputDialog("walter");
           dialog.setTitle("التاكيد من صلاحيتك لتعديل بيانات الموظفين");
           dialog.setHeaderText("ادخل كلمة السر للتطبيق  ");
           dialog.setContentText("  ادخل كلمة السر ");

           Optional<String> result = dialog.showAndWait();
           if (result.isPresent()){

               if( result.get().equals("123456")){

                   System.out.println( result.get());
                   retrieveEmployee();
                   TextInputDialog idd = new TextInputDialog();
                   idd.setTitle("الرجاء ادخل رقم الموظف الذي تريد تعديل بياناته");
                   idd.setHeaderText(" ادخال رقم الموظف(ID ) ");
                   idd.setContentText(" ادخال (ID)  ");
                   Optional<String> id = idd.showAndWait();
                   if( id.isPresent()) {
                       try {
                           Class.forName("oracle.jdbc.driver.OracleDriver");

                           retrieveEmployee();
                           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
                           Statement stmt = con.createStatement();
                           ResultSet rs = stmt.executeQuery("select ID from EMPLOYEE_TWINS");
                           retrieveEmployee();
                           while (rs.next()) {
                               if ( rs.getInt(1)==Integer.parseInt(id.get())){
                                   find=2;

                               }
                               retrieveEmployee();


                           }
                           if( find==0){
                               retrieveEmployee();
                               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                               alert.setTitle("التعديل ");
                               alert.setHeaderText(" لا يوجد موظف بنفس ال id المدخل    ");
                               // alert.setContentText("Ooops, there was an error!");

                               alert.showAndWait();
                               return;
                           }

                           else{



                           }
                           employeess.clear();

                           con.close();

                       }
                       catch (SQLException ex) {
                           System.out.println("Abdallah");
                       } catch (ClassNotFoundException ex) {
                           System.out.println("Ameer");
                       }


                   }
                   try {
                       retrieveEmployee();
                       int x = Integer.parseInt(id.get());

                   }
                    catch ( Exception e ){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("عملية ادخال خاطئة");
                        alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
                        // alert.setContentText("Ooops, there was an error!");

                        alert.showAndWait();
                        return;
                    }


                   retrieveEmployee();

                   TextInputDialog named = new TextInputDialog("walter");
                   named.setTitle("تعديل اسم الموظف");
                   named.setHeaderText(" انت الان تعدل على بيانات الموظف  "+id.get()  );
                   named.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> name = named.showAndWait();
                   if( name.isPresent()) {
                   System.out.println(name.get());
                   }
                   retrieveEmployee();

                   ArrayList< String> choices = new ArrayList<String>();
                   choices.add("ذكر");
                   choices.add("انثى");
                   ChoiceDialog<String> sexd = new ChoiceDialog<>("ذكر", choices);
                   sexd.setTitle("التعديل على الجنس");
                   sexd.setHeaderText( " انت الان تعدل على بيانات الموظف  "+id.get());
                   sexd.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> sex = sexd.showAndWait();
                   if (sex.isPresent()){
                       System.out.println( sex.get());
                   }

                   retrieveEmployee();

                   ArrayList< String> type = new ArrayList<String>();
                   type.add("عامل ");
                   type.add("مدير مستودع ");
                   type.add(" سائق سيارة ");
                   type.add("  عامل تنظيف ");
                   type.add("  مراسل   ");
                   retrieveEmployee();
                   ChoiceDialog<String> jobtype = new ChoiceDialog<>("عامل", type);
                   jobtype.setTitle("التعديل على  نوع الوظيفة");
                   jobtype.setHeaderText( " انت الان تعدل على بيانات الموظف  "+id.get());
                   jobtype.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> job = jobtype.showAndWait();
                   if (job.isPresent()){
                       System.out.println( job.get());
                   }
                   retrieveEmployee();

                   TextInputDialog phd = new TextInputDialog("walter");
                   phd.setTitle("تعديل رقم تلفون الموظف");
                   phd.setHeaderText(" انت الان تعدل على بيانات الموظف  "+id.get()  );
                   phd.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> ph = phd.showAndWait();
                   if( ph.isPresent()) {
                       System.out.println(ph.get());
                   }


                   retrieveEmployee();
                   try {
                       int x = Integer.parseInt(ph.get());

                   }
                   catch ( Exception e ){
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setTitle("عملية ادخال خاطئة");
                       alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
                       // alert.setContentText("Ooops, there was an error!");

                       alert.showAndWait();
                       return;
                   }
                   retrieveEmployee();

                  // GregorianCalendar calendar = new GregorianCalendar();

                   String d= ""+ LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))  ;

                   TextInputDialog sald = new TextInputDialog("walter");
                   sald.setTitle("تعديل راتب الموظف  ");
                   sald.setHeaderText(" انت الان تعدل على بيانات الموظف  "+id.get()  );
                   sald.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> sal = sald.showAndWait();
                   if( sal.isPresent()) {
                       System.out.println(sal.get());
                       retrieveEmployee();
                   }
                   try {
                       double x = Double.parseDouble(sal.get());
                       retrieveEmployee();
                   }

                   catch ( Exception e ){
                       retrieveEmployee();
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setTitle("عملية ادخال خاطئة");
                       alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
                       // alert.setContentText("Ooops, there was an error!");

                       alert.showAndWait();
                       return;
                   }




                   retrieveEmployee();
                   TextInputDialog addressd = new TextInputDialog("walter");
                   addressd.setTitle("تعديل عنوان الموظف  ");
                   addressd.setContentText(" ادخال معللومات جديدة ");
                   addressd.setHeaderText(" انت الان تعدل على بيانات الموظف  "+id.get());
                   Optional<String> addres = addressd.showAndWait();
                   if( addres.isPresent()) {
                       retrieveEmployee();
                       System.out.println(addres.get());
                   }
                   retrieveEmployee();
                   ArrayList< String> martial = new ArrayList<String>();
                   martial.add("اعزب ");
                   martial.add("متزوج  ");
                   martial.add(" مطلق  ");
                 //  martial.add("  عامل تنظيف ");
                  // martial.add("  مراسل   ");
                   retrieveEmployee();
                   ChoiceDialog<String> mard = new ChoiceDialog<>("متزوج", martial);
                   mard.setTitle("التعديل على  الحالة الاجتماعية");
                   mard.setHeaderText( " انت الان تعدل على بيانات الموظف  "+id.get());
                   mard.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> mar = mard.showAndWait();
                   if (mar.isPresent()){
                       retrieveEmployee();
                       System.out.println( mar.get());
                   }
                   retrieveEmployee();
                   TextInputDialog chd = new TextInputDialog("walter");
                   chd.setTitle("تعديل عدد اطفال الموظف  ");
                   chd.setHeaderText(" انت الان تعدل على بيانات الموظف  "+id.get()  );
                   chd.setContentText(" ادخال معللومات جديدة ");
                   Optional<String> ch = chd.showAndWait();
                   if( ch.isPresent()) {
                       retrieveEmployee();
                       System.out.println(ch.get());
                   }
                   try {
                       retrieveEmployee();
                       int x = Integer.parseInt(ch.get());

                   }
                   catch ( Exception e ){
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setTitle("عملية ادخال خاطئة");
                       alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
                       // alert.setContentText("Ooops, there was an error!");

                       alert.showAndWait();
                       return;

                   }
                   retrieveEmployee();
               int ttt=MYSQL.upDateEmployee(Integer.parseInt(ph.get()),
                           Double.parseDouble(   sal.get()),
                           addres.get(),name.get(), mar.get(),job.get(),
                           Integer.parseInt( ch.get()),sex.get(),
                           Integer.parseInt( id.get()));



                   retrieveEmployee();
                   addemployeedrivar();
                   addemployeedrivar();


                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle(" تم تعديل الموظف بنجاح ");
                       alert.setHeaderText(" تم تعديل الموظف بنجاح    \uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A ");
                       // alert.setContentText("Ooops, there was an error!");

                       alert.showAndWait();

















               }
               else {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("ليس لديك اي صلاحية ");
                   alert.setHeaderText("");
                   alert.setContentText("لن تتمكن من تعديل اي بيانات الا بتأكيد كلمة المرور");

                   alert.showAndWait();
                   return;
               }
           }




       }





        if( event.getSource()==animationButton)
        {
//            loggingout_text.setVisible(true);
            orders_pane.setVisible(false);

            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            carPane.setVisible(true);
            manufactorsPane.setVisible(false);
            MAIN_PANE.setVisible(false);
        }

        if (event.getSource() == Draw_Order) {
            //  Process pro = Runtime.getRuntime().exec("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories");
        }


        if (event.getSource() == exit_button) {
            logout_indicator.setVisible(true);
            loggingout_text.setVisible(true);
            orders_pane.setVisible(false);
            carPane.setVisible(false);
            MAIN_PANE.setVisible(false);

            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            manufactorsPane.setVisible(false);

            LoginTask task = new LoginTask();

            logout_indicator.progressProperty().bind(task.progressProperty());
            new Thread(task).start();

            logout_indicator.progressProperty().addListener((obs, oldValue, newValue) -> {
                if (newValue.doubleValue() >= 1.0) {
                    try {
                        Parent sroot = FXMLLoader.load(getClass().getResource("sample.fxml"));
                        Scene tab = new Scene(sroot);
                        tab.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(tab);
                        window.setHeight(950);

                        window.show();
                    } catch (IOException ecp) {

                    }


                }

            });


          /*  Parent sroot = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene tab = new Scene(sroot);
            tab.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tab);

            window.show();*/

        }//ifSource
        //----------------------------------------------------------------
        if (event.getSource() == main_button) {
            MAIN_PANE.setVisible(true);




           /* try {
                Class.forName("oracle.jdbc.driver.OracleDriver");


                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from EMPLOYEE_TWINS");

                while (rs.next())
                    System.out.println(rs.getInt(1) + " "
                            + rs.getString(2) + " "
                            + rs.getInt(3)
                            + " " + rs.getInt(4)
                            + " " + rs.getString(5)
                            + " " + rs.getString(6)
                            + " " + rs.getString(7)
                            + " " + rs.getString(8)
                            + " " + rs.getInt(9)
                            + " " + rs.getString(10));

//step5 close the connection object
                con.close();

            }
            catch (SQLException ex) {
                System.out.println("Abdallah");
            } catch (ClassNotFoundException ex) {
                System.out.println("Ameer");
            }

            */











/*
            Notifications notifications;
            notifications = Notifications.create()
                    .title("Poato")
                    .text("Hello, world!")
                    .graphic(null)
                    .position(Pos.BOTTOM_RIGHT)
                    .darkStyle()
                    .hideAfter(Duration.INDEFINITE);

            notifications.showWarning();
            */


            carPane.setVisible(false);
         /*  String e =  (String) OrderDateCol.getCellObservableValue(0).getValue();
            System.out.println(e);
            System.out.println(orders_table.getItems().size());
            GregorianCalendar calendar = new GregorianCalendar();
            if((LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH)  )).equals(e));
            System.out.println("YEEEEEEEEEEEEEES");*/







           /* TablePosition pos = orders_table.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            String data = (String) orderdeliveryDateCol.getCellObservableValue(row).getValue();
            System.out.println(data);*/



            //Process pro = Runtime.getRuntime().exec("C:/Program Files (x86)/National Instruments/Circuit Design Suite 14.1/multisim.exe");

            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            manufactorsPane.setVisible(false);
            //Acount.setVisible(false);
            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/home-page-icon.png")));
            header_label.setText(main_button.getText());


        }
        //-----------------------------------------------------------------
        if (event.getSource() == orders_button) {
            carPane.setVisible(false);

            //Acount.setVisible(false);
            orders_pane.setVisible(true);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            manufactorsPane.setVisible(false);
            MAIN_PANE.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/order.png")));
            header_label.setText(orders_button.getText());


        }
        //-----------------------------------------------------------------
        if (event.getSource() == employee_button) {
            carPane.setVisible(false);

            //  Acount_pane.setVisible(false);
            employee_pane.setVisible(true);
            orders_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);
            manufactorsPane.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/employee.png")));
            header_label.setText(employee_button.getText());
        }
        //------------------------------------------------------------------
        if (event.getSource() == buffer_button) {
            carPane.setVisible(false);

            //  Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(true);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);
            manufactorsPane.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/warehouse.png")));
            header_label.setText(buffer_button.getText());

        }
        //------------------------------------------------------------------
        if (event.getSource() == factory_button) {
            carPane.setVisible(false);

            //  Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(true);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);
            manufactorsPane.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/factory.png")));
            header_label.setText(factory_button.getText());
        }
        //------------------------------------------------------------------
        if (event.getSource() == Production_costs) {
            carPane.setVisible(false);

            // Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(true);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);
            manufactorsPane.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/production.png")));
            header_label.setText(Production_costs.getText());
        }
        //-----------------------------------------------------------------


        if (event.getSource() == bill_button) {
            carPane.setVisible(false);

            // Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(true);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);
            manufactorsPane.setVisible(false);

            header_icon.setImage(new Image(getClass().getResourceAsStream("/images/bill.png")));
            header_label.setText(bill_button.getText());
        }
        //----------------------------------------------------------------
        if (event.getSource() == add_employee) {
            carPane.setVisible(false);


            // Main.showEmployeeStage();
            if (id_e_text.getText().isEmpty() || SALARY_E_TEXT.getText().isEmpty() ||
                    ADDRESS_E_TEXT.getText().isEmpty() || NAME_E_TEXT.getText().isEmpty() ||
                    NO_CH_E_TEXT.getText().isEmpty() || start_e.getValue().toString().isEmpty() ||
                    EMAIL_E_TEXT.getText().isEmpty() || martialState_e.getSelectionModel().getSelectedItem().toString().isEmpty() ||
                    martialState_e.getSelectionModel().getSelectedItem().toString().isEmpty() ||
                    job_type.getSelectionModel().getSelectedItem().toString().isEmpty()) {


                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("  تحذير  ");
                alert.setHeaderText("  لا يمكن اضافة موظف الا بأدخال كافة بياناته ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                return;

            }


            try {
                MYSQL.addEmployee(Valedation.check_integer(id_e_text)
                        , start_e.getValue().toString(), Valedation.check_integer(EMAIL_E_TEXT)
                        , Valedation.chech_double(SALARY_E_TEXT),
                        ADDRESS_E_TEXT.getText(),
                        NAME_E_TEXT.getText(), martialState_e.getSelectionModel().getSelectedItem().toString(),
                        job_type.getSelectionModel().getSelectedItem().toString(),
                        Valedation.check_integer(NO_CH_E_TEXT),
                        SEX_E_TEXT.getSelectionModel().getSelectedItem().toString());
                addemployeedrivar();
            }
            catch ( Exception e ){

            }






            NAME_E_TEXT.clear();
            // SEX_E_TEXT.clear();
            id_e_text.clear();
            // SEX_E_TEXT.clear();
            EMAIL_E_TEXT.clear();
            ADDRESS_E_TEXT.clear();
            NO_CH_E_TEXT.clear();
/*
            for ( int xi = 0; xi<employee_table.getItems().size(); xi++) {
                employee_table.getItems().clear();
            }
            */
            employeess.clear();
            retrieveEmployee();

        }
        //----------------------------------------------------------------
        if (event.getSource() == addOrder) {

            if(
                    T3_O.getText().isEmpty()||
                    T4_O.getText().isEmpty()||
                    T6_O.getText().isEmpty()||
                    T8_O.getText().isEmpty()||
                    T7_O.getText().isEmpty()||T1_O.getText().isEmpty() ){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("  تحذير  ");
                alert.setHeaderText("  لا يمكن اضافة طلب الا بأدخال كافة بياناته ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                return;

            }

            int idorder=  MYSQL.getIDoRDER();

            //  Main.showOrderStage();
            addToTable();
            Date date = new Date();
            //GregorianCalendar calendar = new GregorianCalendar();
          /*  MYSQL.addOrder(Valedation.check_integer(T2_O),
                    T5_O.getSelectionModel().getSelectedItem().toString() ,
                    Valedation.chech_double(T3_O),
                    Valedation.chech_double(T4_O),
                    Valedation.chech_double(T1_O),
                   Valedation.check_integer(T7_O) );
            MYSQL.addCustmer(T6_O.getText(),Valedation.check_integer(T8_O),Valedation.check_integer(T7_O));
            */
            //MYSQL.addPLACE_ORDER_cus((LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))).toString(),orderDeliveryDatePicker.getValue().toString() );




            MYSQL.add_PLACE_ORDER_ALI(8,
                  T5_O.getSelectionModel().getSelectedItem().toString(),
                  Valedation.chech_double(T3_O),
                  Valedation.chech_double(T4_O),
                  T6_O.getText(),
                  Valedation.check_integer(T8_O),
                  Valedation.check_integer(T7_O),
                  (LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))).toString(),
                  orderDeliveryDatePicker.getValue().toString(),
                  Valedation.chech_double(T1_O));




            retrieveOrder();




                  ;
           /* String OR[] = {T1_O.getText(), T2_O.getText(), T3_O.getText(), T4_O.getText(),
                    T5_O.getSelectionModel().getSelectedItem().toString(), T6_O.getText(), T7_O.getText(), T8_O.getText() ,orderDeliveryDatePicker.getValue().toString() ,(LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH)  )).toString()};

            ORD.add(new ORDER(OR[0],
                    OR[1],
                    OR[2],
                    OR[3],
                    OR[4],
                    OR[5],
                    OR[6],
                    OR[7] , OR[8] , OR[9]));

            orders_table.setItems(ORD);

            */
           // orders_table1.setItems(ORD);




            carPane.setVisible(false);

        }
        //----------------------------------------------------------------

        //--------------------------------------------------------------

        //----------------------------------------------------------------
        if (event.getSource() == add_bill) {

            Main.showAddBill();
        }
        if (event.getSource() == print_bill) {
            Main.showPrintBillStage();
        }
         if( event.getSource()==manuAddButton1){



         }


        if(event.getSource()==addCarButton)
        {
          //  ObservableList<Car> ToAddCar = FXCollections.observableArrayList();

          //  Car car = new Car();

            if(carNoText.getText().isEmpty() || carPriceText.getText().isEmpty() || carTypeText.getText().isEmpty()  )
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" تحذير ");
                alert.setHeaderText("  لا يمكن شراء سيارة الا بادخال كافة البيانات ");
                // alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
                return;
            }

            try {
                MYSQL.addCar(Valedation.check_integer(carNoText), Valedation.check_integer(carPriceText),carDatePick.getValue().toString(),
                        driverNameCombo.getSelectionModel().getSelectedItem().toString(),
                        carTypeText.getText() );

                }
            catch ( Exception e ){


            }


          //  retreavCar();


          /* Car car=  new Car(carNoText.getText(),
                           ""+ driverNameCombo.getSelectionModel().getSelectedItem(),
                          Integer.parseInt(carPriceText.getText()),
                      ""+carDatePick.getValue(),
                         carTypeText.getText()

                            );
            data.add(car);

           carTable.setItems(data);
           */
            retreavCar();


        }

        if(event.getSource()==manufactorsButton)
        {
            manufactorsPane.setVisible(true);
            carPane.setVisible(false);

            // Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(false);
            MAIN_PANE.setVisible(false);



        }



    }//function buttonActions
    private void todeletsanf(String idor) {

        int delet_E;
        try {
            delet_E = Integer.parseInt(idor);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("عملية ادخال خاطئة");
            alert.setHeaderText("اعد ادخال  بشكل صحيح ");
            // alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
            return;
        }


        int result = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();

            PreparedStatement st = con.prepareStatement("DELETE  from  MANUFACTOR_SUPPLIES where  TYPE_NO= " + Integer.parseInt(idor));


            int a = st.executeUpdate();
            if (a > 0) {
                System.out.println(" don ");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" حذف الصنف ");
                alert.setHeaderText("  تم حذف الصنف بنجاح ");
                alert.setContentText("  ");
                alert.showAndWait();
                addAllorderinfineshed();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" حذف صنف ");
                alert.setHeaderText("  لا يوجد صنف بنفس رقم الطلب المدخل ");
                alert.setContentText(" ");
                alert.showAndWait();

            }
        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  رقم الصنف  موجود بالفعل ");
            // alert.setContentText("Ooops, there was an error!");
            // alert.showAndWait();

        } catch (Exception e) {
            System.out.println("exeption ");
            System.out.println(e);
        }
        retrevBufer();


        }



        private void todeletOrder(String idor) {




        int delet_E;
        try {
            delet_E = Integer.parseInt(idor);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("عملية ادخال خاطئة");
            alert.setHeaderText("اعد ادخال  بشكل صحيح ");
            // alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
            return;
        }


        int result = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();

            PreparedStatement st = con.prepareStatement("DELETE  from  PLACE_ORDER_ALI where  ORDER_NUMBER= " + Integer.parseInt(idor));


            int a = st.executeUpdate();
            if (a > 0) {
                System.out.println(" don ");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" حذف طلب ");
                alert.setHeaderText("  تم حذف طلب بنجاح ");
                alert.setContentText("  ");
                 alert.showAndWait();
                addAllorderinfineshed();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" حذف طلب ");
                alert.setHeaderText("  لا يوجد طلب بنفس رقم الطلب المدخل ");
                alert.setContentText(" ");
                alert.showAndWait();

            }
        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  رقم الID  موجود بالفعل ");
            // alert.setContentText("Ooops, there was an error!");
            // alert.showAndWait();

        } catch (Exception e) {
            System.out.println("exeption ");
            System.out.println(e);
        }
        retrieveOrder();
    }

    public void toEmtyEmployeeTable() {
        addAllorderinfineshed();
        employeess.clear();
        employee_table.setItems(employeess);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from EMPLOYEE_TWINS where NAME LIKE '%"+textfindEmployee.getText()+"%'");

            while (rs.next()) {


                int x1= rs.getInt(1) ;
                String s1=rs.getString(2);
                int x2=rs.getInt(3);
                double x3=rs.getDouble(4);
                String s2=rs.getString(5);
                String s3=rs.getString(6);
                String s4=rs.getString(7);
                String s5=rs.getString(8);
                int x4=rs.getInt(9);
                String s6=rs.getString(10);
                Employee vv= new Employee(s3,s6,x1,s5,x2,s1,x3,s2,s4,x4 ) ;

                employeess.add(vv);
            }
            //  employeess.clear();
            employee_table.setItems(employeess);
            //employeess.clear();



//step5 close the connection object
            con.close();

        }
        catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }










    }

    ObservableList<ORDER> ORD = FXCollections.observableArrayList();

    private void addToTable() {

    }

public  void retrevBufer(){

    toAddManu.clear();
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");


        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from MANUFACTOR_SUPPLIES");
        ORDER EE;
        addAllorderinfineshed();
        while (rs.next()) {
            int e1= rs.getInt(1) ;
            String e2=rs.getString(2);
            String e3=rs.getString(3);
            double e4=rs.getDouble(4);
            String e5=rs.getString(5);//
            int e6=rs.getInt(6);
            ManufactorSupplies manufactorSupplies = new ManufactorSupplies(e2
                    , e3,
                    e6 ,
                    e4,e1++);

            toAddManu.add(manufactorSupplies);
            // Manefactor mm=new Manefactor(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,""+e8 );
            // maefactor.add(mm);
            //  System.out.println( s1+s2+s3);


        }
        //  employeess.clear();
        orders_table.setItems(ORDERSS);
        //orders_table1.setItems(ORDERSS);
        //manufactorTable.setItems(ORDERSS);
        //employeess.clear();



//step5 close the connection object
        con.close();

    }
    catch (SQLException ex) {
        System.out.println("Abdallah");
    } catch (ClassNotFoundException ex) {
        System.out.println("Ameer");
    }






}





    ObservableList<ORDER> AllOrders = FXCollections.observableArrayList();
    ObservableList<ORDER> endallOrder = FXCollections.observableArrayList();

//____________________________________________________________________________________________________________________
ObservableList<ORDER> ORDERSS = FXCollections.observableArrayList();

    //***this Function Handles Button When Mouse Entered Buttons Regeon
    public void mouseActions(MouseEvent event) {    //---------------------------------------------------------------------------------------------------
        if (event.getSource() == Production_costs) {
            setBlue(Production_costs);
        }
        //----------------------------------------------------------------------------------------------------
        if (event.getSource() == main_button) {
            setBlue(main_button);
        }//---------------------------------------------------------------------------------------------
        else if (event.getSource() == orders_button) {
            setBlue(orders_button);
        }//---------------------------------------------------------------------------------------------
        else if (event.getSource() == employee_button) {
            setBlue(employee_button);
        }//------------------------------------------------------------------------------------------------
        else if (event.getSource() == bill_button) {
            setBlue(bill_button);
        }//-----------------------------------------------------------------------------------------------
        else if (event.getSource() == factory_button) {
            setBlue(factory_button);
        }//--------------------------------------------------------------------------------------------------
        else if (event.getSource() == exit_button) {
            setBlue(exit_button);

        }//----------------------------------------------------------------------------------------------
        else if (event.getSource() == buffer_button) {
            setBlue(buffer_button);

        }//----------------------------------------------------------------------------------------------
        if (event.getSource() == add_employee) {
            setBlue(add_employee);

        }//-----------------------------------------------------------------------------------------------
        //  if(event.getSource()==edit_employee)
        //  {
        //  setBlue(edit_employee);
        //  }//-----------------------------------------------------------------------------------------------




    }

    public boolean isVar() {
        return var;
    }


    //***this Function Handles Button When Mouse Exit Buttons Regeon
// ___________________________________________________________________________________________________________________
    public void mouseActions2(MouseEvent event) {
        //----------------------------------------------------------------------------------------------------
        if (event.getSource() == Production_costs) {
            if (!Production)
                setTransparent(Production_costs);

        }
        //----------------------------------------------------------------------------------------------------
        if (event.getSource() == main_button) {
            if (!main)
                setTransparent(main_button);
        }
        //------------------------------------------------------------------------------------------------------
        else if (event.getSource() == orders_button) {
            if (!orders)
                setTransparent(orders_button);
        }//----------------------------------------------------------------------------------------------------
        else if (event.getSource() == employee_button) {
            if (!employee)
                setTransparent(employee_button);
        }
        //------------------------------------------------------------------------------------------------------
        else if (event.getSource() == bill_button) {
            if (!bill)
                setTransparent(bill_button);
        }
        //--------------------------------------------------------------------------------------------------

        else if (event.getSource() == factory_button) {
            if (!factory)
                setTransparent(factory_button);
        } else if (event.getSource() == exit_button) {
            if (!exit)
                setTransparent(exit_button);

        } else if (event.getSource() == buffer_button) {
            if (!buffer)
                setTransparent(buffer_button);

        }





    }

    //____________________________________________________________________________________________________________________

//MYSQL test=new MYSQL();
ObservableList<Employee> employeess = FXCollections.observableArrayList();
ObservableList<Manefactor> maefactor = FXCollections.observableArrayList();


    public    void  retrieveEmployee(){

        employeess.clear();
        // test.retrieveEmployee();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from EMPLOYEE_TWINS");

            while (rs.next()) {
                int x1= rs.getInt(1) ;
                String s1=rs.getString(2);
                int x2=rs.getInt(3);
                double x3=rs.getDouble(4);
                String s2=rs.getString(5);
                String s3=rs.getString(6);
                String s4=rs.getString(7);
                String s5=rs.getString(8);
                int x4=rs.getInt(9);
                String s6=rs.getString(10);
                Employee vv= new Employee(s3,s6,x1,s5,x2,s1,x3,s2,s4,x4 ) ;

                employeess.add(vv);



            }
          //  employeess.clear();
            employee_table.setItems(employeess);
            //employeess.clear();



//step5 close the connection object
            con.close();

        }
        catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }





    }

  /*  void retreveFactor(){

        ORDERSS.clear();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            String s=  (LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))).toString();
           String yeers =""+calendar.get(Calendar.YEAR);
           int nyer=Integer.parseInt(yeers);
           int nmonth = Integer.parseInt(""+calendar.get(Calendar.MONTH)+1);
           int nday =Integer.parseInt(""+calendar.get(Calendar.DAY_OF_MONTH));
            ResultSet d = stmt.executeQuery("select (DELIVERY_DATE) from PLACE_ORDER_ALI ");
                while ( d.next()){
                    String ss=d.getString(9);
                    String re[]=ss.split("-");
                    int y=Integer.parseInt(re[0]);
                    int m=Integer.parseInt(re[1]);
                    int dd=Integer.parseInt(re[2]);
                    if(y>=nyer){
                        if(m>=nmonth){
                            if(dd>nday){
                                ResultSet rr = stmt.executeQuery("select (DELIVERY_DATE) from PLACE_ORDER_ALI ");

                            }

                        }
                        else{
                            continue;
                        }

                    }
                    else{
                        continue;;
                    }


                }


            ResultSet rs = stmt.executeQuery("select * from PLACE_ORDER_ALI where DATE_OF_ORDER = '"++"'");
            ORDER EE;
            while (rs.next()) {
                int e1= rs.getInt(1) ;
                String e2=rs.getString(2);
                double e3=rs.getDouble(3);
                double e4=rs.getDouble(4);
                String e5=rs.getString(5);//
                int e6=rs.getInt(6);
                int e7=rs.getInt(7);
                String e8=rs.getString(8);//
                String e9=rs.getString(9);
                //System.out.println(" love ");
                double e10=rs.getDouble(10);
                EE = new ORDER(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,e8,e9 ) ;
                ORDERSS.add(EE);
                // Manefactor mm=new Manefactor(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,""+e8 );
                // maefactor.add(mm);
                //  System.out.println( s1+s2+s3);


            }
            //  employeess.clear();
            orders_table.setItems(ORDERSS);
            //orders_table1.setItems(ORDERSS);
            //manufactorTable.setItems(ORDERSS);
            //employeess.clear();



//step5 close the connection object
            con.close();

        }

        catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }



    }

*/

    void retrieveOrder(){
        ORDERSS.clear();
        addAllorderinfineshed();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from PLACE_ORDER_ALI where DATE_OF_ORDER = '"+ (LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))).toString()+"'");
            ORDER EE;
            while (rs.next()) {
                int e1= rs.getInt(1) ;
                String e2=rs.getString(2);
                double e3=rs.getDouble(3);
                double e4=rs.getDouble(4);
                String e5=rs.getString(5);//
                int e6=rs.getInt(6);
                int e7=rs.getInt(7);
                String e8=rs.getString(8);//
                String e9=rs.getString(9);
                //System.out.println(" love ");
                double e10=rs.getDouble(10);
                EE = new ORDER(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,e8,e9 ) ;
                ORDERSS.add(EE);
               // Manefactor mm=new Manefactor(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,""+e8 );
               // maefactor.add(mm);
                //  System.out.println( s1+s2+s3);


            }
            //  employeess.clear();
            orders_table.setItems(ORDERSS);
            //orders_table1.setItems(ORDERSS);
            //manufactorTable.setItems(ORDERSS);
            //employeess.clear();



//step5 close the connection object
            con.close();

        }
        catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }


    }

boolean reemployee=true;
    void addemployeedrivar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select (NAME) from EMPLOYEE_TWINS where JOP_TYPE=' سائق سيارة '");

            while (rs.next()) {

                driverNameCombo.getItems().add(rs.getString(1));

            }
            //  employeess.clear();
            //employee_table.setItems(employeess);
            //employeess.clear();


//step5 close the connection object
            con.close();

        } catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }
    }


public  void  addAllorderinfineshed(){

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");


        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
        Statement stmt = con.createStatement();
        AllOrders.clear();

        ResultSet rs = stmt.executeQuery("select * from PLACE_ORDER_ALI  ");
        ORDER EE;
        while (rs.next()) {
            int e1= rs.getInt(1) ;
            String e2=rs.getString(2);
            double e3=rs.getDouble(3);
            double e4=rs.getDouble(4);
            String e5=rs.getString(5);//
            int e6=rs.getInt(6);
            int e7=rs.getInt(7);
            String e8=rs.getString(8);//
            String e9=rs.getString(9);
            //System.out.println(" love ");
            double e10=rs.getDouble(10);
            EE = new ORDER(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,e8,e9 ) ;
           // ORDERSS.add(EE);
            AllOrders.add(EE);
            // Manefactor mm=new Manefactor(""+e10,""+e1,""+e3,""+e4,e2,e5,""+e7,""+e6,""+e8 );
            // maefactor.add(mm);
            //  System.out.println( s1+s2+s3);


        }
        orders_table2.setItems(AllOrders);
        //  employeess.clear();
       // orders_table.setItems(ORDERSS);
        //orders_table1.setItems(ORDERSS);
        //manufactorTable.setItems(ORDERSS);
        //employeess.clear();



//step5 close the connection object
        con.close();

    }
    catch (SQLException ex) {
        System.out.println("Abdallah");
    } catch (ClassNotFoundException ex) {
        System.out.println("Ameer");
    }



}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition translateTransition1 = new TranslateTransition();
        // عندما يتم تشغيله translateTransition هنا قمنا بتحديد المدة التي سيتنفذ خلالها التأثير الذي يمثل الكائن
        translateTransition1.setDuration(Duration.seconds(6));

        // text سيتم تطبيقه على الكائن translateTransition هنا حددنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
        translateTransition1.setNode(HALICOPTER);
        // هو التحرك للأسفل بنسبة 80 بيكسل translateTransition هنا قلنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
        // translateTransition.setByY(200);
        translateTransition1.setByX(-800);
        // هنا وضعنا 1- للإشارة إلى أننا لا نريد أن يتم إيقاف التأثير

        translateTransition1.setCycleCount(1);
        // كلما تم تشغيله translateTransition هنا قلنا أننا نريد أن يتم إرجاع التأثير الذي يفعله الكائن
        translateTransition1.setAutoReverse(true);

        // translateTransition هنا قمنا بتشغيل التأثير الذي يمثله الكائن
        translateTransition1.play();


        TranslateTransition translateTransition2 = new TranslateTransition();
        // عندما يتم تشغيله translateTransition هنا قمنا بتحديد المدة التي سيتنفذ خلالها التأثير الذي يمثل الكائن
        translateTransition2.setDuration(Duration.seconds(6));

        // text سيتم تطبيقه على الكائن translateTransition هنا حددنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
        translateTransition2.setNode(HALICOPTER);
        // هو التحرك للأسفل بنسبة 80 بيكسل translateTransition هنا قلنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
        // translateTransition.setByY(200);
        translateTransition2.setByX(800);
        // هنا وضعنا 1- للإشارة إلى أننا لا نريد أن يتم إيقاف التأثير

        translateTransition2.setCycleCount(1);
        // كلما تم تشغيله translateTransition هنا قلنا أننا نريد أن يتم إرجاع التأثير الذي يفعله الكائن
        translateTransition2.setAutoReverse(true);

        translateTransition1.setOnFinished((e)->{
            HALICOPTER.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            translateTransition2.play();
        });

        translateTransition2.setOnFinished((e)->{
            HALICOPTER.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            translateTransition1.play();
        });

        retrieveEmployee();
        retrieveOrder();
        retreavCar();
        //driverNameCombo
        addemployeedrivar();
        retrevBufer();
       addAllorderinfineshed();
       int i=0;
     /*  while (!AllOrders.isEmpty())
       {
           if((LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH)  )).equals(AllOrders..getName_order()))
           endallOrder.set(i,AllOrders.get(i));
           i++;
       }*/
       //orders_table2.setItems(endallOrder);

        orderdeliveryDateCol1.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        N_O2.setCellValueFactory(new PropertyValueFactory<>("name_order"));
        ID_O2.setCellValueFactory(new PropertyValueFactory<>("number_order"));
        WH_O2.setCellValueFactory(new PropertyValueFactory<>("wh"));
        Z_O2.setCellValueFactory(new PropertyValueFactory<>("z"));
        T_O2.setCellValueFactory(new PropertyValueFactory<>("th"));
        NC_O2.setCellValueFactory(new PropertyValueFactory<>("custmer_name"));
        IDC_O2.setCellValueFactory(new PropertyValueFactory<>("custmer_ID"));
        orderDateCol12.setCellValueFactory(new PropertyValueFactory<>("date"));
        PHC_O2.setCellValueFactory(new PropertyValueFactory<>("puhone_number"));
        idM.setCellValueFactory(new PropertyValueFactory<>("id"));

















        T5_O.getItems().addAll("10 ملم سادة" ,"10 ملم افور","10 ملم برونز",
                "10 ملم اخضر","10 ملم ازرق","10 ملم سادة اكسترا كلير","10 ملم اسيد","12 ملم سادة","8 ملم سادة","8 ملم افور","8ملم اكسترا كلير"
                ,"8 ملم غيوم","8 ملم مطري","8 ملم اسيد","8 ملم برش ابيض","8 ملم ماستر كريه","6 ملم سادة","6 ملم اكسترا كلير",
                "6 ملم افور","6 ملم برش ابيض","5 ملم سادة","4 ملم سادة");
        manufactorTable.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
        manufactorTable.setItems(toAddManu);
        manuAddButton.setOnAction((e)->{

            if(manuMeterPriceText.getText().isEmpty()||
                    manuQuantityText.getText().isEmpty() ){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("   تحذير ");
                alert.setHeaderText("  لا يمكن اضافة صف الا بادخال كافية بياناته ");
                // alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                return;
            }

                ManufactorSupplies manufactorSupplies = new ManufactorSupplies(manuTypeCombo.getSelectionModel().getSelectedItem().toString() , manuSizeCombo.getSelectionModel().getSelectedItem().toString() , Valedation.check_integer(manuQuantityText) , Valedation.chech_double(manuMeterPriceText), 5);
                toAddManu.add(manufactorSupplies);
                     retrevBufer();
            String s=(LocalDate.of(calendar.get(Calendar.YEAR) ,calendar.get(Calendar.MONTH)+1 ,calendar.get(Calendar.DAY_OF_MONTH))).toString();
            MYSQL.addManufactorSup(5,manuTypeCombo.getSelectionModel().getSelectedItem().toString(),
                    manuSizeCombo.getSelectionModel().getSelectedItem().toString(),
                    Valedation.chech_double( manuMeterPriceText)
                    ,s,Valedation.check_integer( manuQuantityText))  ;
            retrevBufer();


        });


       // driverNameCombo.getItems().addAll(  );

        job_type.getItems().addAll("عامل"," سائق سيارة ","  مراسل   ","  عامل تنظيف " ,"مدير مستودع ");
        martialState_e.getItems().addAll(" اعزب ", "متزوج ", " مطلق ");
        SEX_E_TEXT.getItems().addAll(" ذكر ", " انثى");

        manuTypeCombo.getItems().addAll("10 ملم سادة" ,"10 ملم افور","10 ملم برونز",
                "10 ملم اخضر","10 ملم ازرق","10 ملم سادة اكسترا كلير","10 ملم اسيد","12 ملم سادة","8 ملم سادة","8 ملم افور","8ملم اكسترا كلير"
                ,"8 ملم غيوم","8 ملم مطري","8 ملم اسيد","8 ملم برش ابيض","8 ملم ماستر كريه","6 ملم سادة","6 ملم اكسترا كلير",
                "6 ملم افور","6 ملم برش ابيض","5 ملم سادة","4 ملم سادة");
        manuSizeCombo.getItems().addAll("260/366" , "244/366" , "255/321" , "220/250" ,"214/305");

        N_O.setCellValueFactory(new PropertyValueFactory<>("name_order"));
        ID_O.setCellValueFactory(new PropertyValueFactory<>("number_order"));
        WH_O.setCellValueFactory(new PropertyValueFactory<>("wh"));
        Z_O.setCellValueFactory(new PropertyValueFactory<>("z"));
        T_O.setCellValueFactory(new PropertyValueFactory<>("th"));
        NC_O.setCellValueFactory(new PropertyValueFactory<>("custmer_name"));
        IDC_O.setCellValueFactory(new PropertyValueFactory<>("custmer_ID"));
        PHC_O.setCellValueFactory(new PropertyValueFactory<>("puhone_number"));
        orderdeliveryDateCol.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        orderDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        orderdeliveryDateCol.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        //orderDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        OrderDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        N_O1.setCellValueFactory(new PropertyValueFactory<>("name_order"));
        ID_O1.setCellValueFactory(new PropertyValueFactory<>("number_order"));
        WH_O1.setCellValueFactory(new PropertyValueFactory<>("wh"));
        Z_O1.setCellValueFactory(new PropertyValueFactory<>("z"));
        T_O1.setCellValueFactory(new PropertyValueFactory<>("th"));
        NC_O1.setCellValueFactory(new PropertyValueFactory<>("custmer_name"));
        IDC_O1.setCellValueFactory(new PropertyValueFactory<>("custmer_ID"));
        PHC_O1.setCellValueFactory(new PropertyValueFactory<>("puhone_number"));
        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        IDColumn_E.setCellValueFactory(new PropertyValueFactory<>("ID"));
        try{
            IDColumn_E.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        }
        catch ( Exception e ){
            System.out.println("Ali ");
        }
try {
    IDColumn_E.setOnEditCommit((CellEditEvent<Employee, Integer> t) -> {
        try{
            ((Employee) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setID(t.getNewValue());
        }
        catch ( Exception E ){
            System.out.println("dmnb");
        }

    });
}
catch ( Exception e ){
    System.out.println("q");
}


        nameColumn_E.setCellValueFactory(new PropertyValueFactory<>("name"));
        sexColumn_E.setCellValueFactory(new PropertyValueFactory<>("sex"));
        salaryColumn_E.setCellValueFactory(new PropertyValueFactory<>("salary"));
        salaryColumn_E.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        start_dateColumn_E.setCellValueFactory(new PropertyValueFactory<>("dateHired"));
        EmailColumn_E.setCellValueFactory(new PropertyValueFactory<>("email"));
        EmailColumn_E.setCellValueFactory(new PropertyValueFactory<>("email"));
        jop_typeColumn_E.setCellValueFactory(new PropertyValueFactory<>("jopType"));
        addressColumn_E.setCellValueFactory(new PropertyValueFactory<>("address"));
        number_chColumn_E.setCellValueFactory(new PropertyValueFactory<>("noChilds"));
        number_chColumn_E.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        martial_stateColumn_E.setCellValueFactory(new PropertyValueFactory<>("martialState"));


        manuTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        manuSizeCol.setCellValueFactory(new PropertyValueFactory<>("Size"));
        manuQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        manuMeterPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        manuMeterPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        manuQuantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //manuTypeCol.setCellFactory(TextFieldTableCell.forTableColumn());



        manuMeterPriceCol.setOnEditCommit((CellEditEvent<ManufactorSupplies, Double> t) -> {

            ((ManufactorSupplies) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setPrice(t.getNewValue());



        });

        manuQuantityCol.setOnEditCommit((CellEditEvent<ManufactorSupplies, Integer> t) -> {

            ((ManufactorSupplies) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setQuantity(t.getNewValue());



        });








        Image mainicon = new Image(getClass().getResourceAsStream("/images/home-page-icon.png"));
        ImageView cameraIconView = new ImageView(mainicon);
        cameraIconView.setFitHeight(35);
        cameraIconView.setFitWidth(30);


        main_button.setGraphic(cameraIconView);
        main_button.setContentDisplay(ContentDisplay.RIGHT);

        Image cameraIcon = new Image(getClass().getResourceAsStream("/images/exit.png"));
        ImageView exitview = new ImageView(cameraIcon);
        exitview.setFitHeight(40);
        exitview.setFitWidth(30);

        exit_button.setGraphic(exitview);
        exit_button.setContentDisplay(ContentDisplay.RIGHT);

        Image ordericon = new Image(getClass().getResourceAsStream("/images/order.png"));
        ImageView orderview = new ImageView(ordericon);
        orderview.setFitHeight(40);
        orderview.setFitWidth(40);

        orders_button.setGraphic(orderview);
        orders_button.setContentDisplay(ContentDisplay.RIGHT);

        Image employeeicon = new Image(getClass().getResourceAsStream("/images/employee.png"));
        ImageView employeeview = new ImageView(employeeicon);
        employeeview.setFitHeight(40);
        employeeview.setFitWidth(40);

        employee_button.setGraphic(employeeview);
        employee_button.setContentDisplay(ContentDisplay.RIGHT);

        Image wareicon = new Image(getClass().getResourceAsStream("/images/warehouse.png"));
        ImageView wareview = new ImageView(wareicon);
        wareview.setFitHeight(40);
        wareview.setFitWidth(40);

        buffer_button.setGraphic(wareview);
        buffer_button.setContentDisplay(ContentDisplay.RIGHT);


        Image factoryicon = new Image(getClass().getResourceAsStream("/images/factory.png"));
        ImageView factoryview = new ImageView(factoryicon);
        factoryview.setFitHeight(40);
        factoryview.setFitWidth(40);

        factory_button.setGraphic(factoryview);
        factory_button.setContentDisplay(ContentDisplay.RIGHT);


        Image billicon = new Image(getClass().getResourceAsStream("/images/bill.png"));
        ImageView billview = new ImageView(billicon);
        billview.setFitHeight(40);
        billview.setFitWidth(40);

        bill_button.setGraphic(billview);
        bill_button.setContentDisplay(ContentDisplay.RIGHT);

      /*  Image addicon = new Image(getClass().getResourceAsStream("/images/add.png"));
        ImageView addview = new ImageView(addicon);
        addview.setFitHeight(50);
        addview.setFitWidth(50);

        addOrder.setGraphic(addview);
        addOrder.setContentDisplay(ContentDisplay.RIGHT);*/


        Image costsicon = new Image(getClass().getResourceAsStream("/images/production.png"));
        ImageView costsview = new ImageView(costsicon);
        costsview.setFitHeight(40);
        costsview.setFitWidth(40);

        Production_costs.setGraphic(costsview);
        Production_costs.setContentDisplay(ContentDisplay.RIGHT);


        Image addBillIcon = new Image(getClass().getResourceAsStream("/images/add.png"));
        ImageView addBillView = new ImageView(addBillIcon);
        addBillView.setFitHeight(40);
        addBillView.setFitWidth(40);

        add_bill.setGraphic(addBillView);
        add_bill.setContentDisplay(ContentDisplay.RIGHT);




        setIcon("print.png", print_bill);
        setIcon("show.png", show_bill);


        buttonsState(main_button);
        buttonsState(employee_button);
        buttonsState(orders_button);
        buttonsState(exit_button);
        buttonsState(buffer_button);
        buttonsState(factory_button);
        buttonsState(bill_button);
        //buttonsState(add_employee);
        //  buttonsState(edit_employee);
        buttonsState(Production_costs);

        imagesToolTip(account_icon, "الحساب");
        imagesToolTip(message_icon, "رسائل الايميل");
        imagesToolTip(notification_icon, "اشعارات المصنع");
        imagesToolTip(back_icon, "الى الخلف");

        //***setting the header to main_button icon and text as Default**
        header_icon.setImage(new Image(getClass().getResourceAsStream("/images/home-page-icon.png")));
        header_label.setText(main_button.getText());






        TranslateTransition translateTransition = new TranslateTransition();
        // عندما يتم تشغيله translateTransition هنا قمنا بتحديد المدة التي سيتنفذ خلالها التأثير الذي يمثل الكائن
        translateTransition.setDuration(Duration.seconds(3));

        // text سيتم تطبيقه على الكائن translateTransition هنا حددنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
        translateTransition.setNode(carIcon);
        // هو التحرك للأسفل بنسبة 80 بيكسل translateTransition هنا قلنا أن التأثير الذي سنحصل عليه عند تشغيل الكائن
      // translateTransition.setByY(200);
        translateTransition.setByX(-940);
        // هنا وضعنا 1- للإشارة إلى أننا لا نريد أن يتم إيقاف التأثير

        translateTransition.setCycleCount(-1);
        // كلما تم تشغيله translateTransition هنا قلنا أننا نريد أن يتم إرجاع التأثير الذي يفعله الكائن
        translateTransition.setAutoReverse(true);

        // translateTransition هنا قمنا بتشغيل التأثير الذي يمثله الكائن
        translateTransition.play();



/*
        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.seconds(3));

        translateTransition2.setFromX(990);
        translateTransition2.setFromY(14);
        translateTransition2.setToX(644);
        translateTransition2.setToY(280);
        translateTransition2.setAutoReverse(true);
        translateTransition2.setCycleCount(Animation.INDEFINITE);

        translateTransition2.setNode(animationButton);
        translateTransition2.play();
*/


        carNoCol.setCellValueFactory(new PropertyValueFactory<>("carNo"));
        driverNameCol.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        carPriceCol.setCellValueFactory(new PropertyValueFactory<>("carPrice"));
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        carTypeCol.setCellValueFactory(new PropertyValueFactory<>("carType"));
    //    carPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));


           driverNameCol.setOnEditCommit((CellEditEvent<Car, String> t) -> {

            ((Car) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setDriverName(t.getNewValue());



        });
 carNoCol.setOnEditCommit((CellEditEvent<Car, String> t) -> {

            ((Car) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setCarNo(t.getNewValue());



        });
       /*carPriceCol.setOnEditCommit((CellEditEvent<Car, Integer> t) -> {

            ((Car) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setCarPrice(t.getNewValue());



        });*/

        purchaseDateCol.setOnEditCommit((CellEditEvent<Car, String> t) -> {

            ((Car) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setPurchaseDate(t.getNewValue());



        });











    }



    //****This function make the button Transparent & Empty Border
    public void buttonsState(Button button) {
       button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT , CornerRadii.EMPTY , Insets.EMPTY)));
        // button.setTextFill(Color.BLACK);
    }

    //***This function sets the ToolTip to ImageViews**
    public void imagesToolTip(ImageView image, String text) {
        Tooltip.install(image, new Tooltip(text));
    }

    public void setIcon(String imageName, Button button) {
        Image addicon = new Image(getClass().getResourceAsStream("/images/" + imageName));
        ImageView addview = new ImageView(addicon);
        addview.setFitHeight(40);
        addview.setFitWidth(40);

        button.setGraphic(addview);
    }


    // @FXML
    //ImageView facebook;

    //@FXML
    //ImageView chrome;
    public void mouseClicked(MouseEvent event) {

        if (event.getSource() == message_icon) {
            //Acount.setVisible(false);
            orders_pane.setVisible(false);
            employee_pane.setVisible(false);
            buffer_Pane.setVisible(false);
            Costs_Pane.setVisible(false);
            factory_pane.setVisible(false);
            bill_pane.setVisible(false);
            web_pane.setVisible(true);

            Hyperlink link = new Hyperlink();
            WebEngine engine = web_page.getEngine();
            engine.load("https://account.microsoft.com/account?lang=en-us");


        }
        if (event.getSource() == main_button) {
            setBlue(main_button);
            setTransparent(orders_button);
            setTransparent(employee_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = true;
            orders = false;
            employee = false;
            buffer = false;
            factory = false;
            bill = false;
            Production = false;
            exit = false;

        }

        if (event.getSource() == orders_button) {
            setBlue(orders_button);
            setTransparent(main_button);
            setTransparent(employee_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = false;
            orders = true;
            employee = false;
            buffer = false;
            factory = false;
            bill = false;
            Production = false;
            exit = false;


        } else if (event.getSource() == employee_button) {
            setBlue(employee_button);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = false;
            orders = false;
            employee = true;
            buffer = false;
            factory = false;
            bill = false;
            Production = false;
            exit = false;


        } else if (event.getSource() == buffer_button) {
            setBlue(buffer_button);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(employee_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = false;
            orders = false;
            employee = false;
            buffer = true;
            factory = false;
            bill = false;
            Production = false;
            exit = false;
        } else if (event.getSource() == factory_button) {
            setBlue(factory_button);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(buffer_button);
            setTransparent(employee_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = false;
            orders = false;
            employee = false;
            buffer = false;
            factory = true;
            bill = false;
            Production = false;
            exit = false;
        } else if (event.getSource() == bill_button) {
            setBlue(bill_button);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(employee_button);
            setTransparent(Production_costs);
            setTransparent(exit_button);
            main = false;
            orders = false;
            employee = false;
            buffer = false;
            factory = false;
            bill = true;
            Production = false;
            exit = false;
        } else if (event.getSource() == Production_costs) {
            setBlue(Production_costs);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(employee_button);
            setTransparent(exit_button);
            main = false;
            orders = false;
            employee = false;
            buffer = false;
            factory = false;
            bill = false;
            Production = true;
            exit = false;
        } else if (event.getSource() == exit_button) {
            setBlue(exit_button);
            setTransparent(main_button);
            setTransparent(orders_button);
            setTransparent(buffer_button);
            setTransparent(factory_button);
            setTransparent(bill_button);
            setTransparent(Production_costs);
            setTransparent(employee_button);
            main = false;
            orders = false;
            employee = false;
            buffer = false;
            factory = false;
            bill = false;
            Production = false;
            exit = true;
        }

    }

    public void setBlue(Button button) {
        button.setBackground(new Background(new BackgroundFill(Color.rgb(51, 20, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        // button.setStyle("-fx-background-color: #ff4102");

    }

    public void setTransparent(Button button) {
        button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    Button a[] = {main_button, orders_button, employee_button, buffer_button, factory_button, bill_button, Production_costs, exit_button};



}