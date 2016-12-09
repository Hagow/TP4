package iut.unice.iut.info.methodo.s3a;

import fr.unice.iut.info.methodo.service.MemberRW;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class UtilisaterRW extends MemberRW
{
    private JSONParser parser = new JSONParser();
    
    public void saveUtilisateur (UTILISATEUR newUtilisateur, String filePath) throws IllegalAccessException, IOException, ParseException
    {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath));
        
        JSONObject obj = this.getJsonFromUtilisateur(newUtilisateur);
        fileWriter.write(obj.toJSONString());
        fileWriter.newLine();
    }
    
    public UTILISATEUR readUtilisateur (String filePath) throws IOException, ParseException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        
        Object obj = this.parser.parse(fileReader);
        return this.getUtilisaterFromJson((JSONObject) obj);
    }
    
    public UTILISATEUR getUtilisaterFromJson (JSONObject jsonObject)
    {
        String formation = (String) jsonObject.get("Formation");
        String surnom = (String) jsonObject.get("Surnom");
        String humeur = (String) jsonObject.get("Humeur");
        COORDONNEES adresse = (COORDONNEES) jsonObject.get("Adresse");
        String motDePasse = (String) jsonObject.get("MotDePasse");
        String email = (String) jsonObject.get("Email");
        Boolean isConnected = (Boolean) jsonObject.get("isConnected");
        Boolean isAdmin = (Boolean) jsonObject.get("isAdmin");
        
        UTILISATEUR utilisateur = new UTILISATEUR(surnom, email, formation, motDePasse, isAdmin);
        utilisateur.setAdresse(adresse);
        utilisateur.setHumeur(humeur);
        utilisateur.setConnected(isConnected);
        
        return utilisateur;
    }
    
    public JSONObject getJsonFromUtilisateur (UTILISATEUR utilisateur)
    {
        JSONObject obj = new JSONObject();
        obj.put("Formation", utilisateur.getFormation());
        obj.put("Surnom", utilisateur.getSurnom());
        obj.put("Humeur", utilisateur.getHumeur());
        obj.put("Adresse", utilisateur.getAdresse());
        obj.put("MotDePasse", utilisateur.getMotDePasse());
        obj.put("Email", utilisateur.getEmail());
        obj.put("isConnected", utilisateur.getConnected());
        obj.put("isAdmin", utilisateur.getAdmin());
        return obj;
    }
    
}