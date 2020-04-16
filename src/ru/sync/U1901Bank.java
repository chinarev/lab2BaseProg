package ru.sync;

public class U1901Bank {
    int intTo;
    int intFrom = 220;

    synchronized public void calc(int intTransaction, long lngTimeout){
        System.out.println("before: From " + intFrom + " To " + intTo + " " + Thread.currentThread().getName());
        this.intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.intTo += intTransaction;
        System.out.println("after: From " + intFrom + " To " + intTo + " " + Thread.currentThread().getName());
    }
}
