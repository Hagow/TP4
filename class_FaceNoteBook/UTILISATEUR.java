package iut.unice.iut.info.methodo.s3a;

import fr.unice.iut.info.methodo.core.Member;

public class UTILISATEUR extends Member
{
    private String formation;
    private String surnom;
    private String humeur;
    private COORDONNEES adresse;
    private String motDePasse;
    private String email;
    private Boolean isConnected;
    private Boolean isAdmin;
    
    public UTILISATEUR (String Surnom, String Email, String Formation, String MotDePasse)
    {
        super("prenom", "nom");
        setMotDePasse(MotDePasse);
        setFormation(Formation);
        setSurnom(Surnom);
        setEmail(Email);
        setConnected(false);
        isAdmin = false;
    }
    
    public UTILISATEUR (String Surnom, String Email, String Formation, String MotDePasse, Boolean Admin)
    {
        super("prenom", "nom");
        setMotDePasse(MotDePasse);
        setFormation(Formation);
        setSurnom(Surnom);
        setEmail(Email);
        setConnected(false);
        isAdmin = Admin;
    }
    
    //region Getters
    
    public String getMotDePasse ()
    {
        return motDePasse;
    }
    
    public String getFormation ()
    {
        return formation;
    }
    
    public String getSurnom ()
    {
        return surnom;
    }
    
    public String getHumeur ()
    {
        return humeur;
    }
    
    public COORDONNEES getAdresse ()
    {
        return adresse;
    }
    
    public String getEmail ()
    {
        return email;
    }
    
    public Boolean getAdmin ()
    {
        return isAdmin;
    }
    
    public Boolean getConnected ()
    {
        return isConnected;
    }
    
    //endregion
    
    //region Setters
    
    public void setMotDePasse (String motDePasse)
    {
        this.motDePasse = motDePasse;
    }
    
    public void setFormation (String formation)
    {
        this.formation = formation;
    }
    
    public void setSurnom (String surnom)
    {
        this.surnom = surnom;
    }
    
    public void setHumeur (String humeur)
    {
        this.humeur = humeur;
    }
    
    public void setAdresse (COORDONNEES adresse)
    {
        this.adresse = adresse;
    }
    
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    public void setConnected (Boolean connected)
    {
        isConnected = connected;
    }
    
    //endregion
    
}
