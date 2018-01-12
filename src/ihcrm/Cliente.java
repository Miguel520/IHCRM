/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author miguel
 */
public class Cliente {
    private String prNome, ultNome, notasCliente;
    private Date dataNascimento, dataAdesao, dataUltimaCompra;
    private char sexo;
    Statement st = null;
    
    public Cliente(){
        this.prNome = null;
        this.ultNome = null;
        this.notasCliente = null;
        this.dataNascimento = null;
        this.dataAdesao = null;
    }
    
    public Cliente(String nomeCliente, String ultNome, String notasCliente, Date dataNascimento, Date dataAdesao, char sexo){
        this.prNome = nomeCliente;
        this.ultNome = ultNome;
        this.notasCliente = notasCliente;
        this.dataNascimento = dataNascimento;
        this.dataAdesao = dataAdesao;
        this.sexo = sexo;
    }
    
    public String getPrNome(){
        return prNome;
    }
    
    public String getUltNome(){
        return ultNome;
    }
    
    public String getNotasCliente(){
        return notasCliente;
    }
    
    public Date getDataNascimento(){
        return dataNascimento;
    }
    
    public Date getDataAdesao(){
        return dataAdesao;
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setPrNome(String prNome){
        this.prNome = prNome;
    }
    
    public void setUltNome(String ultNome){
        this.ultNome = ultNome;
    }
    
    public void setNotasCliente(String notasCliente){
        this.notasCliente = notasCliente;
    }
    
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public void setDataUltimaCompra(Date dataUltimaCompra){
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
    public void setDataAdesao(Date dataAdesao){
        this.dataAdesao = dataAdesao;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
}
