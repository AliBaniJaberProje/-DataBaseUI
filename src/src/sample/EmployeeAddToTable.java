package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class EmployeeAddToTable {
    SimpleStringProperty name;
    SimpleStringProperty sex;
    SimpleIntegerProperty ID;
    SimpleStringProperty jobe_tepy;
    SimpleStringProperty Email;
    SimpleStringProperty start_date;
    SimpleDoubleProperty salary;
    SimpleStringProperty address;
    SimpleStringProperty Al_hale_alegtmaie;
    SimpleIntegerProperty number_of_chiled;

    public EmployeeAddToTable(SimpleStringProperty name, SimpleStringProperty sex,
                              SimpleIntegerProperty ID, SimpleStringProperty jobe_tepy,
                              SimpleStringProperty email, SimpleStringProperty start_date,
                              SimpleDoubleProperty salary,
                              SimpleStringProperty address, SimpleStringProperty al_hale_alegtmaie,
                              SimpleIntegerProperty number_of_chiled) {
        this.name = name;
        this.sex = sex;
        this.ID = ID;
        this.jobe_tepy = jobe_tepy;
        Email = email;
        this.start_date = start_date;
        this.salary = salary;
        this.address = address;
        Al_hale_alegtmaie = al_hale_alegtmaie;
        this.number_of_chiled = number_of_chiled;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getJobe_tepy() {
        return jobe_tepy.get();
    }

    public SimpleStringProperty jobe_tepyProperty() {
        return jobe_tepy;
    }

    public void setJobe_tepy(String jobe_tepy) {
        this.jobe_tepy.set(jobe_tepy);
    }

    public String getEmail() {
        return Email.get();
    }

    public SimpleStringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getStart_date() {
        return start_date.get();
    }

    public SimpleStringProperty start_dateProperty() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date.set(start_date);
    }

    public double getSalary() {
        return salary.get();
    }

    public SimpleDoubleProperty salaryProperty() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getAl_hale_alegtmaie() {
        return Al_hale_alegtmaie.get();
    }

    public SimpleStringProperty al_hale_alegtmaieProperty() {
        return Al_hale_alegtmaie;
    }

    public void setAl_hale_alegtmaie(String al_hale_alegtmaie) {
        this.Al_hale_alegtmaie.set(al_hale_alegtmaie);
    }

    public int getNumber_of_chiled() {
        return number_of_chiled.get();
    }

    public SimpleIntegerProperty number_of_chiledProperty() {
        return number_of_chiled;
    }

    public void setNumber_of_chiled(int number_of_chiled) {
        this.number_of_chiled.set(number_of_chiled);
    }
}
