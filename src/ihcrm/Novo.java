/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

/**
 *
 * @author francisconunes
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    
public class Novo implements Initializable {
    
    @FXML
    private Label label;
    private TextField txtUser;
    
   
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Novo.fxml"));
       
        
        Scene scene = new Scene(root);
        
       
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

       
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        showAmbTrab(event);
    }
    
 
    public void showAmbTrab(ActionEvent event) throws IOException {
        //Define String user
        //String user = (String) txtUser.getText();
        //String bemVindo = "Bem-vindo: " + user;
        
        //Esta função serve para abrir novas janelas em que cria uma stage e uma scene   
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AmbTrab.fxml"));
            /* 
            * if "fx:controller" is not set in fxml
            * fxmlLoader.setController(NewWindowController);
            */
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("Bem-vindo ao IHCRM");
            stage.setScene(scene);
            stage.setMinHeight(646);
            stage.setMinWidth(1000);
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.show();
            
            //Esconder janela anterior
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            
    }    
    
}