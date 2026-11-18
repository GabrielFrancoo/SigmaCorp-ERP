# SigmaCorp ERP

Protótipo desktop em Java para estudar como um ERP organiza rotinas empresariais. Inspirado no TOTVS Protheus, o projeto explora a navegação entre módulos e usa o cadastro de produtos para praticar a integração entre uma interface gráfica e um banco de dados.

**Status:** projeto pessoal em desenvolvimento.

## O que o protótipo contém

| Área | Estado atual |
| --- | --- |
| Tela inicial e login | Interface Swing com menu de módulos e uma tela de login para o protótipo. |
| Cadastro e consulta de produtos | Formulário de cadastro e tela de listagem. O código usa JDBC para inserir e consultar produtos no MySQL. |
| Apontamento de produção e horas | Janelas iniciais acessíveis pelo menu, com os fluxos de registro ainda por implementar. |

## Como abrir a tela inicial

Use um ambiente gráfico com **JDK 11 ou superior** e **Maven**. Na raiz do repositório:

```bash
mvn clean compile
java -cp target/classes main.view.Inicial
```

O comando abre diretamente o menu principal. Para abrir a tela de login, execute `java -cp target/classes main.view.Logon` a partir do mesmo diretório.

As telas de cadastro e consulta dependem de um MySQL local, do driver MySQL Connector/J no classpath e da tabela esperada pelo [DAO de produtos](src/main/java/main/controller/CadastraProdutoDAO.java). O repositório ainda não inclui um script SQL para criar o esquema. O [pom.xml](pom.xml) declara o driver e configura `mvn exec:java` para executar o teste de conexão.

## Estrutura do código

| Pasta | Responsabilidade |
| --- | --- |
| [`view`](src/main/java/main/view) | Telas Swing e ações da interface. |
| [`model`](src/main/java/main/model) | Modelo de produto, conexão JDBC e teste de conexão. |
| [`controller`](src/main/java/main/controller) | DAO que salva e lista produtos no MySQL. |

## Próximas etapas

- Documentar a configuração do banco local e adicionar um script para criar o esquema.
- Registrar uma demonstração do cadastro e da consulta de produtos.
- Implementar os fluxos de apontamento de produção e de horas.
