package fr.unice.iut.info;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer
{
    //region FXML Controls
    @FXML
    private TextField txtBusName;
    @FXML
    private TextField txtBoxName;
    @FXML
    private TextField txtMessageContent;
    @FXML
    private Button btnLireMessages;
    @FXML
    private Label lblFeedBack;
    @FXML
    private TreeView<?> treeView;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button btnCreerBus;
    @FXML
    private Button btnEmettreMessage;
    @FXML
    private Button btnCreerBoite;
    @FXML
    private Button btnValider;
    @FXML
    private Label lblBusName;
    @FXML
    private Label lblBoxName;
    @FXML
    private Label lblMessageContent;
    
    //endregion
    
    private BusManager manager = new BusManager();
    private SerializationClass sauvegarde = new SerializationClass();
    private Timeline timeline = new Timeline();
    
    private List<KeyValue> values = new ArrayList<KeyValue>();
    private String Red = "#d9534f";
    private String Green = "#5cb85c";
    
    private int selectedAction = 0;
    
    @FXML
    public void initialize () throws IOException, InterruptedException
    {
        Object o = sauvegarde.read("SavedManager.xml");
        if(o != null)
        {
            if(o instanceof BusManager)
            {
                manager = (BusManager) o;
                
                lblFeedBack.setText("Bus Manager Chargé");
                lblFeedBack.setTextFill(Color.web(Green));
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),
                                                         new KeyValue(lblFeedBack.textProperty(), "")));
                timeline.play();
            }
            else
            {
                lblFeedBack.setText("Le fichier n'est pas de type Bus Manager");
                lblFeedBack.setTextFill(Color.web(Red));
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),
                                                         new KeyValue(lblFeedBack.textProperty(), "")));
                timeline.play();
            }
        }
        else
        {
            lblFeedBack.setText("Pas de précédente Sauvegarde");
            lblFeedBack.setTextFill(Color.web(Red));
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                     new KeyValue(lblFeedBack.textProperty(), "")));
            timeline.play();
        }
        
        manager.addObserver(this);
        manager.Start();
        
        listView.setVisible(false);
        
        txtBusName.setVisible(false);
        lblBusName.setVisible(false);
        
        txtBoxName.setVisible(false);
        lblBoxName.setVisible(false);
        
        txtMessageContent.setVisible(false);
        lblMessageContent.setVisible(false);
        
        btnValider.setVisible(false);
    }
    
    @FXML
    void btnCreerBus_onClick (ActionEvent event)
    {
        txtBusName.setText("");
        
        selectedAction = 1;
        
        txtBusName.setVisible(true);
        lblBusName.setVisible(true);
        
        btnValider.setVisible(true);
    }
    
    @FXML
    void btnCreerBoite_onClick (ActionEvent event)
    {
        txtBusName.setText("");
        txtBoxName.setText("");
        
        selectedAction = 2;
        
        txtBusName.setVisible(true);
        lblBusName.setVisible(true);
        
        txtBoxName.setVisible(true);
        lblBoxName.setVisible(true);
        
        btnValider.setVisible(true);
    }
    
    @FXML
    void btnLireMessages_onClick (ActionEvent event)
    {
        txtBusName.setText("");
        txtBoxName.setText("");
        
        selectedAction = 3;
        
        txtBusName.setVisible(true);
        lblBusName.setVisible(true);
        
        txtBoxName.setVisible(true);
        lblBoxName.setVisible(true);
        
        listView.setVisible(true);
        btnValider.setVisible(true);
    }
    
    @FXML
    void btnEmettreMessage_onClick (ActionEvent event)
    {
        txtBoxName.setText("");
        txtBusName.setText("");
        txtMessageContent.setText("");
        
        selectedAction = 4;
        
        txtBusName.setVisible(true);
        lblBusName.setVisible(true);
        
        txtBoxName.setVisible(true);
        lblBoxName.setVisible(true);
        
        txtMessageContent.setVisible(true);
        lblMessageContent.setVisible(true);
        
        btnValider.setVisible(true);
    }
    
    @FXML
    void btnValider_onClick (ActionEvent event)
    {
        String busName;
        String boxName;
        String messageContent;
        Boolean reussi;
        
        switch (selectedAction)
        {
            //region Créer Bus
            case 1:
                busName = txtBusName.getText();
                
                if(busName.isEmpty())
                {
                    lblFeedBack.setText("Vous devez saisir un nom valide");
                    lblFeedBack.setTextFill(Color.web(Red));
                    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                             new KeyValue(lblFeedBack.textProperty(), "")));
                    timeline.play();
                }
                else
                {
                    reussi = manager.createBus(busName);
                    sauvegarde.save(manager, "SavedManager.xml");
                    
                    System.out.println(manager);
                    
                    if(reussi)
                    {
                        lblFeedBack.setText("Bus " + busName + " créé");
                        lblFeedBack.setTextFill(Color.web(Green));
                        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                 new KeyValue(lblFeedBack.textProperty(), "")));
                        timeline.play();
                    }
                    else
                    {
                        lblFeedBack.setText("Erreur le bus " + busName + " existe déjà");
                        lblFeedBack.setTextFill(Color.web(Red));
                        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                 new KeyValue(lblFeedBack.textProperty(), "")));
                        timeline.play();
                    }
                }
                txtBusName.setVisible(false);
                lblBusName.setVisible(false);
                
                btnValider.setVisible(false);
                break;
            //endregion
            
            //region Créer Boite
            case 2:
                busName = txtBusName.getText();
                boxName = txtBoxName.getText();
                
                if(busName.isEmpty() || boxName.isEmpty())
                {
                    lblFeedBack.setText("Vous devez saisir un nom valide");
                    lblFeedBack.setTextFill(Color.web(Red));
                    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                             new KeyValue(lblFeedBack.textProperty(), "")));
                    timeline.play();
                }
                else
                {
                    if(manager.hasExistingBus(busName))
                    {
                        reussi = manager.createBox(busName, boxName);
                        sauvegarde.save(manager, "SavedManager.xml");
                        
                        System.out.println(manager);
                        
                        if(reussi)
                        {
                            lblFeedBack.setText("Boite " + boxName + " créé dans " + busName);
                            lblFeedBack.setTextFill(Color.web(Green));
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                     new KeyValue(lblFeedBack.textProperty(), "")));
                            timeline.play();
                        }
                        else
                        {
                            lblFeedBack.setText("Erreur la boite " + boxName + " existe déjà dans " + busName);
                            lblFeedBack.setTextFill(Color.web(Red));
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                     new KeyValue(lblFeedBack.textProperty(), "")));
                            timeline.play();
                        }
                    }
                    else
                    {
                        lblFeedBack.setText("Bus " + busName + " n'existe pas");
                        lblFeedBack.setTextFill(Color.web(Red));
                        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                 new KeyValue(lblFeedBack.textProperty(), "")));
                        timeline.play();
                    }
                }
                
                txtBusName.setVisible(false);
                lblBusName.setVisible(false);
                
                txtBoxName.setVisible(false);
                lblBoxName.setVisible(false);
                
                btnValider.setVisible(false);
                
                break;
            //rendregion
            
            //region Read Message
            case 3:
                busName = txtBusName.getText();
                boxName = txtBoxName.getText();
                
                ObservableList<String> items = FXCollections.observableArrayList();
                
                if(busName.isEmpty())
                {
                    lblFeedBack.setText("Vous devez saisir un nom valide");
                    lblFeedBack.setTextFill(Color.web(Red));
                    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                             new KeyValue(lblFeedBack.textProperty(), "")));
                    timeline.play();
                }
                else
                {
                    if(busName.equalsIgnoreCase("All"))
                    {
                        for (Message m : manager.getAllMessages())
                        {
                            items.add(m.toString());
                        }
                        
                        listView.setItems(items);
                    }
                    else
                    {
                        if(manager.hasExistingBus(busName))
                        {
                            if(boxName.isEmpty())
                            {
                                lblFeedBack.setText("Vous devez saisir un nom valide");
                                lblFeedBack.setTextFill(Color.web(Red));
                                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                         new KeyValue(lblFeedBack.textProperty(), "")));
                                timeline.play();
                            }
                            else
                            {
                                if(boxName.equalsIgnoreCase("All"))
                                {
                                    for (Message m : manager.getAllMessages(busName))
                                    {
                                        items.add(m.toString());
                                    }
                                    
                                    listView.setItems(items);
                                }
                                else
                                {
                                    if(manager.hasExistingBox(busName, boxName))
                                    {
                                        for (Message m : manager.getAllMessages(busName, boxName))
                                        {
                                            items.add(m.toString());
                                        }
                                        
                                        listView.setItems(items);
                                    }
                                    else
                                    {
                                        lblFeedBack.setText("Boite " + boxName + " n'existe pas sur le bus " + busName);
                                        lblFeedBack.setTextFill(Color.web(Red));
                                        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                                 new KeyValue(lblFeedBack.textProperty(),
                                                                                              "")));
                                        timeline.play();
                                    }
                                }
                            }
                        }
                        else
                        {
                            lblFeedBack.setText("Bus " + busName + " n'existe pas");
                            lblFeedBack.setTextFill(Color.web(Red));
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                     new KeyValue(lblFeedBack.textProperty(), "")));
                            timeline.play();
                        }
                    }
                }
                txtBusName.setVisible(false);
                lblBusName.setVisible(false);
    
                txtBoxName.setVisible(false);
                lblBoxName.setVisible(false);
                
                txtMessageContent.setVisible(false);
                lblMessageContent.setVisible(false);
                
                btnValider.setVisible(false);
                listView.setVisible(false);
                
                break;
            //endregion
            
            //region Emit Message
            case 4:
                busName = txtBusName.getText();
                boxName = txtBoxName.getText();
                messageContent = txtMessageContent.getText();
                
                if(busName.isEmpty() || messageContent.isEmpty())
                {
                    lblFeedBack.setText("Vous devez saisir un nom valide");
                    lblFeedBack.setTextFill(Color.web(Red));
                    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                             new KeyValue(lblFeedBack.textProperty(), "")));
                    timeline.play();
                }
                else
                {
                    if(manager.hasExistingBus(busName))
                    {
                        reussi = boxName.isEmpty() ? manager.emit(busName, messageContent) : manager.emit(busName,
                                                                                                          boxName,
                                                                                                          messageContent);
                        sauvegarde.save(manager, "SavedManager.xml");
                        System.out.println(manager);
                        
                        if(reussi)
                        {
                            if(boxName.isEmpty())
                            {
                                lblFeedBack.setText("Message posté dans default de " + busName);
                            }
                            else
                            {
                                lblFeedBack.setText("Message posté dans " + boxName + " de " + busName);
                            }
                            lblFeedBack.setTextFill(Color.web(Green));
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                     new KeyValue(lblFeedBack.textProperty(), "")));
                            timeline.play();
                        }
                        else
                        {
                            lblFeedBack.setText("Erreur la boite " + boxName + " n'éxiste pas dans " + busName);
                            lblFeedBack.setTextFill(Color.web(Red));
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                     new KeyValue(lblFeedBack.textProperty(), "")));
                            timeline.play();
                        }
                    }
                    else
                    {
                        lblFeedBack.setText("Bus " + busName + " n'existe pas");
                        lblFeedBack.setTextFill(Color.web(Red));
                        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(4),
                                                                 new KeyValue(lblFeedBack.textProperty(), "")));
                        timeline.play();
                    }
                }
                
                txtBusName.setVisible(false);
                lblBusName.setVisible(false);
                
                txtBoxName.setVisible(false);
                lblBoxName.setVisible(false);
                
                txtMessageContent.setVisible(false);
                lblMessageContent.setVisible(false);
                
                listView.setVisible(false);
                btnValider.setVisible(false);
                break;
            //endregion
            
            //region Default
            default:
                break;
            //endregion
        }
    }
    
    public void update (Observable observable, Object object)
    {
        final Observable obs = observable;
        
        if(obs instanceof BusManager)
        {
            Platform.runLater(new Runnable()
            {
                public void run ()
                {
                    BusManager manager = (BusManager) obs;
                    TreeItem BusManager = new TreeItem<String>("BusManager");
                    
                    for (String BusName : manager.getAllBusNames())
                    {
                        TreeItem<String> Bus = new TreeItem<String>(BusName);
                        
                        for (String boxName : manager.getAllBoxNames(BusName))
                        {
                            TreeItem<String> Box = new TreeItem<String>(boxName);
                            Bus.getChildren().add(Box);
                        }
                        BusManager.getChildren().add(Bus);
                    }
                    
                    treeView.setRoot(BusManager);
                    treeView.setShowRoot(false);
                    treeView.refresh();
                }
            });
        }
    }
    
}