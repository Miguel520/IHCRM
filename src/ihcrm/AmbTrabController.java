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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
        
    }    
    
}
