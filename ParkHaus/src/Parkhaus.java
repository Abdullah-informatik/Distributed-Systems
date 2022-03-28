import java.util.Random;

//Passive Klasse
public class Parkhaus {
    int kapazitaet=0;
    Parkhaus(int place) {
        int count = 0;
        int timePark = new Random().nextInt(10);
        kapazitaet = place;
    }
}
