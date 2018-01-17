/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String urlBD = "jdbc:mysql://localhost:3306/mfMain";
    private static final String user = "root";
    private static final String pass = "teste123";
    private static Connection conexao;
    
    
    public static Connection getCon(){
        try{
            Class.forName(driver);
            try{
                conexao = DriverManager.getConnection(urlBD, user, pass);
            }catch(SQLException ex){
                System.out.println("Conexão falhou!");
            }
        }catch(ClassNotFoundException se){
            System.out.println("Driver não encontrado!");
        }
        
        return conexao;
    }
}
