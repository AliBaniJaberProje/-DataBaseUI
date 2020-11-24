package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class   Valedation
{
    boolean integer_test;
    boolean double_test;
    boolean stringtest;





   /* public  static void employee( TextField t1 , TextField t2,TextField t3,TextField t4, TextField t5 ,
    TextField t6 )
    {
        if(t1.getText().isEmpty() || t2.getText().isEmpty()||
        t3.getText().isEmpty() ||t4.getText().isEmpty() ||
        t5.getText().isEmpty()  || t6.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال خاطئة");
            alert.setHeaderText("تاكد من ادخال كامل البيانات");
            // alert.setContentText("Ooops, there was an error!");


        }


    }

*/
    public  static  double chech_double( TextField text ){

        double result=0.0;
        try{
            result = Double.parseDouble(text.getText());
        }
        catch ( Exception ex ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("عملية ادخال خاطئة");
            alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
            // alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

        return  result;
    }






    public  static int check_integer (TextField text)
    {
        int result=0;
        try{
            result = Integer.parseInt(text.getText());
        }
        catch ( Exception ex ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("عملية ادخال خاطئة");
            alert.setHeaderText("اعد ادخال البيانات بشكل صحيح ");
           // alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

        return  result;
    }



}
