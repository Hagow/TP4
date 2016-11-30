/**
 * Created by laurent on 28/11/2016.
 */
public abstract class CamionCiterne extends Vehicule {
    protected int chargeMax = 10000;
    protected int poidVide = 3000;

    public CamionCiterne(String immatriculation) {
        super(immatriculation, poidVide);
    }

    public CamionCiterne(String immatriculation, int charge) {
        super(immatriculation, poidVide, chargeMax, charge);
    }

    public int getVitesseMax() {
        if (charge == 0) return 130;
        if (charge > 0 && charge <= 1000) return 110;
        if (charge > 1000 && charge <= 4000) return 90;
        if (charge > 4000) return 80;
        return 0;
    }
}