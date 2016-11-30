package TD5;

public class camionsCiternes extends vehicule
{
    public camionsCiternes (String Nimmatriculation)
    {
        super(Nimmatriculation);
        poidsVide = 3;
        chargeMax = 10;
    }
    @Override
    public int getVMax() {
        int vMax = 0;
        if (charge == 0)
        {
            vMax = 130;
        }
        if (charge >0 && charge <= 1)
        {
            vMax = 110;
        }
        if (charge > 1 && charge <=4)
        {
            vMax = 90;
        }
        if (charge > 4)
        {
            vMax = 80;
        }
        return vMax;

    }
}