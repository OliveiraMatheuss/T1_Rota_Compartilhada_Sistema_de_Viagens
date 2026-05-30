/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author 55329
 */
public class Endereco {
    private String tipoLogradouro;
    private String nomeLogradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    
    private static final List<String>LOGRADOUROS_PERMITIDOS = Arrays.asList("Rua","Avenida", "Alameda","Praça","Travessa","Rodovia","Estrada","Beco","Balneario","Bosque","Cais","Calçada","largo","Viaduto","Viela","Passarela");
    
    public Endereco(String tipoLogradouro, String nomeLogradouro, int numero, String bairro, String cidade, String estado, String pais,String cep){
        
        if(LOGRADOUROS_PERMITIDOS.contains(tipoLogradouro)){
            
            this.tipoLogradouro = tipoLogradouro;
            this.nomeLogradouro = nomeLogradouro;
            this.numero = numero;
            this.bairro = bairro;
            this.cidade = cidade;
            this.estado = estado;
            this.pais = pais;
            this.cep = cep; 
            
        }
        else{
            System.out.println("Tipo de logradouro inválido: " + tipoLogradouro);
        }
    }
    
    public String getTipoLogradouro(){
        
        return this.tipoLogradouro;
    }
    
    public String getNomeLogradouro(){
        return this.nomeLogradouro;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getBairro(){
        return this.bairro;
    }
    
    public String getCidade(){
        return this.cidade;
    }
    
    public String getPais(){
        return this.pais;
    }
    public String getCep(){
        return this.cep;
    }
    
    public void setTipoLogradouro(String tipoLogradouro){
        if(this.LOGRADOUROS_PERMITIDOS.contains(tipoLogradouro))
        {
            this.tipoLogradouro = tipoLogradouro;
        }
        else{
            throw new IllegalArgumentException("Tipo de logradouro inválido: " + tipoLogradouro);
                      
        }
    }
    
    public void setNomeLogradouro(String nomeLogradouro){
        this.nomeLogradouro = nomeLogradouro;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }
    public void setCep(String cep){
        this.cep = cep;
    } 
}
