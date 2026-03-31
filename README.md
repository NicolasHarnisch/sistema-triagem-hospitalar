# Hospital Triage System (Sistema de Triagem Hospitalar)

> **Language switch**: [English version](README.md) • [Português](README_pt.md)

<div style="display: inline-block; margin-bottom: 15px;">
  <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white" alt="Swing" />
  <img src="https://img.shields.io/badge/JUnit-9b0000?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
  <img src="https://img.shields.io/badge/GitHub-A5A5A5?style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />
</div>

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Core Features](#core-features)
- [Triage Rules](#triage-rules)
- [UI Screenshots](#ui-screenshots)
- [Setup](#setup)
- [Run](#run)
- [Testing](#testing)
- [Data Persistence](#data-persistence)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## 🎯 Overview

Hospital Triage System is a desktop emergency room triage simulator built with Java and Swing. It is designed to capture patient data, validate vital signs, classify risk levels automatically, and manage a priority queue for service order.

Key objectives:
- Simulate real-world hospital triage flow
- Emphasize Object-Oriented Design (POO) and MVC architecture
- Guarantee persistence by evolving state across restarts via `pacientes.txt`
- Provide unit-tested reliability with JUnit 5

---

## 🏗️ Architecture

The project follows MVC pattern:

- **Model**: `Pessoa`, `Paciente`, `Enfermeiro`, `SinaisVitais`
- **Service**: `Classificar`, `Triagem`, `FilaAtendimento`
- **View**: `TelaPrincipal` Swing GUI
- **Data**: `GerenciadorArquivos` for persistence

### Workflow

1. User registers a patient via form
2. Patient vitals are validated and classified by `Triagem`
3. `FilaAtendimento` orders patients by priority
4. Queue state is saved in `pacientes.txt`

---

## 🛠️ Technologies

- Java 17+
- Swing
- JUnit 5
- Maven

---

## 📁 Project Structure

```
src/
  dados/
    GerenciadorArquivos.java
  excecoes/
    DadoInvalidoException.java
  modelo/
    Pessoa.java
    Paciente.java
    Enfermeiro.java
    SinaisVitais.java
  servico/
    Classificar.java
    Triagem.java
    FilaAtendimento.java
  visao/
    TelaPrincipal.java
  testes/
    TriagemTest.java
    FilaAtendimentoTest.java
    PacienteTest.java
pacientes.txt
README.md
README_pt.md
assets/
  0.jpg
  1.jpg
  2.jpg
  3.jpg
  5.png
  6.jpg
```

---

## ✅ Core Features

- Patient registration (name, CPF, SUS card, symptoms, vitals)
- Vital-sign validation in `SinaisVitais`
- Automatic classification in `Triagem` to color + priority
- Priority queue in `FilaAtendimento` with load/save
- Responsive UI with validation feedback

---

## 🚦 Triage Rules

Color mapping:
- Vermelho (1) - Emergency
- Laranja (2) - High
- Amarelo (3) - Moderate
- Verde (4) - Low
- Azul (5) - Minimal

Input ranges checked:
- `batimentos` (heart rate)
- `temperatura`
- `oxigenacao`
- `dor`

---

## 🧩 UI Screenshots

### Registration
![Tela de Cadastro](assets/2.jpg)

### Classification result
![Resultado da Classificação](assets/3.jpg)

### Waiting queue
![Fila de Espera](assets/6.jpg)

### UML Diagram
![Diagrama UML](assets/0.jpg)

### Data persistence sample
![Arquivo de Texto](assets/5.png)

### Tests evidence
![Evidência de Testes](assets/1.jpg)

---

## ⚙️ Setup

### Requirements

- Java 17+
- Maven 3.8+

### Install

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd "Sistema de Triagem Hospitalar"
mvn clean install
```

---

## ▶️ Run

```bash
mvn exec:java -Dexec.mainClass="visao.TelaPrincipal"
```

or open project in IDE and run `visao.TelaPrincipal`.

---

## 🧪 Testing

```bash
mvn test
```

- `TriagemTest`: classification cases
- `FilaAtendimentoTest`: queue behavior & persistence
- `PacienteTest`: model validation

---

## 💾 Data Persistence

`pacientes.txt` is persisted with `;` separators.

Format:
`nome;cpf;sus;batimentos;temperatura;oxigenacao;dor;cor;prioridade`

Example:
`João.;11111111111;8888888888;110;38.2;92;4;Laranja;2`

---

## 🚀 Future Improvements

- Migrate GUI to JavaFX or web frontend
- DB persistence (SQLite/PostgreSQL)
- Authentication & authorization
- REST API layer for distributed use
- Mobile-friendly front end

---

## 👨‍💻 Author

**Nícolas Harnisch**

- GitHub: https://github.com/NicolasHarnisch
- LinkedIn: https://linkedin.com/in/nicolasharnisch
- Email: nicolasgomeshar@gmail.com
