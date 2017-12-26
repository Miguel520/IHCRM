/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihcrm;

import java.util.Date;

/**
 *
 * @author miguel
 */
public class Cliente {
    private String nomeCliente, notasCliente;
    private Date dataNascimento, dataAdesao;
    private char sexo;
    
    public Cliente(String nomeCliente, String notasCliente, Date dataNascimento, Date dataAdesao, char sexo){
        this.nomeCliente = nomeCliente;
        this.notasCliente = notasCliente;
        this.dataNascimento = dataNascimento;
        this.dataAdesao = dataAdesao;
        this.sexo = sexo;
    }
    
    public String getNomeCliente(){
        return nomeCliente;
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
    
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public void setNotasCliente(String notasCliente){
        this.notasCliente = notasCliente;
    }
    
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public void setDataAdesao(Date dataAdesao){
        this.dataAdesao = dataAdesao;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
}
