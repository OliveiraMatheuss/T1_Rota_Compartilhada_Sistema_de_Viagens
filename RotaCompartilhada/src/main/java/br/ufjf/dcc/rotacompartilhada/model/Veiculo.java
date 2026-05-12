/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;

/**
 *
 * @author 55329
 */
public  class Veiculo {
    private String nome;
    private String modelo;
    private String placa;
    private String chassi;
    private int    anoFabricacao;
    private String cor;
    
    
    public Veiculo( String nome, String modelo, String placa, String chassi, int anoFabricacao, String cor){
        
        if(anoFabricacao>2026){
            
            throw new IllegalArgumentException("Não é permitido cadastrar veiculos com data superior a 2026. Ano de Fabricação do carro: "+ anoFabricacao);
        }
        else{
            this.nome = nome;
            this.modelo = modelo;
            this.placa = placa;
            this.chassi = chassi;
            this.anoFabricacao = anoFabricacao;
            this.cor = cor;
        }
       
       
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getmodelo(){
        return this.modelo;
    }
    
    public String getPlaca(){
        return this.placa;
    }
    
    public String getChassi(){
        return this.chassi;
    }
    
    public int getAnoFabricacao(){
        return this.anoFabricacao;
    }
    
    public String getCor(){
        return this.cor;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo ;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public void setChassi(String chassi){
        this.chassi = chassi;
    }
    
    public void setAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao ;
    }
    
    public void set(String cor){
        this.cor = cor ;
    }
}
