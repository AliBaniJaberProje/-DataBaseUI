package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class MYSQL {



    public static void  addAllorderinfineshed(){





    }





    public static void addManufactorSup( int e1,String e2 ,String e3 , double e4 ,String e5, int e6){


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();

            int my_d=0;
            ResultSet rs = stmt.executeQuery("select (TYPE_NO )from  MANUFACTOR_SUPPLIES");

            while (rs.next()){
                my_d=rs.getInt(1);
            }


            PreparedStatement st = con.prepareStatement("insert into MANUFACTOR_SUPPLIES values (?,?,?,?,?,?)");
            my_d=my_d+1;
            st.setInt(1,my_d );
            st.setString(2, e2);
            st.setString(3, e3);
            st.setDouble(4, e4);
            st.setString(5, e5);
            st.setInt(6,e6);

            int a = st.executeUpdate();
            if (a > 0)
                System.out.println(" don ");

        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  لا يمكن اضافة طلبين لهما نفس الرقم  ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }



    }




    public static int upDateEmployee(int e1, double e2,
                                     String e3, String e4,
                                     String e5, String e6,
                                     int e7, String e8, int ID_M) {

        int result = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   PHONE_NUMBER = '" + e1 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet ee = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   SALARY = '" + e2 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet eWe = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   ADDRESS = '" + e3 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet WW = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   name = '" + e4 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet WwW = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   MARTIAL_STATE = '" + e5 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet WwwW = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   JOP_TYPE = '" + e6 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet WwwWw = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   NUMBER_OF_CHILDREN = '" + e7 + "'" + " WHERE  ID =" + ID_M + "");
            ResultSet eWwwWw = stmt.executeQuery("UPDATE  EMPLOYEE_TWINS set   SEX = '" + e8 + "'" + " WHERE  ID =" + ID_M + "");

            result = 2;


            con.close();

        } catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }

        return result;

    }


    ObservableList<Employee> employeess = FXCollections.observableArrayList();

    static void add_PLACE_ORDER_ALI(int e1, String e2,
                                    double e3, double e4, String e5,
                                    int e6, int e7, String e8, String e9, double e11) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();


            //  PreparedStatement IDINC = con.prepareStatement("INSERT  INTO PLACE_ORDER_ALI(ORDER_NUMBER)  values  (IDORDER.nextval )");

            int my_d=0;
            ResultSet rs = stmt.executeQuery("select (ORDER_NUMBER )from  PLACE_ORDER_ALI");

            while (rs.next()){
                my_d=rs.getInt(1);
            }


            PreparedStatement st = con.prepareStatement("insert into PLACE_ORDER_ALI values (?,?,?,?,?,?,?,?,?,?)");
            my_d=my_d+1;
            st.setInt(1,my_d );
            st.setString(2, e2);
            st.setDouble(3, e3);
            st.setDouble(4, e4);
            st.setString(5, e5);
            st.setInt(6, e6);
            st.setInt(7, e7);
            st.setString(8, e8);
            st.setString(9, e9);
            st.setDouble(10, e11);
            int a = st.executeUpdate();
            if (a > 0)
                System.out.println(" don ");

        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  لا يمكن اضافة طلبين لهما نفس الرقم  ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public static void addCar(int id, double pr, String yy, String emp, String rr) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();

            PreparedStatement st = con.prepareStatement("insert into CAR(VEHICLE_ID, PRICE, PURCHASE_DATE, NAME_DRAEVAR, TYPE) values (?,?,?,?,?)");
            st.setInt(1, id);
            st.setDouble(2, pr);
            st.setString(3, yy);
            st.setString(4, emp);
            st.setString(5, rr);


            int a = st.executeUpdate();
            if (a > 0)
                System.out.println(" don ");
        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  رقم السيارة   موجود بالفعل ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println("exeption ");
            System.out.println(e);
        }

    }

    public static int deletEmployee(int delet_e) {
        int result = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "Database", "123456");
            Statement stmt = con.createStatement();

            PreparedStatement st = con.prepareStatement("DELETE  from  EMPLOYEE_TWINS where  ID= " + delet_e);


            int a = st.executeUpdate();
            if (a > 0) {
                System.out.println(" don ");
                result = 2;
            }
        } catch (SQLIntegrityConstraintViolationException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  رقم الID  موجود بالفعل ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println("exeption ");
            System.out.println(e);
        }
        return result;


    }

    public static int getIDoRDER() {


















        return 0;
    }



    public    void  retrieveEmployee(){
         SecondController ob = new SecondController();
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
                employeess.add(new Employee(s3,s6,x1,s5,x2,s1,x3,s2,s1,x4 )) ;

            }
            ob.employee_table.setItems(employeess);
            employeess.clear();

            con.close();

        }
        catch (SQLException ex) {
            System.out.println("Abdallah");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ameer");
        }



