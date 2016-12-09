package iut.unice.iut.info.methodo.s3a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws IOException
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomeView.fxml"));
            primaryStage.setTitle("Home");
            primaryStage.setScene(new Scene(root, 618, 569));
            primaryStage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
}