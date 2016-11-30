package TD5;

public class voituresSansPermis extends vehicule {

    public voituresSansPermis (String Nimmatriculation)
    {
        super(Nimmatriculation);
        poidsVide = 0.5;
        chargeMax = 0;
    }

    @Override
    public int getVMax() {
        return 50;
    }
}

