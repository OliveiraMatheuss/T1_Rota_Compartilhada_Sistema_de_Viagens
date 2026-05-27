/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.rotacompartilhada.main;

import br.ufjf.dcc.rotacompartilhada.model.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

/**
 *
 * @author 55329
 */
public class Menu {

    private List<Motorista> motoristas = new ArrayList<>();
    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Carona> caronas = new ArrayList<>();
    private Scanner teclado = new Scanner(System.in);

    //SOMENTE PARA TESTE, APAGAR DEPOIS
    public void setMotoristaTeste() {
        Motorista motorista = new Motorista();
        this.motoristas.add(motorista);
    }

    public void exibirMenuPrincipal() {
        int opcao = 1;

        while (opcao != 0) {
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

    private void processarOpcao(int opcao) {

        switch (opcao) {
            case 1 ->
                menuMotorista();
            case 2 ->
                menuPassageiro();
            case 3 ->
                menuCarona();
            case 0 ->
                System.out.println("Saindo...");

        }
    }

    // MOTORISTA
    public void menuMotorista() {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("\n=== MENU MOTORISTA ===");
            System.out.println("1. Cadastrar Motorista");
            System.out.println("2. Listar Motoristas");
            System.out.println("3. Procurar Motorista");
            System.out.println("4. Editar Motorista");
            System.out.println("5. Excluir Motorista");
            System.out.println("0. voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1 ->
                    cadastrarMotorista();
                case 2 ->
                    listarMotorista();
                case 3 ->
                    procurarMotorista();
                case 4 ->
                    menuEditarMotorista();
                case 5 ->
                    menuExcluirMotorista();
                case 0 ->
                    exibirMenuPrincipal();

            }
        }
    }

    public Endereco cadastraEndereco() {

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

        Endereco endereco = new Endereco(tipo, nomeLogradouro, numero, bairro, cidade, estado, pais, cep);
        return endereco;
    }

    public void cadastrarMotorista() {

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

        Veiculo veiculo = new Veiculo(nomeVeiculo, modelo, placa, chassi, ano, cor);
        Motorista motorista = new Motorista(nome, cpf, endereco, veiculo);

        if (motorista.getVeiculo().getAnoFabricacao() < 2016) {
            motorista.setDisponivel(false);

        } else {
            motorista.setDisponivel(true);
        }
        this.motoristas.add(motorista);

    }

    public void listarMotorista() {

        System.out.println("=== MOTORISTAS CADASTRADOS ===");

        if (this.motoristas.isEmpty()) {
            System.out.println("Nenhum Motorista Cadastrado");
            return;
        }

        for (Motorista motorista : this.motoristas) {
            System.out.println("Motorias: " + motorista.getNome() + " CPF: " + motorista.getCpf());
        }

    }

    public void procurarMotorista() {

        System.out.println("=== DADOS DO MOTORISTA ===");
        System.out.print("Digite o CPF do Motorista: ");
        String cpfMotorista = teclado.nextLine();

        for (Motorista motorista : this.motoristas) {
            if (motorista.getCpf().equals(cpfMotorista)) {
                exibirMotorista(motorista);
            }

        }

    }

    public void exibirMotorista(Motorista motorista) {

        System.out.println("=== DADOS DO MOTORISTA ===");
        System.out.println("Motoritas: " + motorista.getNome() + " CPF: " + motorista.getCpf());
        System.out.println("");
        System.out.println("--- Dados do Veiculo --- ");
        System.out.println("Veiculo: " + motorista.getVeiculo().getNome() + " Modelo: " + motorista.getVeiculo().getmodelo() + " Placa: " + motorista.getVeiculo().getPlaca());
        System.out.println("Chassi: " + motorista.getVeiculo().getChassi() + " Ano: " + motorista.getVeiculo().getAnoFabricacao() + " Cor: " + motorista.getVeiculo().getCor());

    }

    private void menuEditarMotorista() {

        System.out.println("=== EDITAR MOTORISTA ===");
        System.out.print("Digite o Cpf do Motorista: ");
        String cpfMotorista = teclado.nextLine();

        for (Motorista motorista : this.motoristas) {

            if (motorista.getCpf().equals(cpfMotorista)) {
                editarMotorista(motorista);
            }
        }
    }

    private void editarMotorista(Motorista motorista) {

        int opcao = 1;
        while (opcao != 0) {
            System.out.println("1. Nome");
            System.out.println("2. Cpf");
            System.out.println("3. Endereco");
            System.out.println("4. Veiculo");
            System.out.println("5. Disponibilidade");
            System.out.println("0. Voltar");
            System.out.print("Escolha o Campo para Editar: ");
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = teclado.nextLine();
                    motorista.setNome(novoNome);
                    break;

                case 2:
                    System.out.println("Digite o novo Cpf: ");
                    String novoCpf = teclado.nextLine();
                    motorista.setCpf(novoCpf);
                    break;

                case 3:
                    System.out.println("Edite o novo Endereco: ");
                    Endereco endereco = cadastraEndereco();
                    motorista.setEndereco(endereco);
                    break;

                case 4:
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

                    Veiculo veiculo = new Veiculo(nomeVeiculo, modelo, placa, chassi, ano, cor);
                    motorista.setVeiculo(veiculo);
                    break;

                case 5:
                    System.out.print("Digite 0 para indisponivel e 1 disponivel");
                    int opc = Integer.parseInt(teclado.nextLine());
                    if (opc == 1) {
                        motorista.setDisponivel(true);
                    } else if (opc == 0) {
                        motorista.setDisponivel(false);
                    } else {
                        System.out.println("Opção Invalida:");

                    }
                    break;
                case 0:
                    menuMotorista();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;

            }
        }

    }

