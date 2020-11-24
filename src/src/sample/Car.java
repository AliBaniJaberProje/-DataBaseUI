package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Car {
      SimpleStringProperty carNo;
      SimpleStringProperty driverName;
     SimpleDoubleProperty carPrice;
     SimpleStringProperty purchaseDate;
     SimpleStringProperty carType;


    public Car(String carNo, String driverName,
               double carPrice, String purchaseDate,
               String carType) {
        this.carNo = new SimpleStringProperty(carNo);
        this.driverName = new SimpleStringProperty(driverName);
        this.carPrice = new SimpleDoubleProperty(carPrice);
        this.purchaseDate = new SimpleStringProperty(purchaseDate);
        this.carType = new SimpleStringProperty(carType);

    }
/*
    public Car(SimpleStringProperty carNo, SimpleStringProperty driverName,
               SimpleStringProperty carPrice,
               SimpleStringProperty purchaseDate,
               SimpleStringProperty carType) {
        this.carNo = carNo;
        this.driverName = driverName;
        this.carPrice = carPrice;
        this.purchaseDate = purchaseDate;
        this.carType = carType;
    }
    */

    public String getCarNo() {
        return carNo.get();
    }

    public SimpleStringProperty carNoProperty() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo.set(carNo);
    }

    public String getDriverName() {
        return driverName.get();
    }

    public SimpleStringProperty driverNameProperty() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName.set(driverName);
    }

    public double getCarPrice() {
        return carPrice.get();
    }

    public SimpleDoubleProperty carPriceProperty() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice.set(carPrice);
    }

    public String getPurchaseDate() {
        return purchaseDate.get();
    }

    public SimpleStringProperty purchaseDateProperty() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate.set(purchaseDate);
    }

    public String getCarType() {
        return carType.get();
    }

    public SimpleStringProperty carTypeProperty() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType.set(carType);
    }
}
