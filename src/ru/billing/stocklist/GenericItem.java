package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private int ID; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private GenericItem analog;
    private Category category = Category.GENERAL;
    private static int currentID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category:  %-20s \n", ID, name, price, category);
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
        GenericItem product = (GenericItem) o;
        return ID == product.ID &&
                name == product.name &&
                price == product.price &&
                analog == product.analog &&
                category == product.category;
    }

    @Override
    public int hashCode() {

        Object[] product = {ID, name, price, analog, category};

        int result = 1;

        for (Object element : product)
            if (element == null) {
                result = 0;
            } else result = 31 * result + element.hashCode();

        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if (this.analog == null) return super.clone();
        return analog.clone();
    }

    @Override
    public String toString() {
        return "ID " + ID +
                ", Название " + name +
                ", Цена " + price +
                ", Аналог " + analog +
                ", Категория " + category;
    }
}

