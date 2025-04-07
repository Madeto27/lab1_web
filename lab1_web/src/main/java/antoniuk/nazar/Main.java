package antoniuk.nazar;

public class Main {
    public static void main(String[] args) {

        Auto myAuto = new Auto();
        myAuto.refuel(50);

        myAuto.info();

        myAuto.ride();
        myAuto.ride();
        myAuto.ride();
        myAuto.ride();

        myAuto.info();

        
        //System.out.println(myAuto.getBrand());
        //System.out.println(myAuto.getFuelCapacity());
        //System.out.println(myAuto.getFuelLevel());
    }
}