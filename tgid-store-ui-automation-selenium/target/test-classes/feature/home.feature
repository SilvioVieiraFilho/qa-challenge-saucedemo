# language: pt

Funcionalidade: Home Page TGID Store

  Cenário: Acessar tela de login ao clicar em Entrar
    Dado que o usuário está na página inicial
    Quando o usuário clica no botão "Entrar"
    Então o sistema deve redirecionar para a tela de login

  Cenário: Navegar para página de produtos
    Dado que o usuário está na página inicial
    Quando o usuário clica no botão "Produtos"
    Então o sistema deve exibir a lista de produtos

  Cenário: Iniciar compra pela home
    Dado que o usuário está na página inicial
    Quando o usuário clica no botão "Comprar agora"
    Então o sistema deve redirecionar para o checkout