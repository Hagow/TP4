package iut.unice.iut.info.methodo.s3a;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class InscriptionController
{
    @FXML
    private TextField txtboxSurnom;
    
    @FXML
    private TextField txtboxEmail;
    
    @FXML
    private TextField txtboxFormation;
    
    @FXML
    private Label lblErreur;
    
    @FXML
    private Button btnValider;
    
    @FXML
    private Button btnRetour;
    
    @FXML
    private PasswordField txtMotDePasse;
    
    private Timeline timeline = new Timeline();
    
    @FXML
    void valider_onClick (ActionEvent event) throws Throwable
    {
        Boolean exists = false;
        UTILISATEUR utilisateur;
        ArrayList<UTILISATEUR> utilisateurs = new ArrayList<UTILISATEUR>();
        UtilisaterRW utilisateurRw = new UtilisaterRW();
        
        for (UTILISATEUR u : utilisateurs)
        {
            if(u.getEmail().equalsIgnoreCase(txtboxEmail.getText()))
            {
                exists = true;
            }
        }
        
        if(!exists)
        {
            utilisateur = new UTILISATEUR(txtboxSurnom.getText(),
                                          txtboxEmail.getText(),
                                          txtboxFormation.getText(),
                                          txtMotDePasse.getText());
            
            utilisateur.setConnected(true);
            
            utilisateurRw.saveUtilisateur(utilisateur, "Sauvegarde.json");
            
            try
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ConnexionView.fxml"));
                Stage stage = (Stage) btnValider.getScene().getWindow();
                Scene scene = new Scene(root, 618, 569);
                stage.setScene(scene);
                stage.show();
            }
            catch (NullPointerException npe)
            {
                npe.printStackTrace();
            }
        }
        else
        {
            lblErreur.setVisible(true);
            
            lblErreur.setText("Cette adresse email correspond à un compte déjà existant !");
            lblErreur.setTextFill(Color.web("#ff0000")); // Rouge
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4), new KeyValue(lblErreur.textProperty(), "")));
            timeline.play();
        }
    }
    
    @FXML
    void retour_onClick (ActionEvent event) throws Throwable
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomeView.fxml"));
            Stage stage = (Stage) btnRetour.getScene().getWindow();
            Scene scene = new Scene(root, 618, 569);
            stage.setScene(scene);
            stage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
}