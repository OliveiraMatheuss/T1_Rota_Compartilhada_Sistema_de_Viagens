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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 55329
 */
public class Menu {
    
    private List<Motorista> motoristas = new ArrayList<>();
    private List<Passageiro> passageiros = new ArrayList<>();
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
            case 2 -> menuPassageiro();
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
            case 2 -> listarMotorista();
            case 3 -> procurarMotorista();
            case 4 -> exibirMenuPrincipal();
            case 0 -> System.out.println("Saindo...");
            
            }
        }
    }
    
    public Endereco cadastraEndereco(){
        
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
        
        Endereco endereco = new Endereco(tipo,nomeLogradouro,numero,bairro,cidade,estado,pais,cep);
        return endereco;
    }
    public void cadastrarMotorista(){
     
        //PESSOA
        System.out.println("--- Cadastro de Motorista ---");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("CPF: ");
        String cpf = teclado.nextLine();
        
        //ENDERECO
        Endereco endereco = cadastraEndereco();
        
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
        
        Veiculo veiculo = new Veiculo(nomeVeiculo,modelo,placa,chassi,ano,cor);
        Motorista motorista = new Motorista(nome,cpf,endereco,veiculo);
 
        if(motorista.getVeiculo().getAnoFabricacao()<2016){
            motorista.setDisponivel(false);
            
        }
        else{
            motorista.setDisponivel(true);
        }
        this.motoristas.add(motorista);
        
}
    
    public void listarMotorista(){
        
        System.out.println("=== MOTORISTAS CADASTRADOS ===");
        
        if(this.motoristas.isEmpty())
        {
            System.out.println("Nenhum Motorista Cadastrado");
            menuMotorista();
        }
        else{
        
            for(Motorista motorista: this.motoristas){
            
                System.out.println("Motorias: "+motorista.getNome() + " CPF: " + motorista.getCpf());
            
            }
        }
         
    }
    public void procurarMotorista(){
        
        System.out.println("=== DADOS DO MOTORISTA ===");
        System.out.print("Digite o CPF do Motorista: ");
        String cpfMotorista = teclado.nextLine();
        
        for(Motorista motorista: this.motoristas){
            if(motorista.getCpf().equals(cpfMotorista)){
                exibirMotorista(motorista);
            }
            
        }
        
    }
    public void exibirMotorista(Motorista motorista){
        
        System.out.println("=== DADOS DO MOTORISTA ===");
        System.out.println("Motoritas: "+motorista.getNome() + " CPF: " + motorista.getCpf());
        System.out.println("");
        System.out.println("--- Dados do Veiculo --- ");
        System.out.println("Veiculo: " + motorista.getVeiculo().getNome() + " Modelo: "+ motorista.getVeiculo().getmodelo() + " Placa: " + motorista.getVeiculo().getPlaca());
        System.out.println("Chassi: "+ motorista.getVeiculo().getChassi()+ " Ano: "+ motorista.getVeiculo().getAnoFabricacao() + " Cor: "+ motorista.getVeiculo().getCor());
        
        
    }
    
    private void menuPassageiro(){
        int opcao = 1;
        
        while(opcao!=0){
            System.out.println("\n=== MENU PASSAGEIRO ===");
            System.out.println("1. Cadastrar Passageiro");
            System.out.println("2. Listar Passageiro");
            System.out.println("3. Procurar Passageiro");
            System.out.println("4. voltar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(teclado.nextLine());
            
            switch(opcao){
            case 1 -> cadastrarPassageiro();
            case 2 -> listarPassageiro();
            case 3 -> procurarPassageiro();
            //case 4 -> exibirMenuPrincipal();
            case 0 -> System.out.println("Saindo...");
            
            }
        }
    }
    
    private void cadastrarPassageiro(){
        //PESSOA
        System.out.println("--- Cadastro de Motorista ---");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("CPF: ");
        String cpf = teclado.nextLine();
        
        //ENDERECO
       Endereco endereco =  cadastraEndereco();
       Passageiro passageiro = new Passageiro(nome,cpf,endereco);
       
       this.passageiros.add(passageiro);
        
        
        
    }
    
    public void listarPassageiro(){
        
        System.out.println("=== PASSAGEIROS CADASTRADOS ===");
        
        if(this.passageiros.isEmpty())
        {
            System.out.println("Nenhum Passageiro Cadastrado");
            menuPassageiro();
        }
        else{
        
            for(Passageiro passageiro: this.passageiros){
            
                System.out.println("Passageiro: "+passageiro.getNome() + " CPF: " + passageiro.getCpf());
            
            }
        }
         
    }
    
    private void procurarPassageiro(){
        
        System.out.println("=== DADOS DO PASSAGEIRO ===");
        System.out.print("Digite o CPF do Passageiro: ");
        String cpfPassageiro = teclado.nextLine();
        
        for(Passageiro passageiro: this.passageiros){
            if(passageiro.getCpf().equals(cpfPassageiro)){
                exibirPassageiro(passageiro);
            }
            
        }
        
    }
    public void exibirPassageiro(Passageiro passageiro){
        
        System.out.println("=== DADOS DO MOTORISTA ===");
        System.out.println("Motoritas: "+passageiro.getNome() + " CPF: " + passageiro.getCpf());
        System.out.println("---- Endereco ---");
        
        Endereco endereco = passageiro.getEndereco();
        
       String enderecoString = endereco.getTipoLogradouro() + " " + endereco.getNomeLogradouro() + " ,"+ endereco.getNumero() +" " + endereco.getBairro() + " " + endereco.getCidade() + " " + endereco.getPais() + " " + endereco.getCep();
       
        System.out.println(enderecoString);
        
        
    }
   
    
    
    
}