    private void menuExcluirMotorista() {

        System.out.println("=== EXCLUIR MOTORISTA ===");
        System.out.print("Digite o Cpf do Motorista: ");
        String cpfMotorista = teclado.nextLine();

        for (Motorista motorista : this.motoristas) {

            if (motorista.getCpf().equals(cpfMotorista)) {
                excluirMotorista(motorista);
                break;
            }
        }
    }

    private void excluirMotorista(Motorista motorista) {
        System.out.println("Você irá remover este motorista: " + motorista.getNome() + " CPF: " + motorista.getCpf());
        System.out.println("Tem certeza? ");
        System.out.println("Digite 1 para Sim e 2 para Não");

        int confirmacao = Integer.parseInt(teclado.nextLine());

        if (confirmacao == 1) {
            motoristas.remove(motorista);
            System.out.println("Motorista removido com sucesso!");
        } else {
            System.out.println("Operação cancelada. Voltando...");

        }

    }

    // PASSAGEIRO
    private void menuPassageiro() {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("\n=== MENU PASSAGEIRO ===");
            System.out.println("1. Cadastrar Passageiro");
            System.out.println("2. Listar Passageiro");
            System.out.println("3. Procurar Passageiro");
            System.out.println("4. Editar Passageiro");
            System.out.println("5. Excluir Passageiro");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1 ->
                    cadastrarPassageiro();

                case 2 ->
                    listarPassageiro();

                case 3 ->
                    procurarPassageiro();

                case 4 ->
                    menuEditarPassageiro();

                case 5 ->
                    menuExcluirPassageiro();

                case 0 ->
                    System.out.println("Saindo...");

            }
        }
    }

    private void cadastrarPassageiro() {
        //PESSOA
        System.out.println("=== CADASTRO DE PASSAGEIRO ===");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("CPF: ");
        String cpf = teclado.nextLine();

        //ENDERECO
        Endereco endereco = cadastraEndereco();
        Passageiro passageiro = new Passageiro(nome, cpf, endereco);

        this.passageiros.add(passageiro);

    }

    public void listarPassageiro() {

        System.out.println("=== PASSAGEIROS CADASTRADOS ===");

        if (this.passageiros.isEmpty()) {
            System.out.println("Nenhum Passageiro Cadastrado");
            return;
        }

        for (Passageiro passageiro : this.passageiros) {

            System.out.println("Passageiro: " + passageiro.getNome() + " CPF: " + passageiro.getCpf());

        }

    }

    private void procurarPassageiro() {

        System.out.println("=== DADOS DO PASSAGEIRO ===");
        System.out.print("Digite o CPF do Passageiro: ");
        String cpfPassageiro = teclado.nextLine();

        for (Passageiro passageiro : this.passageiros) {
            if (passageiro.getCpf().equals(cpfPassageiro)) {
                exibirPassageiro(passageiro);
            }

        }

    }

    public void exibirPassageiro(Passageiro passageiro) {

        System.out.println("=== DADOS DO PASSAGEIRO ===");
        System.out.println("Passageiro: " + passageiro.getNome() + " CPF: " + passageiro.getCpf());
        System.out.println("---- Endereco ---");

        Endereco endereco = passageiro.getEndereco();

        String enderecoString = endereco.getTipoLogradouro() + " " + endereco.getNomeLogradouro() + " ," + endereco.getNumero() + " " + endereco.getBairro() + " " + endereco.getCidade() + " " + endereco.getPais() + " " + endereco.getCep();

        System.out.println(enderecoString);

    }

    private void menuEditarPassageiro() {

        System.out.println("=== EDITAR Passageiro ===");
        System.out.print("Digite o Cpf do Passageiro: ");
        String cpfPassageiro = teclado.nextLine();

        for (Passageiro passageiro : this.passageiros) {

            if (passageiro.getCpf().equals(cpfPassageiro)) {
                editarPassageiro(passageiro);
            }
        }
    }

    private void editarPassageiro(Passageiro passageiro) {

        int opcao = 1;
        while (opcao != 0) {
            System.out.println("1. Nome");
            System.out.println("2. Cpf");
            System.out.println("3. Endereco");
            System.out.println("0. Voltar");
            System.out.print("Escolha o Campo para Editar: ");
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = teclado.nextLine();
                    passageiro.setNome(novoNome);
                    break;

                case 2:
                    System.out.println("Digite o novo Cpf: ");
                    String novoCpf = teclado.nextLine();
                    passageiro.setCpf(novoCpf);
                    break;

                case 3:
                    System.out.println("Edite o novo Endereco: ");
                    Endereco endereco = cadastraEndereco();
                    passageiro.setEndereco(endereco);
                    break;

                case 0:
                    System.out.println("Voltando..");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;

            }
        }

    }

    private void menuExcluirPassageiro() {
        System.out.println("=== EXCLUIR PASSAGEIRO ===");
        System.out.print("Digite o Cpf do Passageiro: ");
        String cpfPassageiro = teclado.nextLine();

        for (Passageiro passageiro : this.passageiros) {

            if (passageiro.getCpf().equals(cpfPassageiro)) {
                excluirPassageiro(passageiro);
                break;
            }
        }
    }

    private void excluirPassageiro(Passageiro passageiro) {
        System.out.println("Você irá remover este passageiro: " + passageiro.getNome() + " CPF: " + passageiro.getCpf());
        System.out.println("Tem certeza? ");
        System.out.println("Digite 1 para Sim e 2 para Não");

        int confirmacao = Integer.parseInt(teclado.nextLine());

        if (confirmacao == 1) {
            passageiros.remove(passageiro);
            System.out.println("Passageiros removido com sucesso!");
        } else {
            System.out.println("Operação cancelada. Voltando...");

        }

    }

    // CARONA
    private void menuCarona() {

        int opcao = 1;

        while (opcao != 0) {
            System.out.println("=== MENU CARONA ===");
            System.out.println("1. Cadastrar Carona");
            System.out.println("2. Agendar Carona");
            System.out.println("3. Exibir Agendamento de Caronas");
            System.out.println("4. Verificar Status de Uma Carona");
            System.out.println("5. Exibir Caronas em Andamento");
            System.out.println("6. Exibir Caronas Finalizadas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCarona();
                    agendarCarona();

            }
        }
    }

    private void cadastrarCarona() {

        System.out.println("=== CADASTRAR CARONA ===");

        System.out.print("Digite o CPF do Passageiro Solicitante: ");
        String cpfPassageiro = teclado.nextLine();

        LocalDateTime inicio = LocalDateTime.now();
        criarCarona(cpfPassageiro, inicio);

    }

    private void criarCarona(String cpfPassageiro, LocalDateTime inicio) {

        Passageiro passageiroSelecionado = null;

        for (Passageiro passageiro : this.passageiros) {

            if (passageiro.getCpf().equals(cpfPassageiro)) {

                passageiroSelecionado = passageiro;
                break;
            }
        }

        if (passageiroSelecionado == null) {
            System.out.println("Passageiro não encontrado.");
        } else {

            Random geradorHoras = new Random();
            int duracao = geradorHoras.nextInt(1, 4);
            LocalDateTime fim = inicio.plusHours(duracao);

            for (Carona carona : this.caronas) {

                if (carona.getPassageiro().getCpf().equals(cpfPassageiro) && carona.conflitaCom(inicio, fim)) {
                    System.out.println("Alerta: O Passageiro já possui uma carona agendada!");
                    break;
                }
            }

            System.out.println("Digite as Informações do Endereco de Origem: ");
            Endereco origem = cadastraEndereco();

            System.out.println("Digite as Informações do Endereco Destino: ");
            Endereco destino = cadastraEndereco();

            if (origem.getNomeLogradouro().equalsIgnoreCase(destino.getNomeLogradouro())
                    && origem.getNumero() == destino.getNumero()
                    && origem.getCidade().equalsIgnoreCase(destino.getCidade())) {

                System.out.println("[ERRO] Cadastro cancelado: O endereço de origem não pode ser igual ao de destino!");
                return;
            }

            List<Motorista> motoristasSelecionados = new ArrayList<>();

            for (Motorista motorista : this.motoristas) {

                if (motorista.isDisponivel()) {

                    boolean temConflito = false;

                    for (Carona carona : this.caronas) {

                        if (carona.getMotorista().getCpf().equals(motorista.getCpf()) && carona.conflitaCom(inicio, fim)) {
                            temConflito = true;
                            break;
                        }
                    }
                    if (!temConflito) {
                        motoristasSelecionados.add(motorista);
                    }
                }
            }
            if (motoristasSelecionados.isEmpty()) {
                System.out.println("Alerta: Nenhum motorista disponivel");
                return;

            }

            Random random = new Random();
            int indiceSorteado = random.nextInt(motoristasSelecionados.size());
            Motorista motoristaSorteado = motoristasSelecionados.get(indiceSorteado);

            Carona carona = new Carona(passageiroSelecionado, motoristaSorteado, origem, destino, inicio, duracao);
            this.caronas.add(carona);
        }

    }

    public void agendarCarona() {
        System.out.println("=== AGENDAR CARONA FUTURA ===");
        System.out.print("Digite o CPF do Passageiro Solicitante: ");
        String cpfPassageiro = teclado.nextLine();
        LocalDateTime dataFutura = lerDataHora();
        criarCarona(cpfPassageiro, dataFutura);
    }

    private LocalDateTime lerDataHora() {
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            try {
                System.out.print("Digite a data e hora do agendamento (ex: 28/05/2026 14:30): ");
                String entrada = teclado.nextLine();

                LocalDateTime dataHoraDigitada = LocalDateTime.parse(entrada, formatador);

                
                if (dataHoraDigitada.isBefore(LocalDateTime.now())) {
                    System.out.println("[ERRO] A data e hora do agendamento devem ser no futuro!");
                    continue;
                }

                return dataHoraDigitada;

            } catch (DateTimeParseException e) {
                System.out.println("[ERRO] Formato inválido! Use o padrão nacional: dd/MM/yyyy HH:mm");
            }
        }
    }

}
