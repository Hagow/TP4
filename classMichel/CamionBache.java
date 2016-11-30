/**
 * Created by laurent on 28/11/2016.
 */
public abstract class CamionBache extends Vehicule {
    protected int chargeMax = 20000;
    protected int poidVide = 4000;

    public CamionBache(String immatriculation) {
        super(immatriculation, poidVide);
    }

    public CamionBache(String immatriculation, int charge) {
        super(immatriculation, poidVide, chargeMax, charge);
    }

    public int getVitesseMax() {
        if (charge == 0) return 130;
        if (charge > 0 && charge <= 3000) return 110;
        if (charge > 3000 && charge <= 7000) return 90;
        if (charge > 7000) return 80;
        return 0;
    }
    }
}