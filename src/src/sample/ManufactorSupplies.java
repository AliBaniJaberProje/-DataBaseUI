package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ManufactorSupplies {
    SimpleIntegerProperty id;
    SimpleStringProperty type;
    SimpleStringProperty Size;
    SimpleIntegerProperty quantity;
    SimpleDoubleProperty price;

    public ManufactorSupplies(String type, String size, int quantity, double price, int id) {
        this.type = new SimpleStringProperty(type);
        Size = new SimpleStringProperty(size);
        this.quantity =new SimpleIntegerProperty( quantity);
        this.price = new SimpleDoubleProperty(price);
        this.id =new SimpleIntegerProperty( id);

    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getSize() {
        return Size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return Size;
    }

    public void setSize(String size) {
        this.Size.set(size);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}
