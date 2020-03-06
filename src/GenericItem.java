public class GenericItem implements Cloneable {
    public int ID; // ID товара
    public String name; // Наименование товара
    public float price; //Цена товара
    public GenericItem analog;
    public Category category = Category.GENERAL;

    void printAll() {
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
            }
            else result = 31 * result + element.hashCode();

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
                ", Цена " + price  +
                ", Аналог " + analog +
                ", Категория " + category;
    }
}

