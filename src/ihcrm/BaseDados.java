/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miguel
 */
public class BaseDados {
    public static String estado = "Não conectado!";
    
    //Método de Conexão//
 
    public static java.sql.Connection getMySql() throws SQLException {

        Connection connection = null;          //atributo do tipo Connection


        try {
            //Driver usado na conexao
            String nomeDriver = "com.mysql.jdbc.Driver";
            Class.forName(nomeDriver);

            //Dados do Servidor MySql
            String url = "jdbc:mysql://localhost/mfMain";
            String username = "root";        //nome de um usuário de seu BD      
            String password = "teste123";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);
  
            if (connection != null) {
                estado = ("Conectado com sucesso!");
            } else {
                estado = ("Erro na conexão!");
            }
            return connection;

        } catch (ClassNotFoundException msqlErro) {
            System.out.println("Driver não encontrado!");
            return null;
        } catch (SQLException msqlErro) {
            System.out.println("Ligação não establecida!");
            return null;
        }
    }

    public static String getEstado() {
        return estado;
    }

    public static boolean terminaMySql(){
        try {
            BaseDados.getMySql().close();
            return true;
        } catch (SQLException msqlErro) {
            return false;
        }
    }

       

    public static java.sql.Connection ReiniciarConexao() throws SQLException {
        terminaMySql();
        return BaseDados.getMySql();
    }
 

}
