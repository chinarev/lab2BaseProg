import java.sql.SQLOutput;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GenericItem product1 = new GenericItem();
        product1.ID = 1;
        product1.name = "Cola";
        product1.price = 60;
        product1.printAll();


        GenericItem product2 = new GenericItem();
        product2.ID = 2;
        product2.name = "Fanta";
        product2.price = 65;
        product2.analog = product1;
        product2.printAll();


        GenericItem product3 = new GenericItem();
        product3.ID = 3;
        product3.name = "Mars";
        product3.price = 45;
        product3.printAll();


        FoodItem foodItem1 = new FoodItem("juice", 90, null, new Date(2020, 2, 5), (short) 30);


        FoodItem foodItem2 = new FoodItem("cola", 30, null, new Date(2020, 3, 11), (short) 40);


        TechicalItem techicalItem1 = new TechicalItem();
        techicalItem1.ID = 5;
        techicalItem1.name = "magazine";
        techicalItem1.price = 70;
        techicalItem1.category = Category.PRINT;
        techicalItem1.warrantyTime = 14;

        GenericItem[] items = {foodItem1, techicalItem1};
        for (GenericItem curr_item : items
        ) {
            curr_item.printAll();
        }

        System.out.println("Результат сравнения: " + foodItem2.equals(foodItem1));

        FoodItem foodClone = (FoodItem) foodItem1.clone();
        foodClone.printAll();

        System.out.println("Результат сравнения с клоном: " + foodItem1.equals(foodClone));
        System.out.println("Результат работы методы toString(): " + product1.toString());


        //// TASK 3 ////
        String line = new String("Конфеты ’Маска’;45;120");
        String[] item_fId = line.split(";");

        FoodItem foodItem3 = new FoodItem(item_fId[0], Float.parseFloat(item_fId[1]), Short.parseShort(item_fId[2]));
        foodItem3.printAll();
    }
}
