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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miguel
 */
public class AmbTrabController implements Initializable  {

    @FXML
    private ListView<Cliente> listaClientes;
    @FXML
    private TextField txtPrNome;
    @FXML
    private TextField txtNumeroContribuinte;
    @FXML
    private TextField txtNumeroTelemovel;
    @FXML
    private TextField txtNumeroTelefone;
    @FXML
    private TextField txtMorada;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtCodigoPostal;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNumCompras;
    @FXML
    private Button btnEditar;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private DatePicker dataAdesao;
    @FXML
    private DatePicker dataUltimaCompra;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFeminino;
    
    ZoneId defaultZoneId = ZoneId.systemDefault();
    
    List<Cliente> listaC =  new ArrayList<>();
    ObservableList<Cliente> myObservableList = FXCollections.observableArrayList();
    
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
            stage.setMaximized(true);
            stage.setResizable(true);
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
    String que = "SELECT * FROM cliente LEFT JOIN contactoCliente on cliente.IDCliente = contactoCliente.IDCliente";
    
    public void showClientes() throws SQLException{
        con = Conexao.getCon();
        //conCont = Conexao.getCon();
        smt = con.createStatement();
        //cont = conCont.createStatement();
        rs = smt.executeQuery(que);
        
    }
    
    
    @FXML
    private void abrirCliente(ActionEvent event) throws IOException, SQLException {
        Cliente aux = listaClientes.getSelectionModel().getSelectedItem();
        txtPrNome.setText(aux.getPrNome() + " " + aux.getUltNome());
        Calendar cal = Calendar.getInstance();
        cal.setTime(aux.getDataNascimento());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        dataNascimento.setValue(LocalDate.of(year, month, day));
        
        cal.setTime(aux.getDataAdesao());
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        dataAdesao.setValue(LocalDate.of(year,month,day));
        if(aux.getSexo().equals("M")){
            rbFeminino.setSelected(false);
            rbMasculino.setSelected(true);
        }else{
            rbMasculino.setSelected(false);
            rbFeminino.setSelected(true);
        }
        
        cal.setTime(aux.getDataUltimaCompra());
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        dataUltimaCompra.setValue(LocalDate.of(year,month,day));
        
        String numComp = aux.getNumCompras() + " ";
        txtNumCompras.setText(numComp);
        String numeroCont = aux.getNumeroContribuinte() + " ";
        txtNumeroContribuinte.setText(numeroCont);
        String numeroTelemovel = aux.getNumeroTelemovel() + " ";
        txtNumeroTelemovel.setText(numeroTelemovel);
        String numeroTelefone = aux.getNumeroTelefone() + " ";
        txtNumeroTelefone.setText(numeroTelefone);
        txtMorada.setText(aux.getMorada());
        txtCidade.setText(aux.getCidade());
        txtCodigoPostal.setText(aux.getCodigoPostal());
        txtEmail.setText(aux.getEmail());
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            showClientes();
        } catch (SQLException ex) {
            Logger.getLogger(AmbTrabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while (rs.next()) {
                
                Cliente client = new Cliente();
                client.setID(rs.getInt("IDCliente"));
                client.setDataNascimento(rs.getDate("DataNascimento"));
                client.setSexo(rs.getString("Sexo"));
                client.setPrNome(rs.getString("PrNome"));
                client.setUltNome(rs.getString("UltNome"));
                client.setNumCompras(rs.getInt("NumCompras"));
                client.setDataAdesao(rs.getDate("DataAdr"));
                client.setDataUltimaCompra(rs.getDate("DataUltimaCompra"));
                client.setNumeroContribuinte(rs.getInt("NumeroContribuinte"));
                client.setNumeroTelemovel(rs.getInt("Telemovel"));
                client.setNumeroTelefone(rs.getInt("Telefone"));
                client.setMorada(rs.getString("Morada"));
                client.setCidade(rs.getString("Cidade"));
                client.setCodigoPostal(rs.getString("CodigoPostal"));
                client.setEmail(rs.getString("Email"));
                
                myObservableList.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmbTrabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaClientes.setItems(myObservableList);
    }    

}
