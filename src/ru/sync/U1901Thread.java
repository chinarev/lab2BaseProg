package ru.sync;

public class U1901Thread extends Thread {

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    U1901Bank bankWork;
    int intTrans;
    long lngSleep;

    @Override
    public void run(){
        bankWork.calc(intTrans, lngSleep);
    }
}
