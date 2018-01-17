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
    private int ID, numeroContribuinte, numeroTelemovel, numeroTelefone, numCompras;
    private String prNome, ultNome, notasCliente, sexo, morada, cidade, codigopostal, email;
    private Date dataNascimento, dataAdesao, dataUltimaCompra;
    Statement st = null;
    
    public Cliente(){
        this.ID = 0;
        this.numeroContribuinte = 0;
        this.numeroTelemovel = 0;
        this.numeroTelefone = 0;
        this.numCompras = 0;
        this.prNome = null;
        this.ultNome = null;
        this.notasCliente = null;
        this.dataNascimento = null;
        this.dataAdesao = null;
        this.dataUltimaCompra = null;
        this.morada = null;
        this.cidade = null;
        this.codigopostal = null;
        this.email = null;
    }
    
    public Cliente(int ID, int numeroContribuinte, int numeroTelemovel, int numeroTelefone, int numCompras, String morada, String codigopostal, String cidade, String email, String nomeCliente, String ultNome, String notasCliente, Date dataUltimaCompra, Date dataNascimento, Date dataAdesao, String sexo){
        this.ID = ID;
        this.numeroTelemovel = numeroTelemovel;
        this.numeroTelefone = numeroTelefone;
        this.numCompras = numCompras;
        this.numeroContribuinte = numeroContribuinte;
        this.prNome = nomeCliente;
        this.ultNome = ultNome;
        this.notasCliente = notasCliente;
        this.dataNascimento = dataNascimento;
        this.dataAdesao = dataAdesao;
        this.dataUltimaCompra = dataUltimaCompra;
        this.sexo = sexo;
        this.morada = morada;
        this.cidade = cidade;
        this.codigopostal = codigopostal;
        this.email = email;
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
    
    public int getNumeroTelefone(){
        return numeroTelefone;
    }
    
    public int getNumCompras(){
        return numCompras;
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
    
    public Date getDataUltimaCompra(){
        return dataUltimaCompra;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public String getMorada(){
        return morada;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public String getCodigoPostal(){
        return codigopostal;
    }
    
    
    public String getEmail(){
        return email;
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
    
    public void setNumCompras(int numCompras){
        this.numCompras = numCompras;
    }
    
    public void setNumeroTelefone(int numeroTelefone){
        this.numeroTelefone = numeroTelefone;
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
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public void setCodigoPostal(String codigopostal){
        this.codigopostal = codigopostal;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    public String toString(){
        return (this.prNome + " " + this.ultNome);
    }
}
