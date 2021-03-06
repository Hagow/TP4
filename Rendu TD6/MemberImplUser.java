package fr.unice.iut.info.reseauSocial.implementation2016;

import fr.unice.iut.info.facebookGhost.User;
import fr.unice.iut.info.grapheX.Sommet;
import fr.unice.iut.info.reseauSocial.core.MemberInterface;

public class MemberImplUser extends Sommet implements MemberInterface
{
    private int age;
    private String description;
    
    public MemberImplUser (User user)
    {
        super(user.getId());
        age = user.getAgeRange().getAge();
        description = user.myProfil();
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
