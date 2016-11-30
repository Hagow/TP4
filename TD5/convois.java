package TD5;

import java.util.ArrayList;


public class convois extends ArrayList<vehicule> {

    public int VitesseMaxConvois() {
        int Vconvois = Integer.MAX_VALUE;
        for (vehicule v : this) {
            int VMvehicule = v.getVMax();
            if (VMvehicule<Vconvois) {
                Vconvois = VMvehicule;
            }
        }
        return Vconvois;
    }
}
