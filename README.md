# 📘 WorldTalk – Sistema de Gestão de Escola de Idiomas

Sistema desenvolvido para a disciplina de Programação Orientada a Objetos. O objetivo é modelar e implementar uma escola de idiomas com foco em organização, POO, persistência em arquivos e tratamento de erros.

---

## 📌 Funcionalidades Implementadas

### **1. Cadastro**

* Cadastro de **cursos** (inglês, espanhol, francês etc.).
* Cadastro de **alunos** (VIP e regular).
* Cadastro de **níveis**: básico, intermediário, avançado.
* Cadastro de professores e informações básicas.

### **2. Turmas e Horários**

* Criação de turmas associadas a cursos e professores.
* Limite de alunos por turma.
* Prioridade de matrícula para alunos VIP.

### **3. Aulas Particulares**

* Agendamento exclusivo para alunos VIP.
* Cancelamento com taxa de **50%** quando faltarem menos de **24 horas**.

### **4. Biblioteca Virtual**

* Empréstimo e devolução de materiais.
* Controle de acesso (materiais exclusivos para VIP).
* Registro simples de histórico.

### **5. Pagamentos e Histórico**

* Registro de pagamentos.
* Histórico básico de cursos concluídos, níveis e notas.

### **6. Persistência**

* Persistência de dados em arquivos `.txt` sem dependências externas.
* Arquivos são gerados automaticamente na pasta `data/`.

---

## 🖥️ Como Executar

### **Requisitos**

* Java 17+
* Qualquer IDE Java (VS Code, IntelliJ, Eclipse) ou terminal

### **Passos**

1. Clone ou baixe o projeto:

   ```
   git clone <url-do-repositorio>
   ```
2. Abra na IDE ou compile pelo terminal.
3. Execute a classe:

   ```
   Main.java
   ```
4. Use o menu simples do console para cadastrar cursos, alunos, registrar agendamentos, empréstimos etc.

---

## 🗂️ Estrutura do Projeto

```
src/
 ├─ Agendamento.java
 ├─ AgendamentoServico.java
 ├─ Aluno.java
 ├─ Biblioteca.java
 ├─ CadastroCursos.java
 ├─ Curso.java
 ├─ CursoConcluido.java
 ├─ Emprestimo.java
 ├─ FormatadorHistorico.java
 ├─ Horario.java
 ├─ Level.java
 ├─ Main.java
 ├─ MainBiblioteca.java
 ├─ Material.java
 ├─ MenuConsole.java
 ├─ Pagamento.java
 ├─ PersistenceUtil.java
 ├─ Pessoa.java
 ├─ Professor.java
 ├─ Progresso.java
 ├─ ResultadoCancelamento.java
 ├─ TempoRestante.java
 └─ Turma.java
```

---

## ⚙️ Princípios de POO Aplicados

* **Encapsulamento:** classes isolam seus dados e expõem apenas o necessário.
* **Abstração:** serviços (ex.: agendamento, biblioteca) concentram regras de negócio.
* **Polimorfismo:** regras diferentes entre alunos VIP e regulares.
* **Modularidade:** separação clara entre modelos, serviços e utilitários.

---

## ⚠️ Tratamento de Erros

Inclui tratamento para:

* Entradas inválidas no menu.
* Arquivos inexistentes (criação automática).
* Listas vazias.
* Operações ilegais (ex.: aluno regular tentando reserva VIP).
* Estouro de limite de turmas.

O sistema nunca encerra abruptamente, sempre retorna mensagens claras ao usuário.

---

## 🧾 Relatório Final (Resumo)

Um relatório final acompanha o projeto e inclui:

* Funcionalidades concluídas
* Arquitetura do sistema
* Justificativa das decisões
* Dificuldades enfrentadas
* Referências

---

## 👤 Grupo

**Samuel Rodrigues |**
**Danilo Campos |**
**João Paulo |**
**Absalão Neto**

---