package ru.billing.stocklist;

public class TechicalItem extends GenericItem implements Cloneable {
    private short warrantyTime;
    @Override
    public void printAll(){
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category:  %-20s, warrantyTime:%d \n", getID(), getName(), getPrice(), getCategory(), warrantyTime);
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
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
        TechicalItem product = (TechicalItem) o;
        return getID() == product.getID() &&
                getName() == product.getName() &&
                getPrice() == product.getPrice() &&
                getAnalog() == product.getAnalog() &&
                getCategory() == product.getCategory() &&
                warrantyTime == product.warrantyTime;
    }

    @Override
    public int hashCode() {

        Object[] product = {getID(), getName(), getPrice(), getAnalog(), getCategory(), warrantyTime};

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
                ", Гарантийный срок " + warrantyTime;
    }
}
