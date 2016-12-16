package fr.unice.iut.info.reseauSocial.implementation2016;

import fr.unice.iut.info.grapheX.Sommet;
import fr.unice.iut.info.reseauSocial.core.MemberInterface;

public class MemberImpl extends Sommet implements MemberInterface
{
    private int age;
    private String description;
    
    public MemberImpl (String identifiant, int newAge, String newDescription)
    {
        super(identifiant);
        age = newAge;
        description = newDescription;
    }
    
    public int getAge ()
    {
        return age;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public String ident ()
    {
        return identifiant();
    }
}
