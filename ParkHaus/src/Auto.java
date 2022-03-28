import java.util.Random;

public class Auto extends Thread{
    private Object monitor=new Object();
    String kennzeichen="";
    Parkhaus parkhaus;
    Auto(String kennzeichen,Parkhaus parkhaus){
        this.kennzeichen=kennzeichen;
        this.parkhaus=parkhaus;
    }
    @Override
    public void run() {
        while(true) {
            parken();
            fahren();
        }
    }
    public void fahren(){
        int zeit_fahren=new Random().nextInt(10);
    }
    public void parken(){
        int zeit_parken=new Random().nextInt(10);
    }
    public void aufgabe(){
        synchronized (monitor){
            while (parkhaus.kapazitaet<=10){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parken();
                monitor.notifyAll();
            }
        }
    }
}
