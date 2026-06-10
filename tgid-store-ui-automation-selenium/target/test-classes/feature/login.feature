Feature: Login e Autenticação

  Scenario: Acessar tela de login
    Given que o usuário está na página inicial
    When o usuário clica no botão "Entrar"
    Then o sistema deve redirecionar para a tela de login

  Scenario: Login com credenciais válidas
    Given que o usuário está na tela de login
    When informar email "admin@tgid.com.br"
    And informar senha "admin123"
    And clicar em entrar
    Then o sistema deve autenticar o usuário
    And redirecionar para a página inicial
    And exibir o botão "Sair"