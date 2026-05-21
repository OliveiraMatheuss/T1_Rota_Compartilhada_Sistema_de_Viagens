/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 55329
 */
public class Motorista extends Pessoa {
    
    private Veiculo veiculo;
    private boolean disponivel;
    
    
    public Motorista(String nome, String cpf, Endereco endereco, Veiculo veiculo){
        
        super(nome, cpf, endereco);
        setVeiculo(veiculo);
        setDisponivel(true);
        
    }
    
    // Somente para teste
    public Motorista(){
        
        Endereco endereco = new Endereco("Rua","Nome Log",50,"bairro","cidade","estado","pais","cep");
        Veiculo veiculo = new Veiculo("Nome","Modelo","Placa","Chassi", 2025, "Cor");
        super.setNome("Matheus");
        super.setCpf("12204380652");
        super.setEndereco(endereco);
        this.setDisponivel(false);
        setVeiculo(veiculo);
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
