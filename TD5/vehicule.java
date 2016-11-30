package TD5;

public class vehicule implements engin
{
    protected double poidsVide;
    protected double chargeMax;
    protected double charge;
    protected double vMax;
    protected String immatriculation;

    public vehicule (String Nimmatriculation)
    {
        immatriculation = Nimmatriculation;
        charge = 0;
    }

    public int getVMax() {
        return 0;
    }

    public String setCharge(double Ncharge)
    {
        if (Ncharge <= chargeMax && Ncharge>0)
        {
            charge = Ncharge;
            return "ok";
        }
        else
        {
            return "Erreur : charge > Charge max";
        }
    }

    public int getWeight() {
        return 0;
    }
    public int getHorsePower() {
        return 0;
    }

}