package ru.sync;

public class U1901Main {
    public static void test() {

        U1901Bank bankMain = new U1901Bank();
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 200);
        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        // Изменение имени потока:
        threadOne.setName("первый поток");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        threadTwo.setName("второй поток");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        Thread.currentThread().getName();
    }

}
