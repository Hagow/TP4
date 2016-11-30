package TD5;

public class petitsBus extends vehicule
{

    public petitsBus (String Nimmatriculation)
    {
        super(Nimmatriculation);
        poidsVide = 3;
        chargeMax = 0;
    }

    @Override
    public int getVMax() {
        return 150;
    }
}