@koinalApp
@login

Feature: User should login with valid credentials

  Background:
    Then User verify that koinal is opened

  Scenario: When user send valid credentials, should be login
    When User clicks "LOGIN" button
    And  User writes email address for login
    And  User writes password for login
    And User clicks "LOGIN" button