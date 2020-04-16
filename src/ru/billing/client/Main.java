package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;
import ru.sync.U1901Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, ItemAlreadyExistsException, CatalogLoadException {

        GenericItem product1 = new GenericItem();
        product1.setID(1);
        product1.setName("Cola");
        product1.setPrice(60);
        product1.printAll();


        GenericItem product2 = new GenericItem();
        product1.setID(2);
        product1.setName("Fanta");
        product1.setPrice(65);
        product2.setAnalog(product1);
        product2.printAll();


        GenericItem product3 = new GenericItem();
        product3.setID(3);
        product3.setName("Mars");
        product3.setPrice(45);
        product3.printAll();


        FoodItem foodItem1 = new FoodItem("juice", 90, null, new Date(2020, 2, 5), (short) 30);


        FoodItem foodItem2 = new FoodItem("cola", 30, null, new Date(2020, 3, 11), (short) 40);


        TechicalItem techicalItem1 = new TechicalItem();
        techicalItem1.setID(5);
        techicalItem1.setName("magazine");
        techicalItem1.setPrice(70);
        techicalItem1.setCategory(Category.PRINT);
        techicalItem1.setWarrantyTime((short) 14);

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


        //// TASK 4 ////
        ItemCatalog itemCatalog = new ItemCatalog();
        itemCatalog.addItem(techicalItem1);
        itemCatalog.addItem(foodItem1);
        itemCatalog.addItem(foodItem2);
        itemCatalog.addItem(foodItem3);
        itemCatalog.addItem(product1);
        itemCatalog.addItem(product2);
        //itemCatalog.addItem(product3);
        //itemCatalog.addItem(foodClone);

        long begin = new Date().getTime();

        for(int i=0; i < 1000000; i++)  itemCatalog.findItemByID(3);

        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin)); begin = new Date().getTime(); //Быстрее, поиск ключа

        for(int i=0; i<1000000;i++) itemCatalog.findItemByIDAL(3);

        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(itemCatalog);
        itemCatalog.printItems();//проверка

        ///// TASK 6 /////



        CatalogLoader loader2 = new CatalogFileLoader("items.lst");
        loader2.load(itemCatalog);
        itemCatalog.printItems();//проверка


        System.out.println("\nUTF-8:");
        File UTF8 = new File("fileUTF.txt");
        FileInputStream file1 = null;
        try {
            file1 = new FileInputStream(UTF8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(file1);
        String strUTF8 = null;
        try {
            strUTF8 = new String(scanner.nextLine().getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(strUTF8);



        System.out.println("\nWindows-1251:");
        File W1251 = new File("mem2.txt");

        FileInputStream file2 = null;
        try {
            file2 = new FileInputStream(W1251);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner2 = new Scanner(file2);
        String strW1251 = null;
        try {
            strW1251 = new String(scanner2.nextLine().getBytes("Windows-1251"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(strW1251);


        System.out.println("Потоки:");
        U1901Main.test();

    }
}
