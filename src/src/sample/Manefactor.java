package sample;

import javafx.beans.property.SimpleStringProperty;

public class Manefactor {
    SimpleStringProperty name_order;
    SimpleStringProperty   number_order;
    SimpleStringProperty z;
    SimpleStringProperty wh;
    SimpleStringProperty th;
    SimpleStringProperty  custmer_name;
    SimpleStringProperty  custmer_ID;
    SimpleStringProperty  puhone_number;
    SimpleStringProperty orderDate;

    public Manefactor(String name_order,
                      String number_order
            , String z
            , String wh
            , String th
            , String custmer_name
            , String custmer_ID
            , String puhone_number , String orderDate ) {
        {
            this.name_order = new SimpleStringProperty(name_order);
            this.number_order = new SimpleStringProperty(number_order);
            this.z =  new SimpleStringProperty(z);
            this.wh =new SimpleStringProperty( wh);
            this.th = new SimpleStringProperty( th);
            this.custmer_name =  new SimpleStringProperty(custmer_name);
            this.custmer_ID = new SimpleStringProperty( custmer_ID);
            this.puhone_number =new SimpleStringProperty(puhone_number);
            this.orderDate =new SimpleStringProperty(orderDate);

        }
    }

    public String getName_order() {
        return name_order.get();
    }

    public SimpleStringProperty name_orderProperty() {
        return name_order;
    }

    public void setName_order(String name_order) {
        this.name_order.set(name_order);
    }

    public String getNumber_order() {
        return number_order.get();
    }

    public SimpleStringProperty number_orderProperty() {
        return number_order;
    }

    public void setNumber_order(String number_order) {
        this.number_order.set(number_order);
    }

    public String getZ() {
        return z.get();
    }

    public SimpleStringProperty zProperty() {
        return z;
    }

    public void setZ(String z) {
        this.z.set(z);
    }

    public String getWh() {
        return wh.get();
    }

    public SimpleStringProperty whProperty() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh.set(wh);
    }

    public String getTh() {
        return th.get();
    }

    public SimpleStringProperty thProperty() {
        return th;
    }

    public void setTh(String th) {
        this.th.set(th);
    }

    public String getCustmer_name() {
        return custmer_name.get();
    }

    public SimpleStringProperty custmer_nameProperty() {
        return custmer_name;
    }

    public void setCustmer_name(String custmer_name) {
        this.custmer_name.set(custmer_name);
    }

    public String getCustmer_ID() {
        return custmer_ID.get();
    }

    public SimpleStringProperty custmer_IDProperty() {
        return custmer_ID;
    }

    public void setCustmer_ID(String custmer_ID) {
        this.custmer_ID.set(custmer_ID);
    }

    public String getPuhone_number() {
        return puhone_number.get();
    }

    public SimpleStringProperty puhone_numberProperty() {
        return puhone_number;
    }

    public void setPuhone_number(String puhone_number) {
        this.puhone_number.set(puhone_number);
    }

    public String getOrderDate() {
        return orderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }
}
