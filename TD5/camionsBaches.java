package TD5;

public class camionsBaches extends vehicule
{
    public camionsBaches (String Nimmatriculation)
    {
        super(Nimmatriculation);
        poidsVide = 4;
        chargeMax = 20;
    }

    @Override
    public int getVMax() {
        int vMax = 0;
        if (charge == 0)
        {
            vMax = 130;
        }
        if (charge >0 && charge <= 3)
        {
            vMax = 110;
        }
        if (charge > 3 && charge <=7)
        {
            vMax = 90;
        }
        if (charge > 7)
        {
            vMax = 80;
        }
        return vMax;

    }
}