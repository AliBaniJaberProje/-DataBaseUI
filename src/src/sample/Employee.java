package sample;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;


public class Employee {
    private SimpleStringProperty name;
    private SimpleStringProperty sex;
    private SimpleIntegerProperty ID;
    private SimpleStringProperty jopType;
    private SimpleIntegerProperty email;
    private SimpleStringProperty dateHired;
    private SimpleDoubleProperty salary;
    private SimpleStringProperty address;
    private SimpleStringProperty martialState;
    private SimpleIntegerProperty noChilds;

    public Employee(String name , String sex , int ID ,String jopType ,
                    int email , String dateHired , double salary , String address
            , String martialState , int noChilds )
    {
        this.name = new SimpleStringProperty(name);//
        this.sex = new SimpleStringProperty(sex);//
        this.ID = new SimpleIntegerProperty(ID);//
        this.jopType = new SimpleStringProperty(jopType);//
        this.email = new SimpleIntegerProperty(email);//
        this.dateHired = new SimpleStringProperty(dateHired);//
        this.salary = new SimpleDoubleProperty(salary);//
        this.address = new SimpleStringProperty(address);//
        this.martialState = new SimpleStringProperty(martialState);//
        this.noChilds = new SimpleIntegerProperty(noChilds);
    }

    public Employee(SimpleStringProperty name, SimpleStringProperty sex,
                    SimpleIntegerProperty ID, SimpleStringProperty jopType,
                    SimpleIntegerProperty email, SimpleStringProperty dateHired,
                    SimpleDoubleProperty salary, SimpleStringProperty address,
                    SimpleStringProperty martialState, SimpleIntegerProperty noChilds) {
        this.name = name;
        this.sex = sex;
        this.ID = ID;
        this.jopType = jopType;
        this.email = email;
        this.dateHired = dateHired;
        this.salary = salary;
        this.address = address;
        this.martialState = martialState;
        this.noChilds = noChilds;
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

    public String getJopType() {
        return jopType.get();
    }

    public SimpleStringProperty jopTypeProperty() {
        return jopType;
    }

    public void setJopType(String jopType) {
        this.jopType.set(jopType);
    }

    public int getEmail() {
        return email.get();
    }

    public SimpleIntegerProperty emailProperty() {
        return email;
    }

    public void setEmail(int email) {
        this.email.set(email);
    }

    public String getDateHired() {
        return dateHired.get();
    }

    public SimpleStringProperty dateHiredProperty() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired.set(dateHired);
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

    public String getMartialState() {
        return martialState.get();
    }

    public SimpleStringProperty martialStateProperty() {
        return martialState;
    }

    public void setMartialState(String martialState) {
        this.martialState.set(martialState);
    }

    public int getNoChilds() {
        return noChilds.get();
    }

    public SimpleIntegerProperty noChildsProperty() {
        return noChilds;
    }

    public void setNoChilds(int noChilds) {
        this.noChilds.set(noChilds);
    }
}




