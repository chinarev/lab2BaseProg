package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem implements Cloneable {
    private Date dateOfIncome; // дата производства
    private short expires; // срок годности

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    @Override
    public void printAll(){
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category:  %-20s, Date of income: %tD, expires:%d \n", getID(), getName(), getPrice(), getCategory(), dateOfIncome, expires);
    }

    public FoodItem(String name, float price, FoodItem analog, Date
            date, short expires) {
        this.setName(name);
        this.setPrice(price);
        this.setAnalog(analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires){
        this(name, price, null, null, expires);
    }

    public FoodItem(String name){
        this(name,  0, null, null, (short) 0);

    }

    @Override
    public boolean equals(Object o) {
        // 1
        if (this == o) {
            return true;
        }

        // 2
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 3
        FoodItem product = (FoodItem) o;
        return getID() == product.getID() &&
                getName() == product.getName() &&
                getPrice() == product.getPrice() &&
                getAnalog() == product.getAnalog() &&
                getCategory() == product.getCategory() &&
                dateOfIncome == product.dateOfIncome &&
                expires == product.expires;
    }

    @Override
    public int hashCode() {

        Object[] product = {getID(), getName(), getPrice(), getAnalog(), getCategory(), dateOfIncome, expires};

        int result = 1;

        for (Object element : product)
            if (element == null) {
                result = 0;
            }
            else result = 31 * result + element.hashCode();

        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if (this.getAnalog() == null) return super.clone();
        return getAnalog().clone();
    }

    @Override
    public String toString() {
        return "ID " + getID() +
                ", Название " + getName() +
                ", Цена " + getPrice() +
                ", Аналог " + getAnalog() +
                ", Категория " + getCategory() +
                ", Дата производства " + dateOfIncome +
                ", Срок годности " + expires;
    }
}
