/**
 * Created by laurent on 28/11/2016.
 */
public abstract class Petitbus extends Vehicule {
        protected int poidVide = 4000;

        public Petitbus(String immatriculation, int poidVide) {
            super(immatriculation, poidVide);
        }

        public int getVitesseMax() {
            return 150;
        }
}
