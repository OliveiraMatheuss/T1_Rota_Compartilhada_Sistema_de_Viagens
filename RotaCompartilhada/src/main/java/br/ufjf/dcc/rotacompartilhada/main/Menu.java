/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.main;
import br.ufjf.dcc.rotacompartilhada.model.Motorista;
import br.ufjf.dcc.rotacompartilhada.model.Passageiro;
import br.ufjf.dcc.rotacompartilhada.model.Endereco;
import br.ufjf.dcc.rotacompartilhada.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 55329
 */
public class Menu {
    
    private List<Motorista> motoristas;
    private List<Passageiro> passageiro;
    private Scanner teclado = new Scanner(System.in);
    
    public void exibirMenuPrincipal(){
        int opcao = 1;
        
        while(opcao!=0){
            System.out.println("\n=== ROTA COMPARTILHADA ===");
            System.out.println("1. Motorista");
            System.out.println("2. Passageiro");
            System.out.println("3. Carona");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(teclado.nextLine());
            
            processarOpcao(opcao);
        }
    }
    
    private void processarOpcao(int opcao){
        
        switch(opcao){
            case 1 -> menuMotorista();
           // case 2 -> menuPassageiro();
            //case 3 -> menuCarona();
            case 0 -> System.out.println("Saindo...");
            
        }
    }
    
    public void menuMotorista(){
        int opcao = 1;
        
        while(opcao!=0){
            System.out.println("\n=== MENU MOTORISTA ===");
            System.out.println("1. Cadastrar Motorista");
            System.out.println("2. Listar Motoristas");
            System.out.println("3. Procurar Motorista");
            System.out.println("4. voltar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(teclado.nextLine());
            
            switch(opcao){
            case 1 -> cadastrarMotorista();
           // case 2 -> listarMotorista();
           // case 3 -> procurarMotorista();
            case 0 -> System.out.println("Saindo...");
            
            }
        }
    }
    public void cadastrarMotorista(){
     
        //PESSOA
        System.out.println("--- Cadastro de Motorista ---");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("CPF: ");
        String cpf = teclado.nextLine();
        
        //ENDERECO
        System.out.print("Tipo Logradouto: ");
        String tipo = teclado.nextLine();
        System.out.print("Nome Logradouro: ");
        String nomeLogradouro = teclado.nextLine();
        System.out.print("Numero: ");
        int numero = Integer.parseInt(teclado.nextLine());
        System.out.print("Bairro: ");
        String bairro = teclado.nextLine();
        System.out.print("Cidade: ");
        String cidade = teclado.nextLine();
        System.out.print("Estado: ");
        String estado = teclado.nextLine();
        System.out.print("Pais: ");
        String pais = teclado.nextLine();
        System.out.print("CEP: ");
        String cep = teclado.nextLine();
        
        //VEICULO
        System.out.print("Nome do Veiculo: ");
        String nomeVeiculo = teclado.nextLine();
        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();
        System.out.print("Placa: ");
        String placa = teclado.nextLine();
        System.out.print("Chassi: ");
        String chassi = teclado.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(teclado.nextLine());
        System.out.print("Cor: ");
        String cor = teclado.nextLine();
        
        
        Endereco endereco = new Endereco(tipo,nomeLogradouro,numero,bairro,cidade,estado,pais,cep);
        Veiculo veiculo = new Veiculo(nomeVeiculo,modelo,placa,chassi,ano,cor);
        if(ano>=2016){
            Motorista motorista = new Motorista(nome,cpf,endereco,veiculo);
            this.motoristas.add(motorista);
        }
        else{
            Motorista motorista = new Motorista(nome,cpf,endereco);
            this.motoristas.add(motorista);
        }
        
        
}
    
}
