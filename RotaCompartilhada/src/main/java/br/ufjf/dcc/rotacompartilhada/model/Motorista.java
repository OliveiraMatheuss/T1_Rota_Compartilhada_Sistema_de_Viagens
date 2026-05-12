/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;

/**
 *
 * @author 55329
 */
public class Motorista extends Pessoa {
    
    private Veiculo veiculo;
    private boolean disponivel;
    
    
    public Motorista(String nome, String cpf, Endereco endereco, Veiculo veiculo){
        
        super(nome, cpf, endereco);
        this.veiculo = veiculo;
        this.disponivel = true;
    }
    
    public boolean podeOferecerCarona(){
        return this.veiculo.getAnoFabricacao()>=2016;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
