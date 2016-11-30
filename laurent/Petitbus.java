/**
 * Created by laurent on 28/11/2016.
 */
public class Petitbus extends Vehicule {
        protected int poidVide = 4000;

        public Petitbus(String immatriculation, int poidVide) {
            super(immatriculation, poidVide);
        }

        public int getVitesseMax() {
            return 150;
        }

    public int getHorse_Power() {
        return 0;
    }

    public double setCharge(double charge) {
        return 0;
    }
}
