public class TechicalItem extends GenericItem implements Cloneable {
    short warrantyTime;
    @Override
    void printAll(){
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category:  %-20s, warrantyTime:%d \n", ID, name, price, category, warrantyTime);
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
        return ID == product.ID &&
                name == product.name &&
                price == product.price &&
                analog == product.analog &&
                category == product.category &&
                warrantyTime == product.warrantyTime;
    }

    @Override
    public int hashCode() {

        Object[] product = {ID, name, price, analog, category, warrantyTime};

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
                ", Категория " + category +
                ", Гарантийный срок " + warrantyTime;
    }
}
