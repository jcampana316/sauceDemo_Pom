@login
Feature: Login usuario

  @login-exitoso
  Scenario Outline: Login exitoso
    Given el usuario se encuentra en la pagina de login
    When el usuario ingresa su usuario "<user>" y contraseña "<password>" validos
    Then el usuario es redirigido al catalogo

    Examples:
    | user | password |
    | standard_user | secret_sauce |

  @logout-exitoso
    Scenario:  Logout exitoso
      Given el usuario se encuentra en la pagina de catalogo
      When el usuario hace click en el boton de menu y selecciona logout
      Then el usuario es redirigido a la pagina de login