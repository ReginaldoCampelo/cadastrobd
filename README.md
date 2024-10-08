# Projeto de Aplicativo Java para Cadastro com SQL Server

Este projeto é parte da Missão Prática | Nível 3 | Mundo 3, cujo objetivo é desenvolver um aplicativo Java para gerenciamento de cadastros, com persistência de dados em um banco de dados SQL Server. O projeto utiliza o middleware JDBC para acesso ao banco de dados e segue o padrão DAO (Data Access Object) para manuseio dos dados. 

## Objetivos

- Implementar a persistência de dados utilizando JDBC.
- Adotar o padrão DAO para gerenciar o acesso aos dados.
- Implementar o mapeamento objeto-relacional em Java.
- Desenvolver sistemas cadastrais utilizando um banco de dados relacional.

## Requisitos do Projeto

- **Ambiente de Desenvolvimento**: JDK e IDE NetBeans.
- **Banco de Dados**: SQL Server com um banco de dados pré-configurado (loja).
- **Conexão ao Banco**: Configurada via NetBeans e JDBC driver.
- **Equipamentos**: Computador com acesso à Internet, SQL Server Management Studio, e um navegador de Internet como o Chrome.

## Desenvolvimento do Projeto

### Mapeamento Objeto-Relacional e DAO

1. **Configuração do Projeto**:
   - Criar um projeto Java no NetBeans com o nome `CadastroBD`.
   - Adicionar o driver JDBC para SQL Server (`mssql-jdbc-12.2.0.jre11.jar`).
   - Configurar a conexão ao banco de dados no NetBeans.

2. **Criação de Classes Modelo**:
   - **Classe `Pessoa`**: Inclui campos básicos como `id`, `nome`, `logradouro`, `cidade`, `estado`, `telefone`, e `email`.
   - **Classe `PessoaFisica`**: Herda de `Pessoa` e adiciona o campo `cpf`.
   - **Classe `PessoaJuridica`**: Herda de `Pessoa` e adiciona o campo `cnpj`.

3. **Criação de Classes Utilitárias**:
   - **Classe `ConectorBD`**: Fornece métodos para gerenciar conexões com o banco de dados.
   - **Classe `SequenceManager`**: Gerencia a obtenção de valores de sequência.

4. **Implementação do Padrão DAO**:
   - **Classe `PessoaFisicaDAO`**: Métodos para inclusão, alteração, exclusão e consulta de pessoas físicas.
   - **Classe `PessoaJuridicaDAO`**: Métodos para inclusão, alteração, exclusão e consulta de pessoas jurídicas.

5. **Criação da Classe Principal**:
   - **Classe `CadastroBDTeste`**: Executa operações de teste para validar as funcionalidades implementadas.

## Testes e Resultados

- O sistema deve ser testado para verificar a inclusão, alteração, exclusão, e consulta de registros.
- Resultados devem ser verificados no console do NetBeans e no SQL Server Management Studio.

## Relatório de Prática

- Relatórios devem ser submetidos em PDF, incluindo:
  - Título e objetivo da prática.
  - Códigos desenvolvidos e resultados.
  - Análise das tecnologias usadas, como JDBC e DAO.

Este projeto visa aprimorar as habilidades em Java e banco de dados, destacando a importância do uso de middleware e padrões de design para criar aplicações robustas e escaláveis.
