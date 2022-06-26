@koinalApp
@registerPage

Feature: User should be able to register

  Background:
    Then User verify that koinal is opened

  Scenario: When user fill all of blank, should be able to register
    Then User verify all of placeholder and text
      | Your Email Address | Your Password | Re-type your password | REGISTER | LOGIN |
    When User writes email address
    And User writes password
    And User writes retype password
    And User clicks "REGISTER" button