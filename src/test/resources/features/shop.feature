@shop
Feature: Shop products

  Background:
    Given el usuario abre la pantalla de login
    When el usuario ingresa su usuario "<user>" y contraseña "<password>" validos
    Examples:
      | user | password |
      | standard_user | secret_sauce |


  Scenario Outline: selecciona productos y lo agrega al carrito
    Given el usuario se encuentra en el catalogo
    When selecciona producto "<product_name>" y lo agrega al carrito
    And accedo al carrito de compras
    Then deberia ver el boton de checkout

    Examples:
      | product_name  |
      | Sauce Labs backpack|
      | Sauce Labs Bike Light|


