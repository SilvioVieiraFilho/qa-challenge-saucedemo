# TGID Store Test – Documentação de QA

## Visão geral do projeto

Este projeto contém a documentação de testes realizados no e-commerce TGID Store, uma aplicação web.

O objetivo foi validar funcionalidades do sistema, experiência do usuário, regras de negócio, segurança e consistência dos principais fluxos, como autenticação, navegação, carrinho de compras e checkout.

---

## Informações do sistema

Projeto: TGID Store Test  
Tipo: Aplicação Web de E-commerce  
Ambiente: Web (Firebase Hosting)  
URL: https://tgid-store-test.web.app

Acesso administrativo:  
Email: admin@tgid.com.br  
Senha: admin123

---

## Objetivo dos testes

Os testes tiveram como objetivo:

- Realizar testes exploratórios manuais
- Validar o fluxo completo de compra
- Identificar falhas funcionais e de regras de negócio
- Analisar experiência do usuário e consistência do sistema
- Documentar defeitos de forma estruturada

---

## Estratégia de testes

Foram aplicadas as seguintes abordagens:

- Testes exploratórios
- Testes funcionais
- Testes negativos
- Testes de fluxo ponta a ponta
- Validação de regras de negócio
- Análise de estado de sessão e carrinho

---

## Cenários de teste (Gherkin)

### Login

Scenario: Login com credenciais válidas  
Given o usuário está na tela de login  
When o usuário insere credenciais válidas  
Then o sistema deve autenticar o usuário  
And redirecionar para a página inicial

---

### Carrinho

Scenario: Adicionar produto ao carrinho  
Given o usuário está na página de produtos  
When o usuário adiciona um produto ao carrinho  
Then o contador do carrinho deve ser atualizado corretamente

---

### Checkout

Scenario: Finalizar compra com sucesso  
Given o usuário possui itens no carrinho  
When o usuário finaliza a compra  
Then o sistema deve confirmar o pedido  
And limpar o carrinho

---

## Defeitos identificados

- O sistema permite valores negativos no carrinho
- Finalização de compra com itens inválidos
- Mensagens de erro técnicas do Firebase expostas ao usuário
- Filtro de preço não funciona corretamente
- Ordenação de produtos não funciona corretamente
- Erro ortográfico no botão de checkout
- Falta de validação em campos de endereço (CEP, rua, cidade, estado)
- Carrinho persiste após logout
- Checkout acessível sem autenticação
- Botão de dúvidas frequentes sem ação
- Estoque do produto não é atualizado após compra

---

## Regras de negócio validadas

- O valor total do carrinho é atualizado corretamente
- O carrinho é limpo após a finalização da compra
- O botão de confirmação só é habilitado com dados válidos
- Campos opcionais são tratados corretamente
- O sistema exibe mensagem de sucesso após compra
- O logout encerra corretamente a sessão
- A navegação entre telas funciona corretamente

---

## Resumo da execução

Tipo de teste: Testes manuais exploratórios  
Cobertura: Fluxo completo de e-commerce  
Foco: Funcionalidade, UX, regras de negócio e consistência

---

## Principais resultados

### Pontos positivos

- Fluxo de compra funcional
- Sistema de autenticação funcional
- Carrinho com atualização dinâmica
- Checkout operacional

### Problemas críticos

- Inconsistência de dados no carrinho e estoque
- Falhas em regras de negócio
- Falhas de autenticação em rotas protegidas
- Problemas em filtros e ordenação
- Falta de validação em formulários

---

## Sugestões de melhoria

- Implementar validação para impedir valores negativos no carrinho
- Corrigir sincronização de estoque após compras
- Melhorar mensagens de erro para o usuário final
- Corrigir filtros e ordenação de produtos
- Implementar validação completa de endereço
- Reforçar autenticação em rotas protegidas
- Corrigir inconsistência de sessão no carrinho

---

## Automação de testes (complemento)

Além dos testes manuais, foi desenvolvida uma automação para demonstrar conhecimento técnico em testes de interface web.

## Tecnologias utilizadas

- Selenium WebDriver
- Java
- Cucumber (BDD)
- JUnit
- Page Object Model (POM)

---

## Objetivo da automação

A automação foi criada como complemento ao processo manual, com foco em validar fluxos críticos e demonstrar capacidade técnica em testes regressivos.

---

## Cenários automatizados

- Login na aplicação
- Navegação para produtos
- Adição de itens ao carrinho
- Fluxo de checkout

---

## Como executar os testes Selenium

### Pré-requisitos

- Java instalado
- Maven configurado
- Chrome instalado

---

### Execução

```bash
mvn clean test
```
