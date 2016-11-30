/**
 * Created by laurent on 28/11/2016.
 */
import java.util.ArrayList;

public class Convoi extends ArrayList<Vehicule> {

    public int getVitesseMax() {
        int plafond = Integer.MAX_VALUE;
        for (Vehicule v : this) {
            int vitesseVehicule = v.getVitesseMax();
            if (vitesseVehicule<plafond) {
                plafond = vitesseVehicule;
            }
        }
        return plafond;
    }
}
