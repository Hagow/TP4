/**
 * Created by laurent on 30/11/2016.
 */
public class VoitureSansPermis extends Vehicule {
        public VoitureSansPermis(String immatriculation, int poidVide) {
            super(immatriculation, poidVide);
        }

        public int getVitesseMax() {
            return 50;
        }

    public int getHorse_Power() {
        return 0;
    }

    public double setCharge(double charge) {
        return 0;
    }
}

