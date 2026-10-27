# Padrão Mediator

Projeto desenvolvido para demonstrar a utilização do padrão de projeto **Mediator** em Java.

## 📌 Sobre o projeto

O projeto simula uma **estufa automatizada**. Sensores informam à central as medições de umidade e temperatura, e a central decide quando ligar ou desligar os equipamentos:

- **Irrigador:** ligado quando a umidade está abaixo de 40%.
- **Ventilador:** ligado quando a temperatura está acima de 30 °C.

A partir de 40% de umidade, o irrigador é desligado. Com temperatura igual ou inferior a 30 °C, o ventilador é desligado. As regras são simplificadas para fins didáticos.

## 🧩 Padrão Mediator

O **Mediator** é um padrão comportamental que centraliza a comunicação e a coordenação entre objetos, reduzindo a necessidade de eles conhecerem uns aos outros diretamente.

Neste projeto, a interface `MediadorEstufa` define os métodos para receber as medições. A classe `CentralEstufa` implementa essa interface e coordena o irrigador e o ventilador.

As classes `SensorUmidade` e `SensorTemperatura` comunicam as medições ao mediador, sem conhecer diretamente os equipamentos:

```java
MediadorEstufa central = new CentralEstufa(irrigador, ventilador);
SensorUmidade umidade = new SensorUmidade(central);
SensorTemperatura temperatura = new SensorTemperatura(central);

umidade.medir(35);       // Liga o irrigador.
temperatura.medir(32);   // Liga o ventilador.
```

## 📁 Estrutura do projeto

```text
Mediator_Estufa/
├── src/
│   ├── main/java/
│   │   ├── Aplicacao.java
│   │   ├── MediadorEstufa.java
│   │   ├── CentralEstufa.java
│   │   ├── SensorUmidade.java
│   │   ├── SensorTemperatura.java
│   │   ├── Irrigador.java
│   │   └── Ventilador.java
│   └── test/java/
│       └── CentralEstufaTest.java
├── diagrama-classes.png
├── pom.xml
└── README.md
```

## ⚙️ Funcionamento

A classe `Aplicacao` cria a central, os sensores e os equipamentos. Em seguida, envia as medições de exemplo:

| Medição | Condição | Resultado |
| --- | --- | --- |
| Umidade: 35% | Abaixo de 40% | Irrigador ligado |
| Temperatura: 32 °C | Acima de 30 °C | Ventilador ligado |

### Validação dos dados

A umidade deve estar entre **0 e 100**, inclusive. Se o valor estiver fora desse intervalo, o sensor lança uma `IllegalArgumentException` e a medição não altera o estado do irrigador.

## ▶️ Executando a aplicação

Com o **JDK 11 ou superior** e o **Maven** instalados, execute na pasta que contém o `pom.xml`:

```bash
mvn compile
java -cp target/classes Aplicacao
```

A saída esperada é:

```text
Irrigador ligado: true
Ventilador ligado: true
```

## 🏗️ Estrutura do Mediator

| Elemento do padrão | Implementação |
| --- | --- |
| Mediator — interface de comunicação | `MediadorEstufa` |
| Concrete Mediator — coordena os equipamentos | `CentralEstufa` |
| Componentes que informam medições | `SensorUmidade` e `SensorTemperatura` |
| Equipamentos controlados pela central | `Irrigador` e `Ventilador` |
| Cliente — demonstração | `Aplicacao` |

## 🧪 Testes

O projeto utiliza **JUnit 5**. A classe `CentralEstufaTest` verifica o acionamento e o desligamento dos equipamentos, os valores nos limites, a independência entre os equipamentos e a rejeição de umidade inválida.

Para executar os testes:

```bash
mvn test
```

O Maven pode precisar de acesso à internet para baixar as dependências na primeira execução.

## 📊 Diagrama de classes

O arquivo [diagrama-classes.png](diagrama-classes.png) apresenta as principais classes, a interface e as relações entre elas.

## 🛠️ Tecnologias utilizadas

- Java 11
- Maven
- JUnit 5.5.2
- Padrão de Projeto Mediator

## 🎯 Objetivo

Demonstrar como centralizar a comunicação e a coordenação entre componentes, permitindo que sensores enviem medições sem depender diretamente dos equipamentos controlados.

## 👨‍💻 Autor

**Felipe Baba**

Projeto desenvolvido para fins acadêmicos, como aplicação prática do padrão de projeto Mediator.
