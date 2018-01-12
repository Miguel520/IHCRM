/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miguel
 */
public class AmbTrabController implements Initializable  {

    @FXML
    private ListView listaClientes;
    private TextField txtPrNome;
    private Button btnEditar;
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
            fxmlLoader.setLocation(getClass().getResource("Novo.fxml"));
            /* 
            * if "fx:controller" is not set in fxml
            * fxmlLoader.setController(NewWindowController);
            */
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            Stage stage = new Stage();
            stage.setTitle("Bem-vindo ao IHCRM");
            stage.setScene(scene);
            stage.setMinHeight(100);
            stage.setMinWidth(0);
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

    
    ResultSet rs = null;
    Connection con = null;
    Statement smt = null;
    static ArrayList<Cliente> listaCliente=new ArrayList<Cliente>();
    String que = "SELECT * FROM cliente";
    
    public void showClientes() throws SQLException{
        con = Conexao.getCon();
        
        smt = con.createStatement();
           
        rs = smt.executeQuery(que);
    }
    
    
    @FXML
    private void editarCliente(ActionEvent event) throws IOException, SQLException {
        showClientes();
        
        while (rs.next()) {

            Cliente client = new Cliente();

            client.setPrNome(rs.getString("PrNome"));
            client.setUltNome(rs.getString("UltNome"));
            client.setDataAdesao(rs.getDate("DataAdr"));
            client.setDataUltimaCompra(rs.getDate("DataUltimaCompra"));
            
            
            listaCliente.add(client);
        }
        
        listaCliente.forEach((client) -> {
            listaClientes.getItems().add(client.getPrNome());
        });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
