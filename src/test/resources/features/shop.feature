@shop
Feature: Shop products

  Background:
    Given el usuario se encuentra en la pagina de login


  Scenario Outline: selecciona productos y lo agrega al carrito
    Given el usuario ingresa credenciales validos
    | user | password |
    | <user> | <password> |
    And el usuario se encuentra en el catalogo
    When selecciona producto "<product_name>" y lo agrega al carrito
    And accedo al carrito de compras
    Then deberia ver el boton de checkout
    And el usuario hace click en el boton de menu y selecciona logout

    Examples:
      | user | password | product_name  |
      | standard_user | secret_sauce | Sauce Labs backpack|
      | standard_user | secret_sauce | Sauce Labs Bike Light|


  Scenario Outline: iniciar checkout y confirmar compra
    Given el usuario ingresa credenciales validos
      | user | password |
      | <user> | <password> |
    And el usuario se encuentra en el catalogo
    When accedo al carrito de compras
    And inicio el proceso de checkout
    And ingreso la informacion del cliente
    | first_name | last_name | postal_code |
    | <first_name> | <last_name> | <postal_code> |
    And finalizo la compra
    Then deberia ver el mensaje de confirmacion de compra
    Examples:
      | user | password | first_name  | last_name | postal_code |
      | standard_user | secret_sauce | Jose | Testing | 55566


