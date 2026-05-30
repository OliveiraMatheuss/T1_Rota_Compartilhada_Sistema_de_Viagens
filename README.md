# Rota Compartilhada 🚗💨

O **Rota Compartilhada** é um sistema de gerenciamento de caronas urbanas desenvolvido em Java. O projeto simula a lógica de negócio por trás de aplicativos de transporte individual e coletivo, permitindo o cadastro de motoristas, passageiros, veículos e o agendamento/gerenciamento inteligente de viagens, evitando conflitos de horários.

Este projeto foi desenvolvido como parte dos estudos práticos de **Programação Orientada a Objetos (POO)** na Universidade Federal de Juiz de Fora (UFJF).

---

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java 17 (ou superior)
* **Paradigma:** Programação Orientada a Objetos (POO)
* **Manipulação de Arquivos:** Persistência inicial baseada na leitura de arquivos estruturados (`.csv`).
* **API de Data/Hora:** Uso intensivo do `java.time.LocalDateTime` para controle preciso e cálculos de tempo de viagens.

---

## 🏗️ Arquitetura e Engenharia de Software (POO)

O sistema foi modelado seguindo rigorosamente os princípios de POO para garantir a manutenibilidade, reutilização e legibilidade do código.

### 1. Abstração e Herança
A classe `Pessoa` foi definida como **abstrata** (`abstract class`), pois serve puramente como base conceitual para o sistema. Dela derivam-se as especializações concretas:
* `Motorista`: Estende `Pessoa` agregando um `Veiculo` e seu status de disponibilidade.
* `Passageiro`: Estende `Pessoa` aproveitando a herança de atributos comuns como Nome, CPF e Endereço.

### 2. Encapsulamento e Validação de Estados
Os atributos críticos das entidades são estritamente privados (`private`) e controlados através de métodos acessores/modificadores inteligentes. Exemplos de validações de regras de negócio em tempo de execução:
* **Validação de Endereço:** A classe `Endereco` possui uma lista estática e imutável de logradouros permitidos (`Rua`, `Avenida`, etc.). Qualquer tentativa de instanciar ou modificar um endereço fora deste padrão gera um erro controlado.
* **Consistência de Veículos:** A classe `Veiculo` impede o cadastro de carros com ano de fabricação futuro ao limite do sistema (2026), lançando uma `IllegalArgumentException`.

### 3. Associação e Agregação
* **Agregação:** A classe controlador principal `Menu` possui listas (`List<>`) que agregam instâncias de `Motorista`, `Passageiro` e `Carona`.
* **Composição/Associação:** Uma `Carona` associa de maneira única um `Passageiro`, um `Motorista`, e dois objetos distintos da classe `Endereco` (Origem e Destino).

---

## 🧭 Lógica de Negócio Destacada

### Verificação de Conflitos de Horário
Um dos maiores desafios em sistemas de agendamento é garantir que uma entidade não esteja em dois locais ao mesmo tempo. O sistema implementa uma validação matemática de intervalos de tempo na classe `Carona`:

```java
public boolean conflitaCom(LocalDateTime inicioOutra, LocalDateTime fimOutra) {
    return this.dataHoraInicio.isBefore(fimOutra) && this.dataHoraFim.isAfter(inicioOutra);
}
