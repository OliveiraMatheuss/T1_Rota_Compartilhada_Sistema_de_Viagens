/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;

/**
 *
 * @author Matheus Ramos de Oliveira
 */
public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private Endereco endereco;
    
    public Pessoa(String nome, String cpf, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    public Pessoa(){
        
    }
    
    public String getNome(){
        return this.nome; 
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public Endereco getEndereco(){
        return this.endereco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
}
