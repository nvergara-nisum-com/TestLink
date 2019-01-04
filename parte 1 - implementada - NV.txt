Feature: Login en linkedin

Background:
    Given Somos usuarios
    And Ingresamos a la aplicacion

Scenario: Hacer login correcto
    When Escribimos usuario y password
    Then login correcto
    
Scenario: Hacer login incorrecto
    When Escribimos usuario y password incorrectos
    Then login no hecho