package iut.unice.iut.info.methodo.s3a;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController
{
    @FXML
    private TextField txtboxID;
    
    @FXML
    private PasswordField txtboxMdp;
    
    @FXML
    private Label lblErreur;
    
    @FXML
    private Button btnValider;
    
    @FXML
    private Button btnRetour;
    
    @FXML
    void valider_onClick (ActionEvent event) throws Throwable
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("TabView.fxml"));
            Stage stage = (Stage) btnRetour.getScene().getWindow();
            Scene scene = new Scene(root, 601, 391);
            stage.setScene(scene);
            stage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
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









