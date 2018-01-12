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
    private int ID, numeroContribuinte, numeroTelemovel;
    private String prNome, ultNome, notasCliente, sexo;
    private Date dataNascimento, dataAdesao, dataUltimaCompra;
    Statement st = null;
    
    public Cliente(){
        this.ID = 0;
        this.numeroContribuinte = 0;
        this.numeroTelemovel = 0;
        this.prNome = null;
        this.ultNome = null;
        this.notasCliente = null;
        this.dataNascimento = null;
        this.dataAdesao = null;
    }
    
    public Cliente(int ID, int numeroContribuinte, int numeroTelemovel, String nomeCliente, String ultNome, String notasCliente, Date dataNascimento, Date dataAdesao, String sexo){
        this.ID = ID;
        this.numeroTelemovel = numeroTelemovel;
        this.numeroContribuinte = numeroContribuinte;
        this.prNome = nomeCliente;
        this.ultNome = ultNome;
        this.notasCliente = notasCliente;
        this.dataNascimento = dataNascimento;
        this.dataAdesao = dataAdesao;
        this.sexo = sexo;
    }
    
    public int getID(){
        return ID;
    }
    
    public int getNumeroContribuinte(){
        return numeroContribuinte;
    }
    
    public int getNumeroTelemovel(){
        return numeroTelemovel;
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
    
    public String getSexo(){
        return sexo;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public void setNumeroContribuinte(int numeroContribuinte){
        this.numeroContribuinte = numeroContribuinte;
    }
    
    public void setNumeroTelemovel(int numeroTelemovel){
        this.numeroTelemovel = numeroTelemovel;
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
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    @Override
    public String toString(){
        return (this.prNome + " " + this.ultNome);
    }
}
