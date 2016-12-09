package iut.unice.iut.info.methodo.s3a;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController
{
    @FXML
    private Button btnConnecter;
    
    @FXML
    private Button btnInscription;
    
    @FXML
    void inscription_onClick (ActionEvent event) throws Throwable
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("InscriptionView.fxml"));
            Stage stage = (Stage) btnInscription.getScene().getWindow();
            Scene scene = new Scene(root, 572, 600);
            stage.setScene(scene);
            stage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
    
    @FXML
    void connecter_onClick (ActionEvent event) throws Throwable
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ConnexionView.fxml"));
            Stage stage = (Stage) btnInscription.getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
    
}