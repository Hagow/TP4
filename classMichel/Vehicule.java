/**
 * Created by laurent on 28/11/2016.
 */
public abstract class Vehicule implements Moteur {

    protected int HORSE_POWER = 250;
    protected String immatriculation;
    protected int poidVide;
    protected int charge;

    public Vehicule(String immatriculation, int poidVide) {
        if (immatriculation == null) {
            throw new IllegalArgumentException("Erreur immatriculation");
        }
        if (poidVide<0) {
            throw new IllegalArgumentException("Erreur charge");
        }
        this.immatriculation = immatriculation;
        this.poidVide = poidVide;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public int getPoidVide() {
        return poidVide;
    }

    public int getHorsePower() {
        return HORSE_POWER;
    }

    public abstract int getVitesseMax();
}