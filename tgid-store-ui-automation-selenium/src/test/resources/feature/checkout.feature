Feature: Checkout

  Scenario: Comprar agora pela página inicial
    Given usuário está na página inicial
    When clicar em "Comprar Agora"
    Then deve ser redirecionado para checkout

  Scenario: Checkout sem produtos no carrinho
    Given usuário está na tela de checkout
    Then botão confirmar pedido deve permanecer desabilitado

  Scenario: Validar campos obrigatórios
    Given usuário está na tela de checkout
    When deixar campos obrigatórios vazios
    Then botão confirmar pedido deve permanecer desabilitado

  @carrinho
  Scenario: Finalizar pedido com sucesso
    Given usuário está na tela de checkout
    When preencher todos os campos obrigatórios
    And confirmar pedido
    Then pedido deve ser finalizado com sucesso
    And exibir mensagem de confirmação