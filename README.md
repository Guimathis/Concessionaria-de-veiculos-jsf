
<h1 align="center" style="font-weight: bold;">Concessionária de Veiculos 💻</h1>
<p align="center">
  <b>Consiste em uma pagina web criada utilizando JAVA e Java Server Pages. Que permite o cadastro de veículos e clientes e a criação de vendas relacionando um cliente a um ou mais veículos. Projeto criado na matéria de linguagem de programação 3, com professor Joinville Batista Junior</b>
</p>


## 🚀 Getting Started

## Arquitetura Geral
A arquitetura adotada é uma arquitetura em camadas baseada no Modelo-Visão-Controlador (MVC), implementada com as seguintes principais camadas:

- **Camada de Apresentação (Frontend):**
  - Desenvolvida com Java Server Faces (JSF) utilizando páginas XHTML.
  - Responsável pela interface com o usuário, apresentando formulários, tabelas e componentes gráficos.
  - Utiliza componentes visuais que simplificam a criação de interfaces dinâmicas e responsivas.
  - Separa a lógica da apresentação do processamento de negócios, promovendo uma interface desacoplada.

- **Camada de Negócio (Controle):**
  - Implementada via Beans gerenciados pelo CDI (Contexts and Dependency Injection) e EJB (Enterprise JavaBeans).
  - Encapsula a lógica de negócio, validações, e gerenciamento de entidades.
  - Atua como controladores que interagem entre a interface e a camada de persistência.

- **Camada de Persistência (Modelo):**
  - Utiliza JPA (Java Persistence API) para mapeamento objeto-relacional.
  - Gerencia entidades que representam tabelas do banco MySQL.
  - Automatiza a execução de comandos SQL, proporcionando uma manipulação transparente dos dados.

- **Infraestrutura e Servidores:**
  - A aplicação é hospedada em um servidor WildFly, que fornece o ambiente de execução para EJBs, CDI, JSF e JPA.
  - O banco de dados MySQL armazena todas as informações de clientes, veículos e vendas, acessado através do JPA.

## Tecnologias e Ferramentas
- **Frontend:**
  - XHTML
  - JavaServer Faces (JSF)
  - CSS para estilização

- **Backend:**
  - Java SE 24
  - Java EE 8 (com foco em JSF, EJB, CDI, JPA)

- **Banco de Dados:**
  - MySQL

- **Servidores e Ferramentas:**
  - WildFly Application Server
  - Apache NetBeans IDE

## Fluxo de Dados e Interações
O fluxo típico de operações inicia na interface do usuário em JSF, que dispara ações controladas por seus Beans. Estes Beans, que servem como controladores, interagem com a camada de entidades e repositórios gerenciados pelo JPA para persistir ou recuperar dados do banco MySQL. A comunicação entre as camadas é feita de forma desacoplada, promovendo manutenção e evolução facilitadas.

## Screenshots 

  - **Cadastro de Clientes**:
  - ![image](https://github.com/user-attachments/assets/ff172b20-46ae-4aab-a40f-fd1b44efa46e)

  - **Cadastro de Veiculos**:
  - ![image](https://github.com/user-attachments/assets/d2a83fe5-1518-4422-bfd5-dc96cfbe7c36)

  - **Cadastro de Vendas**:
  - ![image](https://github.com/user-attachments/assets/49f65b1e-ef5f-418e-bbd1-5ea734819047)





