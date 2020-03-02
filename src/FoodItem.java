import java.util.Date;

public class FoodItem extends GenericItem implements Cloneable {
    Date dateOfIncome; // дата производства
    short expires; // срок годности
    @Override
    void printAll(){
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f, category:  %-20s, Date of income: %tD, expires:%d \n", ID, name, price, category, dateOfIncome, expires);
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
        return ID == product.ID &&
                name == product.name &&
                price == product.price &&
                analog == product.analog &&
                category == product.category &&
                dateOfIncome == product.dateOfIncome &&
                expires == product.expires;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ID " + ID +
                ", Название " + name +
                ", Цена " + price  +
                ", Аналог " + analog +
                ", Категория " + category +
                ", Дата производства " + dateOfIncome +
                ", Срок годности " + expires;
    }
}
