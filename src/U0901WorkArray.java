public class U0901WorkArray <T extends Number> {
    T[] arrNums;

    public U0901WorkArray(T[] numP){
        arrNums=numP;// Присваиваем ссылку входного параметра
    }

    public double sum(){
        double doubleWork = 0;
        for (T elem: arrNums){
            doubleWork+= elem.doubleValue();
        }
        return doubleWork;
    }
}
