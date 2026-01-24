# Sistema de Triagem Hospitalar

Projeto final desenvolvido para a disciplina de **Programação Orientada a Objetos** do curso de Ciência da Computação da **Universidade Federal do Ceará (UFC - Campus Russas)**.

## 📋 Sobre o Projeto

Este sistema simula o processo de triagem em uma unidade de emergência hospitalar. O objetivo é classificar pacientes com base na gravidade de seus sintomas (sinais vitais) e organizar o atendimento utilizando uma **Fila de Prioridade**, garantindo que os casos mais graves sejam atendidos primeiro, independentemente da ordem de chegada.

O sistema implementa conceitos fundamentais de POO e utiliza persistência de dados em arquivos.

## 🚀 Funcionalidades

* **Cadastro de Pacientes:** Registro de nome, CPF, cartão SUS e sintomas.
* **Classificação de Risco:** Algoritmo automático que analisa sinais vitais (batimentos, temperatura, oxigenação, dor) para definir a prioridade (Cores: Vermelho, Laranja, Amarelo, Verde, Azul).
* **Fila de Prioridade:** Gerenciamento inteligente da lista de espera.
* **Interface Gráfica (GUI):** Interface amigável desenvolvida com Java Swing.
* **Persistência:** Salvamento automático dos dados em arquivo (`pacientes.txt`) para manter o histórico entre execuções.

## 🛠️ Tecnologias Utilizadas

* **Java** (Linguagem base)
* **Swing** (Interface Gráfica)
* **JUnit 5** (Testes Unitários)
* **MVC** (Arquitetura Model-View-Controller)

## 🏗️ Arquitetura do Projeto

O sistema segue o padrão de arquitetura **MVC** adaptado:

### 1. Modelo (Model)
Responsável pela representação dos objetos do domínio.
* `Pessoa` (Classe Abstrata), `Paciente`, `Enfermeiro`.
* `SinaisVitais`: Agrupa dados de saúde para classificação.

### 2. Serviço (Controller/Business Logic)
Contém a lógica pesada do sistema.
* `Triagem`: Implementa a interface `Classificar` para definir a cor/prioridade.
* `FilaAtendimento`: Gerencia a prioridade dos pacientes.

### 3. Visão (View)
* `TelaPrincipal`: Interface gráfica para interação com o usuário.

### 4. Dados (Persistence)
* `GerenciadorArquivos`: Manipula a leitura e escrita no arquivo `pacientes.txt`.

---

## 📊 Modelagem (UML)

Diagrama de classes detalhando os relacionamentos e heranças do sistema:

![Diagrama UML](assets/0.jpg)

---

## 🖥️ Telas do Sistema

### 1. Cadastro e Preenchimento
O enfermeiro insere os dados e os sinais vitais do paciente.

![Tela de Cadastro](assets/2.jpg)

### 2. Classificação Automática
O sistema calcula o risco com base nos dados e exibe a prioridade (ex: Vermelho/Emergência).

![Resultado da Classificação](assets/3.jpg)

### 3. Fila de Espera
Os pacientes são ordenados automaticamente na lista lateral de acordo com a gravidade.

![Fila de Espera](assets/6.jpg)

---

## 💾 Persistência de Dados

Os dados são salvos automaticamente em arquivo físico (`pacientes.txt`) para não serem perdidos.

![Arquivo de Texto](assets/5.png)

---

## ✅ Testes Automatizados

Foram implementados testes unitários com **JUnit 5** para garantir a robustez das regras de negócio (Classificação e Fila):

![Evidência de Testes](assets/1.jpg)

