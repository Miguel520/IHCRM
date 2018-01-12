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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    
public class Novo implements Initializable {
    
    @FXML
    private TextField txtPrNome;
    @FXML
    private TextField txtUltNome;
    @FXML
    private TextField txtNrContribuinte;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFeminino;
    
    
    ResultSet rs = null;
    Connection con = null;
    Statement smt = null;
    
   
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Novo.fxml"));
       
        
        Scene scene = new Scene(root);
        
       
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

       
    }

    @FXML
    private void btnSalvar(ActionEvent event) throws IOException, SQLException {
        salvar(event);
    }
    
 
    public void salvar(ActionEvent event) throws IOException, SQLException {
        con = Conexao.getCon();
        
        smt = con.createStatement();
        
        //String que = "INSERT INTO cliente (DataNascimento, Sexo, NumeroContribuinte, PrNome, UltNome, DataAdr, NumCompras, DataUltimaCompra) VALUES (" + cl'1997-05-02', 'M', '763546789', 'Miguel', 'Sousa', '2017-01-02', '2', '2017-12-26'),";
           
        //rs = smt.executeQuery(que);
        
        String prNome = txtPrNome.getText();
        String ultNome = txtUltNome.getText();
        
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            
    }    
    
}