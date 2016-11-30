/**
 * Created by laurent on 28/11/2016.
 */
public abstract class VoitureSansPermis extends Vehicule {

    public VoitureSansPermis(String immatriculation, int poidVide) {
        super(immatriculation, poidVide);
    }

    public int getVitesseMax() {
        return 50;
    }
}