/*
        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Database","123456");

//step3 create the statement object

            Statement stmt=con.createStatement();

            PreparedStatement st = con.prepareStatement("select * from EMPLOYEE_TWINS");

           /* st.setString(2,strart);
            st.setInt(3,ph);
            st.setDouble(4,sal);
            st.setString(5,adres);
            st.setString(6,name);
            st.setString(7,mar);
            st.setString(8,job);
            st.setInt(9,ch);
            st.setString(10,sex);
*/

/*

            int a = st.executeUpdate();
            if(a>0 )
                System.out.println(" don ");
//step4 execute query
            // ResultSet rs=stmt.executeQuery("insert into EMPLOYEE_TWINS(ID, START_DATE, PHONE_NUMBER, SALARY, ADDRESS, NAME, MARTIAL_STATE, JOP_TYPE, NUMBER_OF_CHILDREN, SEX) VALUES (?)");
            //    while (rs.next()){
            //      rs
            //  }

//step5 close the connection object
            //  con.close();

        }
        catch(Exception e){ System.out.println(e);}

*/

    }

    public static void  addCustmer( String name, int ph,int id_Custmer )
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Database","123456");

            Statement stmt=con.createStatement();

            PreparedStatement st = con.prepareStatement("insert into CUSTOMER_TWINS values (?,?,?)");
            st.setString(1,name);
            st.setInt(2,ph);
            st.setInt(3,id_Custmer);

            int a = st.executeUpdate();
            if(a>0 )
                System.out.println(" don ");
        }
        catch ( SQLIntegrityConstraintViolationException x ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("   ");
            alert.showAndWait();

        }
        catch(Exception e){ System.out.println(e);}

    }


    public static void  addOrder(int id_order , String typem, double wid
      , double he, double pr, int idc )
    {


        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Database","123456");

//step3 create the statement object

            Statement stmt=con.createStatement();

            PreparedStatement st = con.prepareStatement("insert into ORDER_TWINS values (?,?,?,?,?,?)");
            st.setInt(1,id_order);
            st.setString(2,typem);
            st.setDouble(3,wid);
            st.setDouble(4,he);
            st.setDouble(5,pr);
            st.setInt(6,idc);




            int a = st.executeUpdate();
            if(a>0 )
                System.out.println(" don ");
//step4 execute query
            // ResultSet rs=stmt.executeQuery("insert into EMPLOYEE_TWINS(ID, START_DATE, PHONE_NUMBER, SALARY, ADDRESS, NAME, MARTIAL_STATE, JOP_TYPE, NUMBER_OF_CHILDREN, SEX) VALUES (?)");
            //    while (rs.next()){
            //      rs
            //  }

//step5 close the connection object
            //  con.close();

        }
        catch ( SQLIntegrityConstraintViolationException x ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("  لا يمكن اضافة طلبين لهما نفس الرقم  ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        }
        catch(Exception e){ System.out.println(e);}






    }


  public static void  addEmployee( int id , String strart ,int ph, double sal,
                                   String adres ,
                              String name , String mar, String job
          ,int ch , String  sex       )
    {


        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Database","123456");
            Statement stmt=con.createStatement();

            PreparedStatement st = con.prepareStatement("insert into EMPLOYEE_TWINS(ID, START_DATE, PHONE_NUMBER, SALARY, ADDRESS, NAME, MARTIAL_STATE, JOP_TYPE, NUMBER_OF_CHILDREN, SEX) values (?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1,id);
            st.setString(2,strart);
            st.setInt(3,ph);
            st.setDouble(4,sal);
            st.setString(5,adres);
            st.setString(6,name);
            st.setString(7,mar);
            st.setString(8,job);
            st.setInt(9,ch);
            st.setString(10,sex);




            int a = st.executeUpdate();
            if(a>0 ) {
                System.out.println(" don ");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle(" تم اضافة الموظف بنجاح ");
                alert.setHeaderText( job +
                        " ك موظف "+name +" تم تعين"  );
                //            // alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();

            }
        }
        catch ( SQLIntegrityConstraintViolationException x ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText(" يرجى مراجعة البيانات ( عملية اضافة خاطئة ) ");
            // alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;

        }
        catch(Exception e){ //System.out.println(e);

        return;
        }






    }




 public static void exe( String toexe ){


     try{
//step1 load the driver class
         Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
         Connection con= DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:orcl","Database","123456");

//step3 create the statement object
         Statement stmt=con.createStatement();

//step4 execute query
         ResultSet rs=stmt.executeQuery( toexe);


//step5 close the connection object
         con.close();

     }catch(Exception e){ System.out.println(e);}


 }


}
